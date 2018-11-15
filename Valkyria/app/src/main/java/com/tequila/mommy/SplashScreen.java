package com.tequila.mommy;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;
import me.anwarshahriar.calligrapher.Calligrapher;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Typeface futura = Typeface.createFromAsset(getAssets(),Constants.FUTURA);


        EasySplashScreen easySplashScreen = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withLogo(R.drawable.mama)
                .withFooterText(getString(R.string.name))
                .withAfterLogoText(getString(R.string.app_name));


        //Set Text Color

        easySplashScreen.getFooterTextView().setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        easySplashScreen.getFooterTextView().setTypeface(futura);
        easySplashScreen.getFooterTextView().setTextSize(18);
        easySplashScreen.getAfterLogoTextView().setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        easySplashScreen.getAfterLogoTextView().setTypeface(futura);
        easySplashScreen.getAfterLogoTextView().setTextSize(36);


        //Set to View
        View view =  easySplashScreen.create();

        //Set View to Content View

        setContentView(view);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, Constants.FUTURA, true);


    }
}
