package com.example.calculadoraimc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculadora extends AppCompatActivity {

    private Button calcular;
    private Button limpar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);

        calcular = findViewById(R.id.calcular);
        limpar = findViewById(R.id.limpar);

        EditText peso = findViewById(R.id.textPeso);
        EditText altura = findViewById(R.id.textAltura);

        limpar.setOnClickListener(view ->{
            peso.setText("");
            altura.setText("");
        });

        calcular.setOnClickListener(view ->{
            String pesoS = peso.getText().toString();
            String alturaS = altura.getText().toString();
            float pesonum = Float.parseFloat(pesoS);
            float alturanum = Float.parseFloat(alturaS);
            float result = pesonum/(alturanum*alturanum);

            if (result <18.5){
                Intent telaImc = new Intent(this, AbaixoDoPeso.class);
                telaImc.putExtra("resultado", result);

                startActivity(telaImc);
            }
            else if (result >= 18.5 && result <25) {
                Intent telaImc = new Intent(this, pesoNormal.class);
                telaImc.putExtra("resultado", result);
                startActivity(telaImc);
            }
            else if (result >= 25 && result <30) {
                Intent telaImc = new Intent(this, sobrePeso.class);
                telaImc.putExtra("resultado", result);
                startActivity(telaImc);
            }
            else if (result >= 30 && result <35) {
                Intent telaImc = new Intent(this, obesidade1.class);
                telaImc.putExtra("resultado", result);
                startActivity(telaImc);
            }
            else if (result >= 35 && result <40) {
                Intent telaImc = new Intent(this, obesidade2.class);
                telaImc.putExtra("resultado", result);
                startActivity(telaImc);
            }
            else if (result >= 40) {
                Intent telaImc = new Intent(this, obesidade3.class);
                telaImc.putExtra("resultado", result);
                startActivity(telaImc);
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}