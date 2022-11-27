package com.example.pert3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView inputCity; // AutoCompleteTextView memerlukan adapter untuk memasukkan data
    Spinner inputHobby; // Begitu juga dengan spinner yang memerlukn adapter untuk memasukkan data
    EditText inputName;
    RadioGroup inputGender;
    RadioButton pilihGender;
    CheckBox inputAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputCity = findViewById(R.id.inputCity);
        inputHobby = findViewById(R.id.inputHobby);
        inputName = findViewById(R.id.inputName);
        inputGender = findViewById(R.id.inputGender);
        inputAgree = findViewById(R.id.inputAgree);

        String [] namaKota = {"Jakarta", "Bekasi", "Tangerang Kota", "Tangerang Selatan", "Bogor", "Depok"};
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, namaKota);
        inputCity.setAdapter(arrayAdapter);

        String [] namaHobby = {"Menyanyi", "Berenang", "Gaming", "Tidur", "Makan", "Belajar"};
        ArrayAdapter <String> arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, namaHobby);
        inputHobby.setAdapter(arrayAdapter2);

        // sejenis pop-up
        Toast.makeText(this, "ini fungsi onCreate", Toast.LENGTH_LONG).show();
    }

    public void send(View view) {
        // mempersiapkan atau inisiasi builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Konfirmasi").setMessage("Apakah anda yakin dengan data yang diisi?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = inputName.getText().toString();
                pilihGender = findViewById(inputGender.getCheckedRadioButtonId());
                String gender = pilihGender.getText().toString();
                String city = inputCity.getText().toString();
                String hobby = inputHobby.getSelectedItem().toString();
                String agree = inputAgree.isChecked() ? "Setuju" : "Tidak";

                Intent openActivity = new Intent(MainActivity.this, MainActivity2.class);
                openActivity.putExtra("name", name);
                openActivity.putExtra("gender", gender);
                openActivity.putExtra("city", city);
                openActivity.putExtra("hobby", hobby);
                openActivity.putExtra("agree", agree);
                startActivity(openActivity);

                Toast.makeText(MainActivity.this, "Baik, data dikonfirmasi", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        // membuat builder
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}