package ar.edu.proyectosort.zapando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    TextView nom,ape,descrip,edad;
    String nombre,apellido,descripcion,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nom = (TextView) findViewById(R.id.firstname);
        ape = (TextView) findViewById(R.id.lastname);
        descrip = (TextView) findViewById(R.id.description);
        edad = (TextView) findViewById(R.id.birth);

        nom.setText(nombre);
        ape.setText(apellido);
        descrip.setText(descripcion);
        edad.setText(fecha);

    }

}
