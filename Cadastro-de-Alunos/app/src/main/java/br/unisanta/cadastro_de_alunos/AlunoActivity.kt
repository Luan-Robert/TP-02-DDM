package br.unisanta.cadastro_de_alunos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class AlunoActivity : AppCompatActivity(R.layout.activity_aluno) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)
        val btnMatricular = findViewById<Button>(R.id.btn_matricular)
        val txvResultadoMatricula = findViewById<TextView>(R.id.txv_resultado_matricula)

        val aluno = intent.getStringExtra("aluno")
        txvResultadoMatricula.text = "Nome do Aluno: $aluno"

        btnMatricular.setOnClickListener {
            gerarMatricula(aluno, txvResultadoMatricula)
        }

        fabVolta.setOnClickListener {
            finish()
        }
    }
    fun gerarMatricula(nome: String?, resultadoTextView: TextView) {
        if (nome.isNullOrBlank()) {
            resultadoTextView.text = "Erro: Nome do aluno não foi encontrado."
            return
        }
        val numeroMatricula = Random.nextInt(100000, 999999)

        val resultado = "Nome: $nome\nMatrícula: $numeroMatricula"
        resultadoTextView.text = resultado
    }
}