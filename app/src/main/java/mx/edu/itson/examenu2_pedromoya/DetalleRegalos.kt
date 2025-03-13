package mx.edu.itson.examenu2_pedromoya

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleRegalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_regalos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var img: ImageView = findViewById(R.id.iv_regalo_imagen)
        var precio: TextView = findViewById(R.id.tv_regalo_precio)

        val bundle = intent.extras

        if (bundle != null){
            img.setImageResource(bundle.getInt("image"))
            precio.setText(bundle.getString("precio"))


        }

    }
}