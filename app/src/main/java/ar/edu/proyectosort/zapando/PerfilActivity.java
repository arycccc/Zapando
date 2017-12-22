package ar.edu.proyectosort.zapando;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PerfilActivity extends AppCompatActivity {

    TextView nom,ape,descrip,edad;
    String nombre,apellido,descripcion,fecha,video;

    final Context context = this;

    private SharedPreferences sharedPref;
    public String session;
    public JSONObject user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        sharedPref = getSharedPreferences("ZAPANDO", Context.MODE_PRIVATE);
        session = sharedPref.getString("SESSION", "");

        try {
            user = new JSONObject(session);
            nombre = user.getString("firstname");
            apellido = user.getString("lastname");;
            descripcion = user.getString("description");;
            fecha = user.getString("birth");;
            video = user.getString("video");
        } catch (JSONException e) {
            e.printStackTrace();
        }



        nom = (TextView) findViewById(R.id.firstname);
        ape = (TextView) findViewById(R.id.lastname);
        descrip = (TextView) findViewById(R.id.description);
        edad = (TextView) findViewById(R.id.birth);

        nom.setText("Nombre: " + nombre);
        ape.setText("Apellido: " + apellido);
        descrip.setText(descripcion);
        edad.setText("Edad: " + fecha);

    }

    public void mivideo(View v) {
        Uri uri = Uri.parse(video);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
