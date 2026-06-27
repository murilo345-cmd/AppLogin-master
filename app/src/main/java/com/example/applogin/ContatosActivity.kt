package com.example.applogin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContatosActivity : AppCompatActivity() {

    private val whatsappNumero = "5511987654321"   // formato internacional sem espaços/traços
    private val emailPortaria  = "portaria@example.com"
    private val telefoneNumero = "1187654321"
    private val ramalNumero    = "100"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contatos)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val toolbar = findViewById<Toolbar>(R.id.toolbarContatos)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }




        findViewById<LinearLayout>(R.id.llWhatsapp).setOnClickListener {
            val uri = Uri.parse("https://wa.me/$whatsappNumero")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }


        findViewById<LinearLayout>(R.id.llEmail).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$emailPortaria")
                putExtra(Intent.EXTRA_SUBJECT, "Contato via App")
            }
            startActivity(Intent.createChooser(intent, "Enviar e-mail"))
        }


        findViewById<LinearLayout>(R.id.llTelefone).setOnClickListener {
            val uri = Uri.parse("tel:$telefoneNumero")
            startActivity(Intent(Intent.ACTION_DIAL, uri))
        }


        findViewById<LinearLayout>(R.id.llRamal).setOnClickListener {
            val uri = Uri.parse("tel:$ramalNumero")
            startActivity(Intent(Intent.ACTION_DIAL, uri))
        }
    }
}