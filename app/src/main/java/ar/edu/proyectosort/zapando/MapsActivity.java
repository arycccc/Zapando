package ar.edu.proyectosort.zapando;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng centro = new LatLng(-34.58997592789819, -58.448853492736816);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(centro));
        mMap.setMinZoomPreference(12.0f);

        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.55309750000001, -58.46514400000001)).title("Sala de ensayos Rosas Negras"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.57824600000001, -58.437276)).title("Estacion Lunar Sala de Ensayo"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.5858291, -58.42017150000004)).title("Salas de Ensayo Dos de Corazones"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.6020693, -58.41450710000004)).title("LongPlay Salas de ensayo"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.6142797, -58.397105899999985)).title("El Palacio Salas de Ensayo"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.589694, -58.43272999999999)).title("Palermo Vintage Escuela de musica y salas de ensayo"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.606824,-58.4139811)).title("Salas de Ensayo Gallo"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.5737823,-58.485344199999986)).title("Salas de Ensayo Cayo Hueso"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.5836411,-58.4759808)).title("Salas de ensayo Cachavacha"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.62843550000001,-58.438208299999985)).title("Taller Urbano - Sala de ensayo"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.6087191,-58.46193349999999)).title("Sala de Ensayo Lalala"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.6061733,-58.46604830000001)).title("Salas de Ensayo BigBang"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-34.6094742,-58.48322970000004)).title("La Cripta Sala de Ensayos"));

    }
}
