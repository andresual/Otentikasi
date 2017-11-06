package com.andresual.dev.otentikasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.andresual.dev.otentikasi.adapter.ListPengujianAirAdapter;
import com.andresual.dev.otentikasi.data.DbLocalHelper;
import com.andresual.dev.otentikasi.model.JenisAir;

import java.util.List;

public class AirActivity extends AppCompatActivity {

    private ListView lvJenisAir;
    private ListPengujianAirAdapter airAdapter;
    private List<JenisAir> mJenisAirList;
    private DbLocalHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air);

        lvJenisAir = (ListView) findViewById(R.id.lv_air);
        mDbHelper = new DbLocalHelper(this);

        mJenisAirList = mDbHelper.getJenisAir();
        airAdapter = new ListPengujianAirAdapter(this, mJenisAirList);
        lvJenisAir.setAdapter(airAdapter);
    }
}
