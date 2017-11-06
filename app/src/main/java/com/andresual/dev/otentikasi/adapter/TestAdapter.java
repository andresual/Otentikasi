package com.andresual.dev.otentikasi.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.andresual.dev.otentikasi.data.DbLocalHelper;

import junit.framework.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by andresual on 8/31/2017.
 */

public class TestAdapter {
    protected static final String TAG = "DataAdapter";

    private Context mContext;
    private SQLiteDatabase mDb;
    private DbLocalHelper mDbHelper;

    public TestAdapter(Context context) {
        this.mContext = context;
        mDbHelper = new DbLocalHelper(mContext);
    }

    public TestAdapter createDatabase() throws SQLException {
        try {
            mDbHelper.createDatabase();
        } catch (IOException mIOException) {
            Log.e(TAG, mIOException.toString() + "Unable to create database");
            throw new Error("Unable to create database");
        }
        return this;
    }

    public TestAdapter open() throws Exception {
        try {
            mDbHelper.openDatabase();
            mDbHelper.close();
            mDbHelper.getReadableDatabase();
        } catch (Exception mSQLException) {
            Log.e(TAG, "Open >>" + mSQLException.toString());
        }
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public Cursor getTestData() {
        try {
            String sql = "SELECT * FROM jenis_industri";
            Cursor mCursor = mDb.rawQuery(sql, null);
            if (mCursor != null) {
                mCursor.moveToNext();
            }
            return mCursor;
        } catch (Exception mSQLException) {
            Log.e(TAG, "Get Test Data >>" + mSQLException.toString());
            throw mSQLException;
        }
    }
}
