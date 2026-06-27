package com.example.applogin

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applogin.adapter.PrestacaoAdapter
import com.example.applogin.model.Lancamento

class PrestacaoContasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_prestacao_contas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbarPrestacao)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val lancamentos = listOf(
            Lancamento(1, "Compra de material", 500.0, "02/05/2026"),
            Lancamento(2, "Mensalidade condomínio", 1500.0, "05/05/2026"),
            Lancamento(3, "Manutenção elevador", 1200.0, "10/05/2026")
        )

        val rc = findViewById<RecyclerView>(R.id.recyclerPrestacao)
        rc.layoutManager = LinearLayoutManager(this)
        rc.adapter = PrestacaoAdapter(lancamentos)

        findViewById<Button>(R.id.btnAdicionarLancamento).setOnClickListener {
            Toast.makeText(this, "Em breve!", Toast.LENGTH_SHORT).show()
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