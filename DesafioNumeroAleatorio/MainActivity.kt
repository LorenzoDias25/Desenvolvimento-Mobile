package com.example.projetotesteandroid


import android.app.Dialog
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val limiteInferior = findViewById<EditText>(R.id.limiteInferior)
        val limiteSuperior = findViewById<EditText>(R.id.limiteSuperior)
        val btnGerar = findViewById<Button>(R.id.btnGerar)

        btnGerar.setOnClickListener {
            val n1 = Integer.parseInt(limiteInferior.text.toString())
            val n2 = Integer.parseInt(limiteSuperior.text.toString())

            if (n1 < 0){
                Toast.makeText(this, "Limite inferior não pode ser negativo", Toast.LENGTH_SHORT).show()
            } else{
                if (n2 <= n1){
                    Toast.makeText(this, "Limite superior não pode ser menor ou igual ao limite inferior", Toast.LENGTH_SHORT).show()
                } else {
                    val num = Random.nextInt(n1, n2 + 1)
                    mostraNumero(num)
                }
            }
        }


    }

    private fun mostraNumero(num: Int){

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(true)

        val textTitle = dialog.findViewById<TextView>(R.id.textTitle)
        val btnVoltar = dialog.findViewById<Button>(R.id.btnVoltar)

        textTitle.text = "Número gerado: $num"

        btnVoltar.setOnClickListener{
            dialog.dismiss()
        }

        dialog.show()

        dialog.window?.setLayout(
            (resources.displayMetrics.widthPixels * 0.9).toInt(),
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}
