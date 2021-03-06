# SimpleTodo
# Pre-work - *SimpleTodo*

**SimpleTodo** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Laine Grace-Endy**

Time spent: **10** days spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **successfully add and remove items** from the todo list
* [X] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [X] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [X] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://imgur.com/a/3DvZxYX.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />
<img src='https://imgur.com/69sTYX7.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [Imgur](https://www.imgur.com).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** [Interacting with the Android app development platform, it's one of the things that actually impress me. The Android app development platform is not complicated at all, and you feel like you're taking part to a normal studio. The instructions are really helpful. For, I would say it's one of the best platform I ever work on.  ].

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** As the word reflects it, according to me, an adapter is something which links a specific pattern to another one. And when we consider, the fact that it facilitate  a list to display within a view by using the array method. That's such an incredible and a crucial thing. And the convertView method is used to recycle old view objects that are not being used anymore. And the getview is used to display some data, at a specific area or a specific position in Athe data set.

## Notes

I encountered a little chanlenge. So, after running my app a device, the listview overlapped the button and the editText area, then I just went to the program and resize the listView, and that worked perfectly.

## License

    Copyright [2018] [Laine Grace-Endy]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
