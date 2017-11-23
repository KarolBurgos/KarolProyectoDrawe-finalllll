package com.example.sistemas.karolproyectoandroid;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    public Marker marcador;
    public double lat = 0.0;
    public double lon = 0.0;
    private TextView titulo_lugar1,titulo_n,titulo_c,hora_c;

    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mapa, container, false);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    public void agregarmark(double lat, double lon) {
        LatLng coor = new LatLng(lat, lon);
        CameraUpdate miubicacion = CameraUpdateFactory.newLatLngZoom(coor, 16);
        if (marcador != null) marcador.remove();
        {
            marcador = mMap.addMarker(new MarkerOptions().position(coor).title("tu estas aqui"));
            mMap.animateCamera(miubicacion);
        }
    }

    public void actualizarubicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lon = location.getLongitude();
            agregarmark(lat, lon);

        }
    }


}
