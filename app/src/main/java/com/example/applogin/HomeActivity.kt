package com.example.applogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnBoleto).setOnClickListener {
            startActivity(Intent(this, BoletoActivity::class.java))
        }
        findViewById<Button>(R.id.btnAutorização).setOnClickListener {
            startActivity(Intent(this, AutorizacaoActivity::class.java))
        }
        findViewById<Button>(R.id.btnReserva).setOnClickListener {
            startActivity(Intent(this, ReservaActivity::class.java))
        }
        findViewById<Button>(R.id.btnMural).setOnClickListener {
            startActivity(Intent(this, ComunicadosActivity::class.java))
        }

    }
}