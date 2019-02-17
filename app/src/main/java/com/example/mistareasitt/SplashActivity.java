package com.example.mistareasitt;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {


    private ProgressBar barraProgreso;
    private TextView textoCarga;
    private int estadoProgreso = 0;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Typeface miFuente = Typeface.createFromAsset(getAssets(),"fuente.ttf");
        TextView titulo = (TextView) findViewById(R.id.titulo);
        titulo.setTypeface(miFuente);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.animacion);
        titulo.startAnimation(anim);
        anim.setAnimationListener(this);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        barraProgreso = (ProgressBar) findViewById(R.id.progreso);
        textoCarga = (TextView) findViewById(R.id.texto);
        barraProgreso.setVisibility(View.VISIBLE);
        textoCarga.setVisibility(View.VISIBLE);
        textoCarga.setText("Preparando los Views");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (estadoProgreso < 100) {
                    estadoProgreso++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            barraProgreso.setProgress(estadoProgreso,true);
                            if (estadoProgreso == 40) {
                                textoCarga.setText("Machacando XMLs");
                            } else if (estadoProgreso == 75) {
                                textoCarga.setText("Cargando Login");
                            }
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        lanzar();
                    }
                });
            }
        }).start();

        //
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void lanzar(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
