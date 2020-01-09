package id.ac.poliban.mi.agustyae020317079;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationContext();

        Switch Sw = findViewById(R.id.sw);
        EditText etNama = findViewById(R.id.etNama);
        EditText etNim = findViewById(R.id.etNim);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText etTelp = findViewById(R.id.etTelp);
        Button btClear = findViewById(R.id.btClear);
        Button btSubmit = findViewById(R.id.btSubmit);
        RadioGroup rgGender = findViewById(R.id.rgGender);
        RadioButton rbLaki = findViewById(R.id.rbLaki);
        RadioButton rbPr = findViewById(R.id.rbPr);
        Switch sw = findViewById(R.id.sw);

        Sw.setOnCheckedChangeListener((buttonView, isCheked)-> {
                    if (Sw.isChecked()) {
                        etNama.setEnabled(true);
                        etNim.setEnabled(true);
                        etAlamat.setEnabled(true);
                        etTelp.setEnabled(true);
                        rgGender.setEnabled(true);
                    } else {
                        etNama.setEnabled(false);
                        etNim.setEnabled(false);
                        etAlamat.setEnabled(false);
                        etTelp.setEnabled(false);
                        rgGender.setEnabled(false);
                    }
                });
        btSubmit.setOnClickListener(v -> {
                String gender = "";
                if (rbLaki.isChecked()){
                    gender+= "Laki-laki";
                }
            if (rbPr.isChecked()) {
                gender += "Perempuan";
            }

        new AlertDialog.Builder(this)
        .setTitle("Info")
        .setMessage( "NIM : "+etNim.getText().toString()+"\n"+
                    "NAMA : "+etNama.getText().toString()+"\n"+
                    "GENDER : "+gender.toString()+"\n"+
                    "ALAMAT : "+etAlamat.getText().toString()+"\n"+
                    "TELP : "+etTelp.getText().toString()
        )
        .setNegativeButton("Cancel", null)
        .setPositiveButton("OK", null).show();
    });

        btClear.setOnClickListener(v -> {
            etAlamat.setText("");
            etNama.setText("");
            etNim.setText("");
            etTelp.setText("");
            rgGender.clearCheck();
        });

    }
}
