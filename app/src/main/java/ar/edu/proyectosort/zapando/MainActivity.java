package ar.edu.proyectosort.zapando;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

        //youtube
        String claveYoutube="AIzaSyATHCsKsfUrrbq-T2B7kmbflycSotmY2DY";
        YouTubePlayerView youTubePlayerView;
        //youtube finish
/*
         //login
        final Context context = this;
        final String server = "http://zapando.proyectosort.edu.ar";

        private SharedPreferences sharedPref;
        public String session;
        //login finish
*/
        //ListView
        private ListView lvItems;
        private Adaptador adaptador;
        //ListView finish

        private VideoView videoView;
        private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //youtube
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(claveYoutube, this);
        //youtube finish
/*
        //log in
        sharedPref = getSharedPreferences("ANDROID_CLIENT", Context.MODE_PRIVATE);
        session = sharedPref.getString("SESSION", "");

        if (session.isEmpty()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        //login finish
*/
/*
        //ListView
        lvItems = (ListView) findViewById(R.id.lvItems);
        adaptador = new Adaptador(this, GetArrayItems());
        lvItems.setAdapter(adaptador);
        //ListView finish
*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
/*
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        Uri path = Uri.parse("android.resource://ar.edu.proyectosort.zapando/"
                + R.raw.wildlife);
        videoView.setVideoURI(path);
        videoView.start();
*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    } */

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_map) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_matchs) {
            Intent intent = new Intent(this, MatchActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void perfil(View v){
        Intent intent = new Intent(this, PerfilActivity.class);
        startActivity(intent);
    }

    public void like(View v){
        Snackbar snackbar = Snackbar
                .make(v, "LIKE", Snackbar.LENGTH_LONG);
        snackbar.show();
/*
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        Uri path = Uri.parse("android.resource://ar.edu.proyectosort.zapando/"
                + R.raw.notengopito);
        videoView.setVideoURI(path);
        videoView.start();
*/
    }

    public void dislike(View v){
        Snackbar snackbar = Snackbar
                .make(v, "DISLIKE", Snackbar.LENGTH_LONG);
        snackbar.show();
/*
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        Uri path = Uri.parse("android.resource://ar.edu.proyectosort.zapando/"
                + R.raw.riend);
        videoView.setVideoURI(path);
        videoView.start();
*/
    }

    //youtube
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {

        if (!fueRestaurado){
            youTubePlayer.cueVideo("azxDhcKYku4"); //https://www.youtube.com/watch?v=azxDhcKYku4
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else{
            String error = "Error al iniciar Youtube"+youTubeInitializationResult.toString();
            Toast.makeText(getApplication(),error,Toast.LENGTH_LONG).show();
        }

    }

    protected void onActivityResult(int requestCode,int resultCode, Intent data){

        if (requestCode==1){
            getYoutubePlayerProvider().initialize(claveYoutube,this);
        }

    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider(){
        return youTubePlayerView;
    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
    //youtube finish

/*
    //ListView
    private ArrayList<Entidad> GetArrayItems(){
        ArrayList<Entidad> listItems = new ArrayList<>();
        listItems.add(new Entidad(R.drawable.boton_rojo, "Ary", "18"));
        listItems.add(new Entidad(R.drawable.boton_verde, "Marto","18"));

        return listItems;
    }
    //ListView finish
*/
}
