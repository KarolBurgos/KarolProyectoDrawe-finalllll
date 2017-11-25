package com.example.sistemas.karolproyectoandroid;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    Button btncero,btnuno,btndos,btntres,btncuatro,btncinco,btnseis,btnsiete,btn0cho,btnnueve,btnpunto,
    btnigual,btnsuma,btnresta,btnmulti,btndiv,btnlimpiar;

    EditText elproceso,elconcatenar;
    private FragmentActivity myContext;
    Double nume1,num2,resultado;
    String  operador;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_inicio, container, false);

        btncero= (Button) view.findViewById(R.id.profesores);



        btncero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // elconcatenar =(EditText)view.findViewById(R.id.proceso);
                //elproceso.setText(elconcatenar.getText().toString()+"9");
                Fragment fragment = null;
                Class fragmentClass= SegundoFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


            }
        });

        return view;
    }

    public void  btnce(View v){
        String cap=elproceso.getText().toString();
        cap=cap+"0";
        elproceso.setText(cap);
    }
    @Override
    public void onAttach(Context context) {

        myContext=(FragmentActivity) context;
        super.onAttach(context);
        }


}
