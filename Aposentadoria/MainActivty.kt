package com.example.projetotesteandroid

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerSexo = findViewById<Spinner>(R.id.spn_sexo)
        val txtIdade = findViewById<EditText>(R.id.txt_idade)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val txtResultado = findViewById<TextView>(R.id.txt_resultado)

        val listaSexo = arrayOf("Masculino", "Feminino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaSexo)
        spinnerSexo.adapter = adapter

        btnCalcular.setOnClickListener {
            val idadeStr = txtIdade.text.toString()
            if (idadeStr.isNotEmpty()) {
                val idade = idadeStr.toInt()
                val sexo = spinnerSexo.selectedItem.toString()
                val resultado = if (sexo == "Masculino") 65 - idade else 60 - idade

                txtResultado.text = if (resultado > 0) {
                    "Faltam $resultado anos para você se aposentar."
                } else {
                    "Você já pode se aposentar!"
                }
            } else {
                txtResultado.text = "Por favor, informe sua idade."
            }
        }
    }
}
