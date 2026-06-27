package com.example.applogin

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applogin.adapter.BoletoAdapter
import com.example.applogin.model.Boleto

class BoletoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boleto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbarBoleto = findViewById<Toolbar>(R.id.toolbarBoleto)
        setSupportActionBar(toolbarBoleto)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rc = findViewById<RecyclerView>(R.id.recyclerBoleto)
        rc.layoutManager = LinearLayoutManager(this)

        val boletos = listOf(
            Boleto(id = 1, "Taxa Condominio Abril", 1000.0, "30/06/2026"),
            Boleto(id = 2, "Taxa Condominio Maio", 1000.0, "30/07/2026"),
            Boleto(id = 3, "Taxa Condominio Junho", 1000.0, "30/08/2026"),
            Boleto(id = 4, "Taxa Condominio Julho", 1000.0, "30/09/2026"),
            Boleto(id = 5, "Taxa Condominio Agosto", 1000.0, "30/10/2026"),

        )

        rc.adapter = BoletoAdapter(boletos)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Volta para a tela anterior
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}