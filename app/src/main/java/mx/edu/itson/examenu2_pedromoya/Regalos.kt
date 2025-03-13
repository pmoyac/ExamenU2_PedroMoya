package mx.edu.itson.examenu2_pedromoya

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Regalos : AppCompatActivity() {
    var adapter: AdaptadorProductos? = null
    var menu: ArrayList<Detalles> = ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_regalos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = AdaptadorProductos(this, menu)
        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)
        var grid: GridView = findViewById(R.id.gv)

        grid.adapter = adapter

    }

    fun  agregarProductos(option: String?){
        when(option){
            "DETALLES"-> {
                menu.add(Detalles(R.drawable.cumplebotanas, "280"))
                menu.add(Detalles(R.drawable.cumplecheve, "320"))
                menu.add(Detalles(R.drawable.cumpleescolar, "330"))
                menu.add(Detalles(R.drawable.cumplepaletas, "190"))
                menu.add(Detalles(R.drawable.cumplesnack, "150"))
                menu.add(Detalles(R.drawable.cumplevinos, "370"))

            } "GLOBOS" ->{
                menu.add(Detalles(R.drawable.globoamor, "240"))
                menu.add(Detalles(R.drawable.globocumple, "820"))
                menu.add(Detalles(R.drawable.globofestejo, "260"))
                menu.add(Detalles(R.drawable.globonum, "760"))
                menu.add(Detalles(R.drawable.globoregalo, "450"))
                menu.add(Detalles(R.drawable.globos, "240"))
            } "PELUCHES" -> {
                menu.add((Detalles(R.drawable.peluchemario, "320")))
                menu.add((Detalles(R.drawable.pelucheminecraft, "320")))
                menu.add((Detalles(R.drawable.peluchepeppa, "290")))
                menu.add((Detalles(R.drawable.peluches, "400")))
                menu.add((Detalles(R.drawable.peluchesony, "330")))
                menu.add((Detalles(R.drawable.peluchestich, "280")))
                menu.add((Detalles(R.drawable.peluchevarios, "195")))
            } "REGALOS" -> {
                menu.add(Detalles(R.drawable.regaloazul, "80"))
                menu.add(Detalles(R.drawable.regalobebe, "290"))
                menu.add(Detalles(R.drawable.regalocajas, "140"))
                menu.add(Detalles(R.drawable.regalocolores, "85"))
                menu.add(Detalles(R.drawable.regalos, "250"))
                menu.add(Detalles(R.drawable.regalovarios, "75"))
            } "TAZAS" -> {
            menu.add(Detalles(R.drawable.tazaabuela, "120"))
            menu.add(Detalles(R.drawable.tazalove, "120"))
            menu.add(Detalles(R.drawable.tazaquiero, "260"))
            menu.add(Detalles(R.drawable.tazas, "280"))
            }
        }
    }


class AdaptadorProductos : BaseAdapter {
    var productos = ArrayList<Detalles>()
    var contexto: Context?=null

    constructor(contexto : Context, producto : ArrayList<Detalles>){
        this.productos = producto
        this.contexto = contexto
    }

    override fun getCount(): Int {
        return productos.size
    }

    override fun getItem(position: Int): Any {
        return productos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(pe: Int, p1: View?, p2: ViewGroup?): View {
        var producto = productos[pe]
        var inflator = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.info, null)
        var image: ImageView = vista.findViewById(R.id.imginfo)
        var precio: TextView = vista.findViewById(R.id.txtinfo)

        image.setImageResource(producto.image)
        precio.setText(producto.precio)

        image.setOnClickListener(){
            val intento = Intent(contexto, DetalleRegalos::class.java)

            intento.putExtra("image", producto.image)
            intento.putExtra("precio", producto.precio)

            contexto!!.startActivity(intento)
        }
        return vista
        }
    }
}
