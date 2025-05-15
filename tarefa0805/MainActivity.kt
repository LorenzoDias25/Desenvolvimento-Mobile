class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkSuco = findViewById<CheckBox>(R.id.checkSuco)
        val radioGroupFrutas = findViewById<RadioGroup>(R.id.radioGroupFrutas)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val etNumeroQuarto = findViewById<EditText>(R.id.etNumeroQuarto)

        // Controle do RadioGroup de frutas
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

        // Ação do botão Salvar
        btnSalvar.setOnClickListener {
            val numeroQuarto = etNumeroQuarto.text.toString()
            if (numeroQuarto.isBlank()) {
                Toast.makeText(this, "Por favor, digite o número do quarto", Toast.LENGTH_SHORT).show()
            } else {
                mostrarDialogoConfirmacao(numeroQuarto)
            }
        }
    }

    private fun mostrarDialogoConfirmacao(numeroQuarto: String) {
        // Criar o diálogo
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.setCancelable(true)

        // Configurar os elementos do diálogo
        val tvDialogTitle = dialog.findViewById<TextView>(R.id.tvDialogTitle)
        val tvDialogMessage = dialog.findViewById<TextView>(R.id.tvDialogMessage)
        val btnSim = dialog.findViewById<Button>(R.id.btnSim)
        val btnNao = dialog.findViewById<Button>(R.id.btnNao)

        // Definir o título com o número do quarto
        tvDialogTitle.text = "Quarto: $numeroQuarto"

        // Construir a mensagem com as escolhas
        val mensagem = StringBuilder()
        
        // Opções de café da manhã
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
        
        // Condições de saúde
        if (findViewById<CheckBox>(R.id.checkIntolerancia).isChecked) {
            mensagem.append("• Intolerância a lactose\n")
        }
        if (findViewById<CheckBox>(R.id.checkAlergia).isChecked) {
            mensagem.append("• ALERGIA AO GLÚTEN\n")
        }
        
        tvDialogMessage.text = if (mensagem.isNotEmpty()) mensagem.toString() else "Nenhuma opção selecionada"

        // Ações dos botões
        btnSim.setOnClickListener {
            Toast.makeText(this, "Pedido confirmado para o quarto $numeroQuarto", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        btnNao.setOnClickListener {
            Toast.makeText(this, "Confirmação cancelada", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        // Mostrar o diálogo
        dialog.show()
        
        // Ajustar o tamanho do diálogo
        dialog.window?.setLayout(
            (resources.displayMetrics.widthPixels * 0.9).toInt(),
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}
