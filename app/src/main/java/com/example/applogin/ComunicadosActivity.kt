package com.example.applogin

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applogin.adapter.ComunicadoAdapter
import com.example.applogin.model.Comunicado

class ComunicadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comunicados)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarComunicados)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recycler = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerComunicados)
        recycler.layoutManager = LinearLayoutManager(this)

        val comunicados = listOf(
            Comunicado("Novo Bicicletário"),
            Comunicado("Portão de Veículos"),
            Comunicado("Alarme do Edifício"),
            Comunicado("Festa Junina")
        )
        recycler.adapter = ComunicadoAdapter(comunicados)

        findViewById<android.widget.Button>(R.id.btnVoltar).setOnClickListener {
            finish()
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