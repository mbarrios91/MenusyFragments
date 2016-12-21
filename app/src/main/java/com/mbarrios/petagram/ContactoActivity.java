package com.mbarrios.petagram;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mbarrios.petagram.mail.SendMail;

public class ContactoActivity extends AppCompatActivity {
    TextInputEditText nombre, email, mensaje;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        final EditText nombre = (TextInputEditText) findViewById(R.id.nameContacto);
        final EditText email = (TextInputEditText) findViewById(R.id.nameMail);
        EditText mensaje = (TextInputEditText) findViewById(R.id.nameMensaje);
        Button btnEnviar = (Button) findViewById(R.id.buttonMail);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();

                Toast.makeText(getBaseContext(), getResources().getString(R.string.msj_nombre) + " " + nombre.getText() +
                        getResources().getString(R.string.msj_mail) + email.getText() +
                        getResources().getString(R.string.msj), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(ContactoActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }


    public void sendEmail(){

        try{
            SendMail sm = new SendMail(this, email.getText().toString().trim(),
                    nombre.getText().toString().trim(), mensaje.getText().toString().trim());
        }catch (Exception e){
            Toast.makeText(getBaseContext(), getResources().getString(R.string.error_msj), Toast.LENGTH_SHORT);
        }

    }

}
