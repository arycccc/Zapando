package ar.edu.proyectosort.zapando;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PerfilMatcheadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_matcheado);
    }

    public void link(View v) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=lT8ep_YGcvA");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
