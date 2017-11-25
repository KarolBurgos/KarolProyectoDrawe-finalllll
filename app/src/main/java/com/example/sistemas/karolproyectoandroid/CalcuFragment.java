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
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalcuFragment extends Fragment {

    Button btncero,btnuno,btndos,btntres,btncuatro,btncinco,btnseis,btnsiete,btn0cho,btnnueve,btnpunto,
            btnigual,btnsuma,btnresta,btnmulti,btndiv,btnlimpiar;

    EditText elproceso,elconcatenar;
    private FragmentActivity myContext;
    Double nume1,num2,resultado;
    String  operador;

    public CalcuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_calcu, container, false);

        btncero= (Button) view.findViewById(R.id.btn0);
        btnuno= (Button) view.findViewById(R.id.btn1);
        btndos= (Button) view.findViewById(R.id.btn2);
        btntres= (Button) view.findViewById(R.id.btn3);
        btncuatro= (Button) view.findViewById(R.id.btn4);
        btncinco= (Button) view.findViewById(R.id.btn5);
        btnseis= (Button) view.findViewById(R.id.btn6);
        btnsiete= (Button) view.findViewById(R.id.btn7);
        btn0cho= (Button) view.findViewById(R.id.btn8);
        btnnueve= (Button) view.findViewById(R.id.btn9);
        btnigual= (Button) view.findViewById(R.id.btnigual);
        elproceso=(EditText)view.findViewById(R.id.proceso);
        btnlimpiar=(Button)view.findViewById(R.id.btndel);


        btncero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"0");

            }
        });

        btnuno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"1");

            }
        });

        btndos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"2");

            }
        });
        btntres.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"3");

            }
        });
        btncuatro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"4");

            }
        });
        btncinco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"5");

            }
        });
        btnseis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"6");

            }
        });
        btnsiete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"7");

            }
        });
        btn0cho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"8");

            }
        });
        btnnueve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 elconcatenar =(EditText)view.findViewById(R.id.proceso);
                elproceso.setText(elconcatenar.getText().toString()+"9");


            }
        });
        btnigual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elconcatenar =(EditText)view.findViewById(R.id.proceso);
                num2=Double.parseDouble(elconcatenar.getText().toString());
                if(operador.equals("+")){
                    elproceso.setText("");
                    resultado=nume1+num2;
                }
                if(operador.equals("-")){
                    elproceso.setText("");
                    resultado=nume1-num2;
                }
                if(operador.equals("*")){
                    elproceso.setText("");
                    resultado=nume1*num2;
                }
                if(operador.equals("÷")){
                    elproceso.setText("");
                    if(num2!=0)
                    {
                        resultado=nume1/num2;
                    }
                    else
                    {
                        elproceso.setText("infinito");
                    }
                }

            }
        });

        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                elproceso.setText("");

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