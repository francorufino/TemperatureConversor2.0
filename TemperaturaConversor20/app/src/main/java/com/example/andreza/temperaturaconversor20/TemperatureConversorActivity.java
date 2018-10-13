package com.example.andreza.temperaturaconversor20;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//TODO FIX O TOAST DAS BOTH TEMPERATURES CANNOT BE THE SAME = CENTRALIZAR
//TODO FIX O BOTAO CALCULAR QDO A STRING EH NULL
//TODO REPENSAR COMO QUERO O RESULTADO DA CONVERSAO, SE EH EM TOAST OU EH APARECENDO NA TELA;

public class TemperatureConversorActivity extends AppCompatActivity {
    private TextView temperatureTyped;
    private String deTemp;
    private String paraTemp;
    private Button setDeTemp;
    private Button setParaTemp;
    private Button clear;
    private TextView textNulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_conversor);
        temperatureTyped = findViewById(R.id.edit_text_temperatureTyped_id);
    }

    public Boolean textoNulo() {
        if (temperatureTyped.getText().toString() != null) {
            return true;
        } else {
            Toast.makeText(this, "Please type a temperature to be converted", Toast.LENGTH_LONG).show();
            return false;
        }
    }


// selecioando e setando a medida de temperatura inicial
    public void setDeTemp (View view) {
            Button btnTemperaturaInicial = ((Button) view);
            if (btnTemperaturaInicial.getText().toString().contains("F")) {
                ((Button) findViewById(R.id.btn1_Farenheit)).setBackground(getResources().getDrawable(R.color.azulclaro));
                ((Button) findViewById(R.id.btn1_Celsius)).setBackground(getResources().getDrawable(R.color.verdeclaro));
                deTemp = "F";
            } else {
                ((Button) findViewById(R.id.btn1_Celsius)).setBackground(getResources().getDrawable(R.color.azulclaro));
                ((Button) findViewById(R.id.btn1_Farenheit)).setBackground(getResources().getDrawable(R.color.verdeclaro));
                deTemp = "C";
            }
        }


//    selecionando  e setando a medida de temperatura final
    public void setParaTemp (View view) {
            Button btnTemperaturaFinal = ((Button) view);

            if (btnTemperaturaFinal.getText().toString().contains("C")) {
                ((Button) findViewById(R.id.btn2_Celsius)).setBackground(getResources().getDrawable(R.color.azulclaro));
                ((Button) findViewById(R.id.btn2_Farenheit)).setBackground(getResources().getDrawable(R.color.verdeclaro));

                paraTemp = "C";
            } else {
                ((Button) findViewById(R.id.btn2_Farenheit)).setBackground(getResources().getDrawable(R.color.azulclaro));
                ((Button) findViewById(R.id.btn2_Celsius)).setBackground(getResources().getDrawable(R.color.verdeclaro));
                paraTemp = "F";
            }
        }

    public void converter(View view) {

        float tempInicial = Float.parseFloat(temperatureTyped.getText().toString());

            if (textoNulo() == true) {
                if (deTemp == "F" && paraTemp == "C") {
                    Float tempFinal = converterParaCelsius(tempInicial);
                    Toast.makeText(this, tempFinal.toString(), Toast.LENGTH_LONG).show();
                } else if (deTemp == "C" && paraTemp == "F") {
                    Float tempoFinal = converterParaFahrenheit(tempInicial);
                    Toast.makeText(this, tempoFinal.toString(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Both temperatures cannot be the same, please try again", Toast.LENGTH_LONG).show();
                }
            }
            }


    public float converterParaCelsius(float temperaturaInicial){
        return (temperaturaInicial - 32) * 5/9;
    }

    public float converterParaFahrenheit(float temperaturaInicial){
       return (temperaturaInicial * 9/5) + 32;
    }

    public void botaoClearClicado(View view){
        temperatureTyped.setText("");
        ((Button)findViewById(R.id.btn1_Celsius)).setBackground(getResources().getDrawable(R.color.verdeclaro));
        ((Button)findViewById(R.id.btn1_Farenheit)).setBackground(getResources().getDrawable(R.color.verdeclaro));
        ((Button)findViewById(R.id.btn2_Celsius)).setBackground(getResources().getDrawable(R.color.verdeclaro));
        ((Button)findViewById(R.id.btn2_Farenheit)).setBackground(getResources().getDrawable(R.color.verdeclaro));
    }
}

////        pegar numero digitado - gettext - to string
////        linkar o xml com o java = id
////        pegar o botao clicado - on click
////        chamar a funcao da conta de conversao - if && - para celsius e p fahrenheit
////        retornar na tela o resultado - sout ou toast
//
//
//
//[11:37 AM, 10/12/2018] Guilherme. Professor. Mobile. DH. BR: A lógica tá bem legal! Um conselho é você colocar no XML, no EditText o seguinte atributo
//        inputType="number"
//        [11:38 AM, 10/12/2018] Guilherme. Professor. Mobile. DH. BR: Aí você vai poder tirar aquela verificação das letras
//        [11:41 AM, 10/12/2018] Guilherme. Professor. Mobile. DH. BR: O if so verificaria se o usuário não deixou o campo vazio
//        [11:42 AM, 10/12/2018] Guilherme. Professor. Mobile. DH. BR: Aí, você poderia fazer esse método "textoNulo()" devolvendo um boolean e usar esse método em um outro If
//        [11:43 AM, 10/12/2018] Guilherme. Professor. Mobile. DH. BR: E seria legal você verificar se o usuário já selecionou uma medida de temperatura também, porque se ele
// não tiver selecionado o app vai crashar também
//
