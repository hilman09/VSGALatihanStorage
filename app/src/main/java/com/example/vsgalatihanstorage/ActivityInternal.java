package com.example.vsgalatihanstorage;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ActivityInternal extends AppCompatActivity implements OnClickListener {
    public static final String FILENAME = "namafile.txt";
    Button buatFile, ubahFile, bacaFile, hapusFile;
    TextView textBaca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);

        buatFile = findViewById(R.id.buttonBuatFile);
        ubahFile = findViewById(R.id.buttonUbahFile);
        bacaFile = findViewById(R.id.buttonBacaFile);
        hapusFile = findViewById(R.id.buttonHapusFile);
        textBaca = findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        hapusFile.setOnClickListener(this);

    }

    void buatFile(){
        String isiFile = "welcome to Internal Storage";
        File file = new File(getFilesDir(), FILENAME);
        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void ubahFile(){
        String merubahFile = " data berhasil di ubah";
        File file = new File (getFilesDir(), FILENAME);
        FileOutputStream outputStream = null;
        try {
            if(file.exists());
            outputStream = new FileOutputStream(file, true);
            outputStream.write(merubahFile.getBytes());
            outputStream.flush();
            outputStream.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    void bacaFile(){
        File file = new File (getFilesDir(), FILENAME);
        if(file.exists()){
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader( new FileReader(file));
                String line = br.readLine();

                while (line != null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e){
                e.printStackTrace();
            }
            textBaca.setText(text.toString());
        }else{
            textBaca.setText(R.string.file_not_found);
        }

    }
    void hapusFile(){
        File file = new File(getFilesDir(),FILENAME);
        if (file.exists()) {
            file.delete();
            Toast.makeText( this, "File Berhasil Dihaous", Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public void onClick(View v) { jalankan(v.getId());}

    private void jalankan(int id) {
        switch (id){
            case R.id.buttonBuatFile:
                buatFile();
                break;
            case R.id.buttonUbahFile:
                ubahFile();
                break;
            case R.id.buttonBacaFile:
                bacaFile();
                break;
            case R.id.buttonHapusFile:
                hapusFile();
                break;
        }
    }
}