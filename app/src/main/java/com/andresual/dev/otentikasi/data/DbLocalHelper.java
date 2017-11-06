package com.andresual.dev.otentikasi.data;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.andresual.dev.otentikasi.model.JenisAir;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresual on 8/24/2017.
 */

public class DbLocalHelper extends SQLiteOpenHelper {

    public static String TAG = "DbLocalHelper";
    public static String DB_PATH = "data/data/com.andresual.dev.otentikasi/databases";
    public static String DB_NAME = "DBMaster.db";
    public static int DB_VERSION = 1;
    private SQLiteDatabase myDb;
    private final Context myContext;

    public DbLocalHelper(Context context) {
        super(context, DB_NAME, null, 1);
        if (Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.myContext = context;
    }

    public void createDatabase() throws IOException {
        boolean dbExist = checkDatabase();

        if (!dbExist) {
            //do nothing karena db exist
            this.getReadableDatabase();
            this.close();

            try {
                copyDatabase();
                Log.e(TAG, "Database created");
            } catch (IOException mIOException) {
                throw new Error("Error copying database");
            }
        }
    }

    //cek ketersediaan database pada /data/data/

    private boolean checkDatabase() {

        //SQLiteDatabase checkDb = null;

        //try {
        //    String myPath = DB_PATH + DB_NAME;
        //    checkDb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        //} catch (SQLiteException e) {
            //db tidak exist
        //}

        //if (checkDb != null) {
        //    checkDb.close();
        //}

        //return checkDb != null ? true : false;

        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();

    }

    private void copyDatabase() throws IOException {
        //buka local db as input stream
        InputStream myInputStream = myContext.getAssets().open(DB_NAME);

        //path untuk membuat db kosong
        String outFileName = DB_PATH + DB_NAME;

        //membuka db kosong menjadi output stream
        OutputStream myOutputStream = new FileOutputStream(outFileName);

        //transfer byte from input files to output files
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInputStream.read(buffer)) > 0) {
            myOutputStream.write(buffer, 0, length);
        }

        //close stream
        myOutputStream.flush();
        myOutputStream.close();
        myInputStream.close();
    }

    public boolean openDatabase() throws SQLiteException {
        //buka database
        String myPath = DB_PATH + DB_NAME;
        myDb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return myDb != null;
    }

    @Override
    public synchronized void close() {
        if (myDb != null)
            myDb.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST");
        onCreate(db);
    }

    public List<JenisAir> getJenisAir() {
        JenisAir jenisAir = null;
        List<JenisAir> jenisAirList = new ArrayList<>();
        openDatabase();
        Cursor cursor = myDb.rawQuery("SELECT * FROM pengujian", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            jenisAir = new JenisAir(cursor.getInt(0), cursor.getString(1));
            jenisAirList.add(jenisAir);
            cursor.moveToNext();
        }
        cursor.close();
        return jenisAirList;
    }

}