package com.andresual.dev.otentikasi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.andresual.dev.otentikasi.R;
import com.andresual.dev.otentikasi.model.JenisAir;

import java.util.List;

/**
 * Created by andresual on 9/4/2017.
 */

public class ListPengujianAirAdapter extends BaseAdapter {

    private Context mContext;
    private List<JenisAir> mJenisAirList;

    public ListPengujianAirAdapter(Context mContext, List<JenisAir> mJenisAirList) {
        this.mContext = mContext;
        this.mJenisAirList = mJenisAirList;
    }

    @Override
    public int getCount() {
        return mJenisAirList.size();
    }

    @Override
    public Object getItem(int i) {
        return mJenisAirList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mJenisAirList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(mContext, R.layout.item_air, null);
        TextView tvIdJenisAir = (TextView) v.findViewById(R.id.tv_id_jenis_pengujian);
        TextView tvJenisAir = (TextView) v.findViewById(R.id.tv_jenis_pengujian);

        tvIdJenisAir.setText(String.valueOf(mJenisAirList.get(i).getId()));
        tvJenisAir.setText(mJenisAirList.get(i).getJenisPengujianAir());
        return v;
    }
}
