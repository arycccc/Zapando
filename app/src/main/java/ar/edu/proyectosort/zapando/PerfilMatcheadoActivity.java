package ar.edu.proyectosort.zapando;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilMatcheadoActivity extends AppCompatActivity {

    TextView nombre,apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_matcheado);

        nombre = (TextView) findViewById(R.id.firstname);
        apellido = (TextView) findViewById(R.id.lastname);
        String nom = getIntent().getStringExtra("nombre");
        String ape = getIntent().getStringExtra("apellido");
        apellido.setText(ape);
        nombre.setText(nom);

    }


    public void link(View v) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=lT8ep_YGcvA");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
