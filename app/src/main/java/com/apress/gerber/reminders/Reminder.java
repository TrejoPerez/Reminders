package com.apress.gerber.reminders;

/**
 * Created by root on 28/12/15.
 */
public class Reminder {
    private int mId;
    private String mContent;
    private int mImportant;

    public Reminder(int mId, String mContent, int mImportant) {
        this.mId = mId;
        this.mContent = mContent;
        this.mImportant = mImportant;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public int getImportant() {
        return mImportant;
    }

    public void setImportant(int mImportant) {
        this.mImportant = mImportant;
    }
}
