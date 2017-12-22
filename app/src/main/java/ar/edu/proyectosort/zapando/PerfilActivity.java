package ar.edu.proyectosort.zapando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class PerfilActivity extends AppCompatActivity {

    //ary
    TextView nom, ape, descrip, edad;
    String nombre, apellido, descripcion, fecha;
//aryfin

    String json_url = "http://zapando.proyectosort.edu.ar/users.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //ary
        nom = (TextView) findViewById(R.id.firstname);
        ape = (TextView) findViewById(R.id.lastname);
        descrip = (TextView) findViewById(R.id.description);
        edad = (TextView) findViewById(R.id.birth);

        //nombre = "";
        apellido = "";
        descripcion = "";
        fecha = "";

        //nom.setText("Nombre: " + nombre);
        ape.setText("Apellido: " + apellido);
        descrip.setText(descripcion);
        edad.setText("Edad: " + fecha);
        //aryfin

    }
    public void caca(View v) {
        JsonObjectRequest JsonObjectRequest = new JsonObjectRequest(Request.Method.GET, json_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            nom.setText(response.getString("firstname"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PerfilActivity.this, "Algo estuvo mal", Toast.LENGTH_SHORT);
                error.printStackTrace();
            }
        });
     MySingleton.getmInstance(PerfilActivity.this).addToRequestque(JsonObjectRequest);
    }
}
