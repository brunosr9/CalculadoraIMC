package com.example.calculadoraimc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sobrePeso extends AppCompatActivity {

    private Button btnvoltar;
    private TextView textoMotivacional;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobre_peso);

        textoMotivacional = findViewById(R.id.textView2);
        btnvoltar = findViewById(R.id.voltar);
        btnvoltar.setOnClickListener(view ->{
            Intent voltar = new Intent(this, MainActivity.class);
            startActivity(voltar);
        });
        Bundle bundle = getIntent().getExtras();
        Float result = bundle.getFloat("resultado");
        textoMotivacional.setText(result + "       Cada dia é uma nova chance para cuidar de si! Pequenas mudanças trazem grandes resultados: um passo de cada vez, mais movimento, mais escolhas saudáveis. Você é capaz de transformar sua saúde e viver com mais disposição!    ");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}