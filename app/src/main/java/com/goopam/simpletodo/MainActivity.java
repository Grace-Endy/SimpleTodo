package com.goopam.simpletodo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EDIT_ITEM = "EDIT_ITEM";
    public static final int REQUEST_RESPONSE = 1;
    ArrayList<String> items;
    private Context mContext;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    String myString;
    String myString2;

    private String Description;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myString = "Edit Item";
        myString2= "Item deleted";
        View view;
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<>();
        readItems();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                Toast.makeText(getApplicationContext(), myString2, Toast.LENGTH_SHORT).show();
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });


        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Nullable
            public final AdapterView.OnItemClickListener getOnItemClickListener() {
                return null;
            }
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), EditItemActivity.class);
                //Passing Data to the Edit Activity
                intent.putExtra("text", items.get(position));
                intent.putExtra("position", position);
                // Start the activity
                startActivityForResult(intent, REQUEST_RESPONSE);
                Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_SHORT).show();
            }




        });

      /**  Toolbar myRealToolbar =(Toolbar) findViewById(R.id.myRealToolbar);
        setSupportActionBar(myRealToolbar);

        getSupportActionBar().setTitle("My SimpleTodo");
        getSupportActionBar().setIcon(getDrawable(R.drawable.icon_toolbar2));
*/
    }

    public boolean onCreateOptionMenu (Menu menu) {
        //Inflate the menu;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && requestCode == REQUEST_RESPONSE) {
            // Extract name value from result extras
            String text = data.getExtras().getString("text");
            int position = data.getExtras().getInt("position", 0);
            itemsAdapter.notifyDataSetChanged();
            items.set(position, text);
            writeItems();
            // Toast the name to display temporarily on screen
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }




    public void onAddItem(View v) {
        EditText etNewItem = (EditText)findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();
    }


        private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
        }

        public void writeItems() {
            File filesDir = getFilesDir();
            File todofile = new File(filesDir, "todo.txt");
            try {
                FileUtils.writeLines(todofile, items);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
