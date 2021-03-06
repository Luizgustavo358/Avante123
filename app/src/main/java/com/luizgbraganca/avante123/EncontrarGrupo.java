package com.luizgbraganca.avante123;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EncontrarGrupo extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private double lat;
    private double lon;
    private LocationManager locationManager;
    private static final String TAG = "MapsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encontrar_grupo);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onResume( )
    {
        super.onResume();

        // ativa GPS
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }// end onResume( )

    @Override
    public void onPause( )
    {
        super.onPause();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.removeUpdates(this);
    }// end onPause( )

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
    public void onMapReady(GoogleMap googleMap)
    {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            mMap = googleMap;

            // adiciona o botao de zoom
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.setMyLocationEnabled(true);
        } catch(SecurityException ex){
            Log.e(TAG, "Error", ex);
        }// end try catch

        //marcaPosicao( );
    }

    public void marcaPosicao( )
    {
        LatLng minhaPosicao = new LatLng(lat, lon);

        mMap.addMarker(new MarkerOptions().position(minhaPosicao).title("Luiz Gustavo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(minhaPosicao));
    }

    @Override
    public void onLocationChanged(Location location)
    {
        lat = location.getLatitude();
        lon = location.getLongitude();
    }// end onLocationChanged( )

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}