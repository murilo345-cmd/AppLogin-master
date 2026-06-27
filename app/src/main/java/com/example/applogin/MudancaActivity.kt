package com.example.applogin

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MudancaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mudanca)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbarMudanca)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val etNome = findViewById<EditText>(R.id.etNomeResponsavel)
        val etApartamento = findViewById<EditText>(R.id.etNumeroApartamento)
        val etData = findViewById<EditText>(R.id.etDataMudanca)
        val etTipo = findViewById<EditText>(R.id.etTipoMudanca)
        val tvMensagem = findViewById<TextView>(R.id.tvMensagemMudanca)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrarMudanca)

        btnCadastrar.setOnClickListener {
            val nome = etNome.text.toString().trim()
            val apartamento = etApartamento.text.toString().trim()
            val data = etData.text.toString().trim()
            val tipo = etTipo.text.toString().trim()

            if (nome.isEmpty() || apartamento.isEmpty() || data.isEmpty() || tipo.isEmpty()) {
                tvMensagem.text = "Preencha todos os campos!"
                tvMensagem.setBackgroundColor(android.graphics.Color.parseColor("#D32F2F"))
                tvMensagem.visibility = View.VISIBLE
            } else {
                tvMensagem.text = "Cadastro realizado com sucesso"
                tvMensagem.setBackgroundColor(android.graphics.Color.parseColor("#222222"))
                tvMensagem.visibility = View.VISIBLE

                // Limpa os campos após cadastro
                etNome.text.clear()
                etApartamento.text.clear()
                etData.text.clear()
                etTipo.text.clear()
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