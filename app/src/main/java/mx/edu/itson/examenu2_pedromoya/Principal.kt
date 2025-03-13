package mx.edu.itson.examenu2_pedromoya

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnDetalles: Button = findViewById(R.id.btn_detalles) as Button
        var btnGlobos: Button = findViewById(R.id.btn_globos) as Button
        var btnPeluches: Button = findViewById(R.id.btn_peluches) as Button
        var btnRegalos: Button = findViewById(R.id.btn_regalos) as Button
        var btnTazas: Button = findViewById(R.id.btn_tazas) as Button

        btnDetalles.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "DETALLES")
            startActivity(intent)
        }
        btnGlobos.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "GLOBOS")
            startActivity(intent)
        }
        btnPeluches.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "PELUCHES")
            startActivity(intent)
        }
        btnRegalos.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "REGALOS")
            startActivity(intent)
        }
        btnTazas.setOnClickListener{
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "TAZAS")
            startActivity(intent)
        }
    }
}