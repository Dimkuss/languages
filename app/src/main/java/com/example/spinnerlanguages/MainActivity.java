package com.example.spinnerlanguages;

import androidx.annotation.StyleRes;
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
    private Spinner mColorSpinner;
    private Button mOkBtn;
    private static @StyleRes int AppThemeGreen = R.style.AppThemeGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initViews();

    }
    private void initViews() {
        mLangSpinner = findViewById(R.id.languagesSpinner);
        mColorSpinner = findViewById(R.id.colorspinner);
        mOkBtn = findViewById(R.id.okBtn);
        
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
        private void initSpinnerColor(){
            ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
            adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mColorSpinner.setAdapter(adapterLang);
            mOkBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case "Зеленый":
                            Utils.changeToTheme(this, Utils.THEME_DEFAULT);

                }}
            });
    }}
