package com.example.vsgalatihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button internal,external;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internal = findViewById(R.id.internalStorage);
        external = findViewById(R.id.externalStorage);

        internal.setOnClickListener(this);
        external.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.internalStorage){
            startActivity(new Intent( this, ActivityInternal.class));
        } else if (v.getId() == R.id.externalStorage) {
            startActivity(new Intent (this, ActivityExternal.class));
        }

    }
}