package com.example.calculadorajuros;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editCapital, editTaxa, editTempo, editMontante;
    TextView textResultado;
    Button botaoCalcular;
    RadioButton radioJuros, radioMontante, radioCapital, radioTempo;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligando componentes
        editCapital = findViewById(R.id.editCapital);
        editTaxa = findViewById(R.id.editTaxa);
        editTempo = findViewById(R.id.editTempo);
        editMontante = findViewById(R.id.editMontante);
        textResultado = findViewById(R.id.textResultado);
        botaoCalcular = findViewById(R.id.botaoCalcular);

        radioJuros = findViewById(R.id.radioJuros);
        radioMontante = findViewById(R.id.radioMontante);
        radioCapital = findViewById(R.id.radioCapital);
        radioTempo = findViewById(R.id.radioTempo);
        radioGroup = findViewById(R.id.radioGroup);

        // Listener para atualizar os campos com base na seleção
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                atualizarCampos(checkedId);
            }
        });

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }

    private void atualizarCampos(int checkedId) {
        // Habilita todos os campos
        editCapital.setEnabled(true);
        editTaxa.setEnabled(true);
        editTempo.setEnabled(true);
        editMontante.setEnabled(true);

        // Limpa todos os campos desabilitados
        if (checkedId == R.id.radioMontante) {
            editMontante.setEnabled(false);
            editMontante.setText("");
        } else if (checkedId == R.id.radioCapital) {
            editCapital.setEnabled(false);
            editCapital.setText("");
        } else if (checkedId == R.id.radioTempo) {
            editTempo.setEnabled(false);
            editTempo.setText("");
        }
        // Se for calcular Juros, não há campo específico a desativar
    }

    private void calcular() {
        try {
            double capital = getDouble(editCapital);
            double taxa = getDouble(editTaxa) / 100.0;
            int tempo = getInt(editTempo);
            double montante = getDouble(editMontante);

            if (radioJuros.isChecked()) {
                double juros = capital * taxa * tempo;
                textResultado.setText(String.format("Juros: R$ %.2f", juros));
            } else if (radioMontante.isChecked()) {
                double juros = capital * taxa * tempo;
                double resultado = capital + juros;
                textResultado.setText(String.format("Montante: R$ %.2f", resultado));
            } else if (radioCapital.isChecked()) {
                double resultado = (montante - (montante * taxa * tempo)) / (1 - taxa * tempo);
                textResultado.setText(String.format("Capital: R$ %.2f", resultado));
            } else if (radioTempo.isChecked()) {
                double juros = montante - capital;
                int resultado = (int) (juros / (capital * taxa));
                textResultado.setText("Tempo: " + resultado + " meses");
            } else {
                textResultado.setText("Selecione uma opção para calcular.");
            }

        } catch (Exception e) {
            textResultado.setText("Erro nos dados. Preencha os campos corretamente.");
        }
    }

    private double getDouble(EditText campo) {
        String texto = campo.getText().toString();
        if (!texto.isEmpty()) {
            return Double.parseDouble(texto);
        }
        return 0.0;
    }

    private int getInt(EditText campo) {
        String texto = campo.getText().toString();
        if (!texto.isEmpty()) {
            return Integer.parseInt(texto);
        }
        return 0;
    }
}

