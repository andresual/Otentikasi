package com.andresual.dev.otentikasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvEmailProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvEmailProfile = (TextView) findViewById(R.id.tvEmailProfile);
        tvEmailProfile.setText(getIntent().getExtras().getString("Email"));
    }

    public void btnBooking(View v) {
        Intent i = new Intent(ProfileActivity.this, BookingActivity.class);
        startActivity(i);
    }

    public void btnAir(View v) {
        Intent i = new Intent(ProfileActivity.this, AirActivity.class);
        startActivity(i);
    }

}
