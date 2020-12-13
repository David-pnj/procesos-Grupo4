package com.aplication.covsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Faq2Activity extends AppCompatActivity {

    private Switch pregunta1;
    private Switch pregunta2;
    private Switch pregunta3;
    private Switch pregunta4;
    private Switch pregunta5;
    private Switch pregunta6;
    private TextView respuesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq2);

        pregunta1 = (Switch)findViewById(R.id.faqPregunta1);
        pregunta2 = (Switch)findViewById(R.id.faqPregunta2);
        pregunta3 = (Switch)findViewById(R.id.faqPregunta3);
        pregunta4 = (Switch)findViewById(R.id.faqPregunta4);
        pregunta5 = (Switch)findViewById(R.id.faqPregunta5);
        pregunta6 = (Switch)findViewById(R.id.faqPregunta6);
        respuesta = (TextView)findViewById(R.id.faqRespuesta3);





        }


    public void setPregunta1 (View View) {
        if (pregunta1.isChecked()){
            respuesta.setText("Evitan que contagies, pero te puedes contagiar tu.");
        } else if (pregunta2.isChecked()){
            respuesta.setText("Manténgase aislada 14 días a espera de los resultados de la pcr o en " +
                    "caso de no poder hacérsela espere por síntomas.");
        } else if (pregunta3.isChecked()){
            respuesta.setText("Las investigaciones indican que los niños y los adolescentes tienen las mismas " +
                    "probabilidades de infectarse que cualquier otro grupo de edad y pueden " +
                    "propagar la enfermedad.");
        } else if (pregunta4.isChecked()){
            respuesta.setText("No, pero es cierto que si coincides en diversos sintomas podria ser un indicativo de que padeces covid.");
        } else if (pregunta5.isChecked()){
            respuesta.setText("las mascarillas N95,KN95,KF94 o Kf95 son una buena opcion " +
                    "las FFP2 tambien pero las FFP3 estan reservadas para personal sanitario.");
        } else if (pregunta6.isChecked()){
            respuesta.setText("Si te indentificas con alguno de estos grupos perteneces a la poblacion de " +
                    "riesgo personas que tienen más de 60 años, enfermedades cardiovasculares e hipertensión arterial, " +
                    "diabetes, enfermedades pulmonares crónicas, cáncer, inmunodepresión, embarazo.");
        } else
            respuesta.setText("");
    }

    public void Menu (View View){
        Intent menu =new Intent(this, MenuActivity.class);
        startActivity(menu);
    }

}