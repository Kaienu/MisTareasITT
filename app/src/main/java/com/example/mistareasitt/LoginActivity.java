package com.example.mistareasitt;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
    }

    public void crearCuenta(View view){
        Toast toast = Toast.makeText(this, "Escríbeme a: kaienu.jp@gmail.com", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,20);
        toast.show();
    }

    public void botonLogin(View view){
        TextInputEditText usuario = (TextInputEditText) findViewById(R.id.usuarioIn);
        TextInputEditText passw = (TextInputEditText) findViewById(R.id.contraIn);

        if(usuario.getText().toString().equalsIgnoreCase("itt") && passw.getText().toString().equalsIgnoreCase("1234") ){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
