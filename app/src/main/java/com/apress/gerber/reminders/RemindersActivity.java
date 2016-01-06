package com.apress.gerber.reminders;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
//          the cursorAdapter (controller) is now updating the listView (view)
//          with data from the db (model)
        mListView.setAdapter(mCursorAdapter);

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
