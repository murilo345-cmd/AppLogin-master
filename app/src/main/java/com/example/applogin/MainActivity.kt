package com.example.applogin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.novoprojeto.applogin.network.ApiClient
import com.example.applogin.model.Login
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val apiService = ApiClient.instance

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnLogin = findViewById<Button>(R.id.btnlogin)
        btnLogin.setOnClickListener {

            val email = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
            val senha = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
            val login = Login(email = email, senha = senha)
            val logar = Intent(this, HomeActivity::class.java)

            apiService.autenticar(login).enqueue(object  : Callback<Boolean>{
                override fun onResponse(
                    call: Call<Boolean?>,
                    response: Response<Boolean?>
                ) {
                    if(response.isSuccessful){
                    val autenticado = response.body()
                    if (autenticado == true){
                        startActivity(logar)
                    }else{
                        Toast.makeText(this@MainActivity, "Usuário ou senha inválido", Toast.LENGTH_LONG).show()
                    }
                    }
                }

                override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()

                }

            })
            //val intent = Intent(this, HomeActivity::class.java)
            //startActivity(intent)




        }
        val btnCadastro = findViewById<Button>(R.id.button4)
        btnCadastro.setOnClickListener {
            val intent = Intent(this, CadastroLogin::class.java)
            startActivity(intent)
        }

    }
}


