package br.unisanta.cadastro_de_alunos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.unisanta.cadastro_de_alunos.model.Aluno
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNomeA = findViewById<EditText>(R.id.edt_nome_aluno)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabMostrar = findViewById<FloatingActionButton>(R.id.fab_mostra)
        var alu = Aluno("")

        btnCadastrar.setOnClickListener{
            val nome = edtNomeA.text.toString()
            alu = Aluno(nome)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Cadastro Ok!")
            val dialog = builder.create()
            dialog.show()
            edtNomeA.text.clear()
        }
        fabMostrar.setOnClickListener {
            val intent = Intent(this, AlunoActivity::class.java)
            intent.putExtra("aluno", alu.nomeAluno)
            startActivity(intent)
        }
    }
}