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
import com.example.applogin.model.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroLogin : AppCompatActivity() {

    val apiService = ApiClient.instance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var nome = findViewById<EditText>(R.id.editTextNome)
        var cpf = findViewById<EditText>(R.id.editTextCPF)
        var email = findViewById<EditText>(R.id.editTextTextEmail)
        var telefone = findViewById<EditText>(R.id.editTextTelefone)
        var senha = findViewById<EditText>(R.id.editTextTextSenha)
        var confirmesenha = findViewById<EditText>(R.id.editTextConfirmeSenha)
        var btnCadastrar = findViewById<Button>(R.id.buttoncadastro)

      btnCadastrar.setOnClickListener {
          var usuario = Usuario(
              nome = nome.text.toString(),
              cpf = cpf.text.toString(),
              email = email.text.toString(),
              telefone = telefone.text.toString(),
              senha = senha.text.toString()
          )
          cadastroUsuario(usuario)
      }

    }
    fun cadastroUsuario(usuario: Usuario){
        apiService.cadastrarUsuario(usuario).enqueue(
            object : Callback<Usuario>{
                @SuppressLint("ShowToast")
                override fun onResponse(
                    call: Call<Usuario?>, response: Response<Usuario?>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@CadastroLogin, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Usuario?>, t: Throwable) {
                    Toast.makeText(this@CadastroLogin, t.message, Toast.LENGTH_LONG).show()
                }

            })

            }

}