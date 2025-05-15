package com.example.projetotesteandroid

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkSuco = findViewById<CheckBox>(R.id.checkSuco)
        val radioGroupFrutas = findViewById<RadioGroup>(R.id.radioGroupFrutas)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val etNumeroQuarto = findViewById<EditText>(R.id.etNumeroQuarto)

        checkSuco.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                radioGroupFrutas.visibility = View.VISIBLE
                radioGroupFrutas.isEnabled = true
            } else {
                radioGroupFrutas.visibility = View.GONE
                radioGroupFrutas.isEnabled = false
                radioGroupFrutas.clearCheck()
            }
        }

        btnSalvar.setOnClickListener {
            val numeroQuarto = etNumeroQuarto.text.toString()
            if (numeroQuarto.isBlank()) {
                Toast.makeText(this, "Digite o número do quarto", Toast.LENGTH_SHORT).show()
            } else {
                mostrarDialogoConfirmacao(numeroQuarto)
            }
        }
    }

    private fun mostrarDialogoConfirmacao(numeroQuarto: String) {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(true)

        val tvDialogTitle = dialog.findViewById<TextView>(R.id.tvDialogTitle)
        val tvDialogMessage = dialog.findViewById<TextView>(R.id.tvDialogMessage)
        val btnSim = dialog.findViewById<Button>(R.id.btnSim)
        val btnNao = dialog.findViewById<Button>(R.id.btnNao)

        tvDialogTitle.text = "Quarto: $numeroQuarto"

        val mensagem = StringBuilder()

        if (findViewById<CheckBox>(R.id.checkCafe).isChecked) {
            mensagem.append("• CAFÉ\n")
        }
        if (findViewById<CheckBox>(R.id.checkLeite).isChecked) {
            mensagem.append("• LEITE\n")
        }
        if (findViewById<CheckBox>(R.id.checkSuco).isChecked) {
            mensagem.append("• SUCO\n")
            val selectedFruitId = findViewById<RadioGroup>(R.id.radioGroupFrutas).checkedRadioButtonId
            if (selectedFruitId != -1) {
                val selectedFruit = findViewById<RadioButton>(selectedFruitId)
                mensagem.append("  Fruta escolhida: ${selectedFruit.text}\n")
            }
        }

        if (findViewById<CheckBox>(R.id.checkIntolerancia).isChecked) {
            mensagem.append("• Intolerância a lactose\n")
        }
        if (findViewById<CheckBox>(R.id.checkAlergia).isChecked) {
            mensagem.append("• Alergia ao glúten\n")
        }

        tvDialogMessage.text = if (mensagem.isNotEmpty()) mensagem.toString() else "Nenhuma opção selecionada"

        btnSim.setOnClickListener {
            Toast.makeText(this, "Pedido confirmado para o quarto $numeroQuarto", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        btnNao.setOnClickListener {
            Toast.makeText(this, "Confirmação cancelada", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()

        dialog.window?.setLayout(
            (resources.displayMetrics.widthPixels * 0.9).toInt(),
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}
