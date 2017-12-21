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

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_matcheado);

        texto = (TextView) findViewById(R.id.firstname);
    //    String nombre = getIntent().getStringExtra("nombre");
    //    texto.setText(nombre);

    }


    public void link(View v) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=lT8ep_YGcvA");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
