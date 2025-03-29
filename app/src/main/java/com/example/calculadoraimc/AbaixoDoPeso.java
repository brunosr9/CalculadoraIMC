package com.example.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AbaixoDoPeso extends AppCompatActivity {

    private Button btnvoltar;
    private TextView textoMotivacional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_do_peso);
        textoMotivacional = findViewById(R.id.textView2);
        btnvoltar = findViewById(R.id.voltar);
            btnvoltar.setOnClickListener(view ->{
                Intent voltar = new Intent(this, MainActivity.class);
                startActivity(voltar);
            });
            Bundle bundle = getIntent().getExtras();
            Float result = bundle.getFloat("resultado");
            textoMotivacional.setText(result + "        Seu corpo é sua casa, e ele merece cuidado e atenção. Pequenos passos, como uma alimentação equilibrada e um acompanhamento adequado, podem trazer mais energia e vitalidade para o seu dia a dia. Lembre-se: fortalecer-se é um ato de amor próprio!");



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}