package com.goopam.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EditItemActivity extends AppCompatActivity {

    private TextView TodoDescription;
    public Button buttonSave;
    ArrayList<String> items;
    private String  myString = "Item Edited";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        if (getSupportActionBar() !=null)  {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        TodoDescription = (TextView) findViewById(R.id.editText2);
            buttonSave = (Button) findViewById(R.id.btnSaveItem);
                Intent intent = getIntent();
        String text = intent.getExtras().getString("text");
        String action = intent.getAction();
        String type = intent.getType();

        TodoDescription.setText(text);

  /**
        buttonSave.setOnClickListener(new View.OnClickListener(){

            @Nullable
            public final View.OnClickListener getOnClickListener() {
                return null;
            }


            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_SHORT).show();

                EditText resaveItem = (EditText) findViewById(R.id.editText2);
                Button saveButton = (Button) findViewById(R.id.btnSaveItem);
                // Prepare data intent
                Intent data = new Intent();
                int code = data.getExtras().getInt("code", 0);
                data.putExtra("text", resaveItem.getText().toString());
                data.putExtra("code", 200);
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes the activity, pass data to parent

            }




        });
  **/


    }

    //Here we Go


    public void onSubmit(View v) {
        EditText TodoDescription = (EditText) findViewById(R.id.editText2);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("text", TodoDescription.getText().toString());
        int TodoIndex = getIntent().getIntExtra("position", 0);
        data.putExtra("position", TodoIndex); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish();
        Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_SHORT).show();
         // closes the activity, pass data to parent
    }






    public boolean onCreateOptionMenu (Menu menu) {
        //Inflate the menu;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            finish();
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
