package com.apress.gerber.reminders;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Stack;

public class RemindersActivity extends AppCompatActivity {
    private ListView mListView;
    private RemindersDbAdapter mDbAdapter;
    private RemindersSimpleCursorAdapter mCursorAdapter;


    @Override
    protected void onCreate(Bundle   savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        mListView= (ListView)findViewById(R.id.reminders_list_view);
        //The arrayAdatper is the controller in our
        //model-view-controller relationship. (controller)
        mListView.setDivider(null);
        mDbAdapter = new RemindersDbAdapter(this);
        mDbAdapter.open();
        if (savedInstanceState == null) {
            //Clear all datamDbAdapter.deleteAllReminders();
            //Add some data
            insertSomeReminders();
        }

        Cursor cursor = mDbAdapter.fetchAllReminders();
//        from columns defined in the db
        String[] from = new String[]{RemindersDbAdapter.COL_CONTENT};
//        to the ids view in the layout
        int[] to = new int[]{R.id.row_text};

        mCursorAdapter = new RemindersSimpleCursorAdapter(
//                Context
                RemindersActivity.this,
//                The layout of the row
                R.layout.reminders_row,
//                Cursor
                cursor,
//                From columnds defined in the db
                from,
//                to the ids of views in the layout
                to,
//                flag -not used
                0);
//          the cursorAdapter (controller) is now updating the listView (view)
//          with data from the db (model)
        mListView.setAdapter(mCursorAdapter);
//        when we click an individual item in the listview
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RemindersActivity.this, "clicked " + position,
                        Toast.LENGTH_SHORT).show();
            }


        });


    }

    private void insertSomeReminders() {
//        Refactorizacion de codigo con Ctrl + Alt + M
        mDbAdapter.createReminder("Buy Learn Android Studio", true);
        mDbAdapter.createReminder("Send Dad birthday gift", false);
        mDbAdapter.createReminder("Dinner at the Gage on Friday", false);
        mDbAdapter.createReminder("String squash racket", false);
        mDbAdapter.createReminder("Shovel and salt walkways", false);
        mDbAdapter.createReminder("Prepare Advanced Android syllabus", true);
        mDbAdapter.createReminder("Buy new office chair", false);
        mDbAdapter.createReminder("Call Auto-body shop for quote", false);
        mDbAdapter.createReminder("Renew membership to club", false);
        mDbAdapter.createReminder("Buy new Galaxy Android phone", true);
        mDbAdapter.createReminder("Sell old Android phone - auction", false);
        mDbAdapter.createReminder("Buy new paddles for kayaks", false);
        mDbAdapter.createReminder("Call accountant about tax returns", false);
        mDbAdapter.createReminder("Buy 300,000 shares of Google", false);
        mDbAdapter.createReminder("Call the Dalai Lama back", true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.reminders_menu,menu);
        return true;
    }
    //Remainder of the class listing omitted for brevity
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_new:
//              Crete new reminder
                Log.d(getLocalClassName(),"Create new Reminder");
                return true;
            case R.id.action_exit:
                finish();
                return true;
            default:
                return false;
        }
    }
}
