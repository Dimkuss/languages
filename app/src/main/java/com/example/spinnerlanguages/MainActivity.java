package com.example.spinnerlanguages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner mLangSpinner;
    private Button mOkBtn;
    private TextView choose;
    private TextView hello;
    private String lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
    private void initViews() {
        mLangSpinner = findViewById(R.id.languagesSpinner);
        mOkBtn = findViewById(R.id.okBtn);
        choose = findViewById(R.id.chooseLang);
        hello = findViewById(R.id.welcome);
        initSpinnerLang();

}
    private void initSpinnerLang(){
        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
mLangSpinner.setAdapter(adapterLang);


        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (mLangSpinner.getSelectedItem().toString().equals("Русский")) {
                Locale locale = new Locale("ru");
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            } else {

                     Locale locale = new Locale("en");
                     Configuration config = new Configuration();
                     config.setLocale(locale);
                     getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                     recreate();
             }

             }

        });
}
    }
