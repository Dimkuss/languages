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
    private Spinner mMarginSpinner;
    private Button mOkBtn;
    private static @StyleRes int AppThemeDefault = R.style.Theme_SpinnerLanguages;
    private static @StyleRes int AppThemeMargin = R.style.Margin3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(AppThemeDefault);
        setTheme(AppThemeMargin);
       setContentView(R.layout.activity_main);

        initViews();

    }
    private void initViews() {
        mLangSpinner = findViewById(R.id.languagesSpinner);
        mColorSpinner = findViewById(R.id.colorspinner);
        mMarginSpinner = findViewById(R.id.marginspinner);
        mOkBtn = findViewById(R.id.okBtn);
        
        initSpinnerLang();
//        initSpinnerColor();

}
    private void initSpinnerLang(){
        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
mLangSpinner.setAdapter(adapterLang);
        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(this, R.array.color, android.R.layout.simple_spinner_item);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mColorSpinner.setAdapter(adapterColor);
        ArrayAdapter<CharSequence> adapterMargin = ArrayAdapter.createFromResource(this, R.array.margin, android.R.layout.simple_spinner_item);
        adapterMargin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMarginSpinner.setAdapter(adapterMargin);


        mOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (mLangSpinner.getSelectedItem().toString().equals("Русский")) {
                Locale locale = new Locale("ru");
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

            } if (mLangSpinner.getSelectedItem().toString().equals("English")) {

                     Locale locale = new Locale("en");
                     Configuration config = new Configuration();
                     config.setLocale(locale);
                     getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

             }
                if (mColorSpinner.getSelectedItem().toString().equals("Зеленый")){
                    AppThemeDefault = R.style.AppThemeGreen;

                }
                if (mColorSpinner.getSelectedItem().toString().equals("Черный")){
                    AppThemeDefault = R.style.AppThemeBlack;

                }
                if (mColorSpinner.getSelectedItem().toString().equals("Синий")){
                    AppThemeDefault = R.style.AppThemeBlue;

                }
                if (mMarginSpinner.getSelectedItem().toString().equals("Большие")){
                    AppThemeMargin = R.style.Margin1;}
                if (mMarginSpinner.getSelectedItem().toString().equals("Средние")){
                    AppThemeMargin = R.style.Margin2;}
                if (mMarginSpinner.getSelectedItem().toString().equals("Мелкие")){
                    AppThemeMargin = R.style.Margin3;}
                recreate();
             }

        });

}

}
