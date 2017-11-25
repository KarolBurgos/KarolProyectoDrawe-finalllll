package com.example.sistemas.karolproyectoandroid;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import Datos.datos;
import Models.wifi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    public double lat = 0.0;
    public double lon = 0.0;
    private TextView titulo_lugar1,titulo_n,titulo_c,hora_c;
    private Retrofit retrofit;
    public final static String TAG ="DATOS COLOMBIA";
    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_mapa, container, false);
        return v;
    }
    SupportMapFragment mapFragment;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        retrofit=new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        datos service=retrofit.create(datos.class);
        Call<List<wifi>> municipioCall=service.obtenerListaPeajes();


        municipioCall.enqueue(new Callback<List<wifi>>() {
            @Override
            public void onResponse(Call<List<wifi>> call, Response<List<wifi>> response) {

                if(response.isSuccessful()){
                    List lista=response.body();
                    for(int i=0;i<lista.size();i++){
                        wifi m=(wifi) lista.get(i);
                        //Log.i(TAG,"Nombre: "+m.getAreaConstruida()+" Alcalde: "+m.getAreaTerreno());
                        LatLng sydney = new LatLng(m.getLatitud(),m.getLongitud());
                        mMap.addMarker(new MarkerOptions().position(sydney).title(m.getDireccion()).snippet(m.getDepartamento()
                                +m.getProyecto()+m.getRegion()+m.getZonaInagurada()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,5));
                        //

                        UiSettings uiSettings=mMap.getUiSettings();
                        uiSettings.setScrollGesturesEnabled(true);
                        uiSettings.setTiltGesturesEnabled(true);
                        //brujula
                        uiSettings.setCompassEnabled(true);
                        uiSettings.setZoomGesturesEnabled(true);
                        uiSettings.setRotateGesturesEnabled(true);
                        uiSettings.setAllGesturesEnabled(true);
                        uiSettings.setCompassEnabled(true);
                        uiSettings.setMyLocationButtonEnabled(true);
                        uiSettings.setMapToolbarEnabled(true);



                    }
                }
                else {
                    Log.e(TAG,"onResponse"+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<wifi>> call, Throwable t) {

                Log.e(TAG,"onFailure"+t.getMessage());
            }
        });

    }
}