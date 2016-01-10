package com.apress.gerber.reminders;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by root on 5/01/16.
 */
public class RemindersSimpleCursorAdapter extends SimpleCursorAdapter {
    public RemindersSimpleCursorAdapter(Context context, int layout, Cursor c, String[] from ,
                                        int[] to,int flags){
            super(context,layout,c,from,to,flags);
    };
//    to use a viewholder, you must override the following two methods and define a ViewHolder class

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return super.newView(context, cursor, parent);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);

        ViewHolder holder=(ViewHolder) view.getTag();
        if(holder == null){
            holder = new ViewHolder();
            holder.colImap = cursor.getColumnIndexOrThrow(RemindersDbAdapter.COL_IMPORTANT);
            holder.listTab = view.findViewById(R.id.row_tab);
            view.setTag(holder);
        }
        if(cursor.getInt(holder.colImap)>0){
            holder.listTab.setBackgroundColor(context.getResources().getColor(R.color.orange));
        }else{
            holder.listTab.setBackgroundColor(context.getResources().getColor(R.color.green));
        }

    }
    static class ViewHolder{
//        Store the colomun index
        int colImap;
//        store the view
        View listTab;
    }

}
