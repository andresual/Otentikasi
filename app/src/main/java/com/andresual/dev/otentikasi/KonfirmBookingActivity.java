package com.andresual.dev.otentikasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class KonfirmBookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirm_booking);

        //mendapatkan data berbentuk string dari booking activity
        TextView tvAtasNama = (TextView) findViewById(R.id.tv_konfirm_atas_nama);
        TextView tvJenisIndustri = (TextView) findViewById(R.id.tv_konfirm_jenis_industri);
        TextView tvNamaIndustri = (TextView) findViewById(R.id.tv_konfirm_nama_industri);
        TextView tvNoTelp = (TextView) findViewById(R.id.tv_konfirm_no_telp);
        TextView tvAlamat = (TextView) findViewById(R.id.tv_konfirm_alamat);
        TextView tvTanggalPengambilan = (TextView) findViewById(R.id.tv_konfirm_tanggal_pengambilan);
        TextView tvAreaPengambilan = (TextView) findViewById(R.id.tv_konfirm_area_menjemputan);

        //textView kejelasan

        Intent i = getIntent();
        Bundle bd = i.getExtras();

        if (bd != null) {
            String getNama = (String) bd.get("atasNama");
            tvAtasNama.setText(getNama);

            String getJenisIndustri = (String) bd.get("jenisIndustri");
            tvJenisIndustri.setText(getJenisIndustri);

            String getNamaIndustri = (String) bd.get("namaIndustri");
            tvNamaIndustri.setText(getNamaIndustri);

            String getNoTelp = (String) bd.get("telp");
            tvNoTelp.setText(getNoTelp);

            String getAlamat = (String) bd.get("alamat");
            tvAlamat.setText(getAlamat);

            String getTanggalPengambilan = (String) bd.get("tanggal");
            tvTanggalPengambilan.setText(getTanggalPengambilan);

            String getAreaPengambilan = (String) bd.get("areaPenjemputan");
            tvAreaPengambilan.setText(getAreaPengambilan);
        }
    }
}
