package com.example.applogin

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AutorizacaoActivity : AppCompatActivity() {

    private var dataSelecionada: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_autorizacao)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbarAutorizacao)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etNome = findViewById<EditText>(R.id.etNome)
        val etDocumento = findViewById<EditText>(R.id.etDocumento)
        val etApartamento = findViewById<EditText>(R.id.etApartamento)
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val tvMensagem = findViewById<TextView>(R.id.tvMensagem)
        val btnSalvar = findViewById<Button>(R.id.btnSalvarAutorizacao)

        // Captura a data selecionada no calendário
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            dataSelecionada = "$dayOfMonth/${month + 1}/$year"
        }

        btnSalvar.setOnClickListener {
            val nome = etNome.text.toString().trim()
            val documento = etDocumento.text.toString().trim()
            val apartamento = etApartamento.text.toString().trim()

            tvMensagem.visibility = View.VISIBLE

            if (nome.isEmpty() || documento.isEmpty() || apartamento.isEmpty()) {
                // Erro — campos obrigatórios não preenchidos
                tvMensagem.text = "❌ Todos os dados são obrigatórios"
                tvMensagem.setBackgroundColor(android.graphics.Color.parseColor("#D32F2F"))
            } else {
                // Sucesso
                tvMensagem.text = "✅ Autorização realizada com sucesso"
                tvMensagem.setBackgroundColor(android.graphics.Color.parseColor("#388E3C"))
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}