package com.andresual.dev.otentikasi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] myString;
    private String[] myArea;
    Spinner spJenisIndustri;
    Spinner spAreaPenjemputan;
    String[] datatoDb;
    String[] result_array;
    String selectedItem;
    String selectedArea;
    EditText mAtasNama;
    EditText mNamaIndustri;
    EditText mTelp;
    EditText mAlamat;
    EditText mTanggal;
    Button btnSubmit;
    ImageButton ibKalender;
    int mTahun, mBulan, mHari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //SPINNER//
        ArrayAdapter jenisIndustriAdapter;
        ArrayAdapter areaPenjemputanAdapter;

        spJenisIndustri = (Spinner) findViewById(R.id.sp_jenis_industri);
        spAreaPenjemputan = (Spinner) findViewById(R.id.sp_area_penjemputan);

        Resources res = getResources();
        myString = res.getStringArray(R.array.jenis_industri_array);
        myArea = res.getStringArray(R.array.area_penjemputan_array);

        spJenisIndustri = (Spinner) findViewById(R.id.sp_jenis_industri);
        spAreaPenjemputan = (Spinner) findViewById(R.id.sp_area_penjemputan);

        jenisIndustriAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                myString);
        spJenisIndustri.setAdapter(jenisIndustriAdapter);

        spJenisIndustri.setOnItemSelectedListener(new OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                selectedItem = spJenisIndustri.getSelectedItem().toString();
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        areaPenjemputanAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                myArea);
        spAreaPenjemputan.setAdapter(areaPenjemputanAdapter);

        spAreaPenjemputan.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedArea = spAreaPenjemputan.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mAtasNama = (EditText) findViewById(R.id.et_atas_nama_booking);
        mNamaIndustri = (EditText) findViewById(R.id.et_nama_industri);
        mTelp = (EditText) findViewById(R.id.et_no_telp);
        mAlamat = (EditText) findViewById(R.id.et_alamat_lengkap);
        mTanggal = (EditText) findViewById(R.id.et_tanggal_boking);

        //deklarasi button
        btnSubmit = (Button) findViewById(R.id.btn_submit_booking);
        ibKalender = (ImageButton) findViewById(R.id.ib_tanggal_booking);

        //trigger semua aktivitas
        spJenisIndustri.getId();
        spAreaPenjemputan.getId();
        mAlamat.getText();
        mNamaIndustri.getText();
        mTelp.getText();
        mAtasNama.getText();
        mTanggal.getText();

        ibKalender.setOnClickListener(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BookingActivity.this, KonfirmBookingActivity.class);
                i.putExtra("jenisIndustri", spJenisIndustri.getSelectedItem().toString());
                i.putExtra("areaPenjemputan", spAreaPenjemputan.getSelectedItem().toString());
                i.putExtra("alamat", mAlamat.getText() + " " + "");
                i.putExtra("namaIndustri", mNamaIndustri.getText() + " " + "");
                i.putExtra("telp", mTelp.getText() + " " + "");
                i.putExtra("tanggal", mTanggal.getText() + " " + "");
                i.putExtra("atasNama", mAtasNama.getText() + " " + "");

                startActivity(i);

                //mengirim data ke konfirm booking

            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v == ibKalender) {

            final Calendar calendar = Calendar.getInstance();
            mTahun = calendar.get(Calendar.YEAR);
            mBulan = calendar.get(Calendar.MONTH);
            mHari = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker v, int tahun, int bulan, int hari) {
                            mTanggal.setText(hari + "-" + (bulan + 1) + "-" + tahun);
                        }
                    }, mTahun, mBulan, mHari);
            datePickerDialog.show();
        }
    }
}
