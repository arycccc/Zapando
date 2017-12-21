package ar.edu.proyectosort.zapando;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Network;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private RequestQueue queue;

    final Context context = this;
    final String server = "http://zapando.proyectosort.edu.ar";

    public String session;
    public EditText emailEditText;
    public EditText passwordEditText;
    public EditText firstnameEditText;
    public EditText lastnameEditText;
    public EditText birthEditText;
    public EditText videoEditText;
    public EditText descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPref = getSharedPreferences("ZAPANDO", Context.MODE_PRIVATE);

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        BasicNetwork network = new BasicNetwork(new HurlStack());
        queue = new RequestQueue(cache, network);
        queue.start();

        emailEditText = (EditText)findViewById(R.id.email);
        passwordEditText = (EditText)findViewById(R.id.password);

    }

    public void signIn(View v) {
        final String email = emailEditText.getText().toString();
        final String password = passwordEditText.getText().toString();
        final String url = server + "/sessions.php";

        findViewById(R.id.loading).setVisibility(View.VISIBLE);

        StringRequest signinRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("SESSION", response);
                        editor.commit();

                        findViewById(R.id.loading).setVisibility(View.GONE);

                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                findViewById(R.id.loading).setVisibility(View.GONE);

                if (error.networkResponse.statusCode == 403) {
                    Toast toast = Toast.makeText(context, "El usuario o la contraseña son incorrectos", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (error.networkResponse.statusCode == 401) {
                    Toast toast = Toast.makeText(context, "Debe ingresar un correo electrónico y una contraseña", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(context, "Ha ocurrido un error inesperado, vuelva a intentarlo nuevamente", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }) {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        queue.add(signinRequest);
    }

    public void loadSignUp(View v) {
        ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.content_login);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = null;

        layout = inflater.inflate(R.layout.content_login_signup, mainLayout, false);
        layout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                emailEditText = (EditText)findViewById(R.id.email);
                passwordEditText = (EditText)findViewById(R.id.password);
                firstnameEditText = (EditText)findViewById(R.id.firstname);
                lastnameEditText = (EditText)findViewById(R.id.lastname);
                birthEditText = (EditText)findViewById(R.id.birth);
                videoEditText = (EditText)findViewById(R.id.video);
                descriptionEditText = (EditText)findViewById(R.id.description);
            }
            @Override
            public void onViewDetachedFromWindow(View v) {

            }
        });

        mainLayout.removeAllViews();
        mainLayout.addView(layout);
    }

    public void signUp(View v) {
        final String email = emailEditText.getText().toString();
        final String password = passwordEditText.getText().toString();
        final String firstname = firstnameEditText.getText().toString();
        final String lastname = lastnameEditText.getText().toString();
        final String birth = birthEditText.getText().toString();
        final String video = videoEditText.getText().toString();
        final String description = descriptionEditText.getText().toString();
        final String url = server + "/users.php";

        findViewById(R.id.loading).setVisibility(View.VISIBLE);

        StringRequest signinRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("SESSION", response);
                        editor.commit();

                        findViewById(R.id.loading).setVisibility(View.GONE);

                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                findViewById(R.id.loading).setVisibility(View.GONE);

                if (error.networkResponse.statusCode == 409) {
                    Toast toast = Toast.makeText(context, "El usuario ya se encuentra registrado.", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (error.networkResponse.statusCode == 401) {
                    Toast toast = Toast.makeText(context, "Debe ingresar un correo electrónico y una contraseña", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(context, "Ha ocurrido un error inesperado, vuelva a intentarlo nuevamente", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }) {
            protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);
                params.put("firstname", firstname);
                params.put("lastname", lastname);
                params.put("birth", birth);
                params.put("video", video);
                params.put("description", description);

                return params;
            }
        };

        queue.add(signinRequest);
    }

    public void loadSignIn(View v) {
        ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.content_login);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = null;

        layout = inflater.inflate(R.layout.content_login_signin, mainLayout, false);
        layout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                emailEditText = (EditText)findViewById(R.id.email);
                passwordEditText = (EditText)findViewById(R.id.password);
            }
            @Override
            public void onViewDetachedFromWindow(View v) {

            }
        });

        mainLayout.removeAllViews();
        mainLayout.addView(layout);
    }

    @Override
    public void onBackPressed() {}

}
