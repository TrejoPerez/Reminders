package com.apress.gerber.reminders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Stack;

public class RemindersActivity extends AppCompatActivity {
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        mListView= (ListView)findViewById(R.id.reminders_list_view);
        //The arrayAdatper is the controller in our
        //model-view-controller relationship. (controller)
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                //Context
                this,
                //layout(view)
                R.layout.reminders_row,
                //row(view)
                R.id.row_text,
                //data (model) with bogus data to test our listview
                new String[]{"First Record","Second Record","Third Record"});
        mListView.setAdapter(arrayAdapter);
    }
    //Remainder of the class listing omitted for brevity
}
