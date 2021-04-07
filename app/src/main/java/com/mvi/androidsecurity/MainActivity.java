package com.mvi.androidsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String SECRETS = "secrets";
    private ISharedPreference sharedPreferences;
    private EditText secretNameEditText;
    private EditText secretValueEditText;
    private TextView secretTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secretNameEditText = findViewById(R.id.secretNameEditText);
        secretValueEditText = findViewById(R.id.secretValueEditText);
        secretTextView = findViewById(R.id.secretTextView);
        Button saveBtn = findViewById(R.id.saveBtn);
        Button fetchBtn = findViewById(R.id.fetchBtn);

        sharedPreferences = new SecuredSharedPref(this, SECRETS);

        saveBtn.setOnClickListener(view -> saveSecret());
        fetchBtn.setOnClickListener(view -> fetchSecret());

    }

    private void fetchSecret() {
        String secretName = secretNameEditText.getText().toString();
        secretTextView.setText(sharedPreferences.get(secretName));
    }

    private void saveSecret() {
        String secretName = secretNameEditText.getText().toString();
        String secretValue = secretValueEditText.getText().toString();
        sharedPreferences.put(secretName, secretValue);
    }
}