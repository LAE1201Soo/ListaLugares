package com.example.listalugares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    var lugares = arrayOf("Tequila","Magdalena","Arenal","Guadalajara","Guzman","Sayula","Vallarta","Amatitan",
        "Zacoalco","Chetumal", "SAN jOSE","Hostotipaquillo","Tala")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.list_view_lugares)
        val adaptador = ArrayAdapter(this,R.layout.list_item,lugares)
        listView.adapter = adaptador

        // Agregar TextView en la parte inferior
        val textoSeleccionado: TextView = findViewById(R.id.txtlugar)

        listView.onItemClickListener = object:AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val item = listView.getItemAtPosition(p2) as String
                Log.e("valor lista", item)
                Toast.makeText(applicationContext, "el valor es $item",Toast.LENGTH_LONG).show()

                // Actualizar el texto del TextView con el valor seleccionado
                textoSeleccionado.text = "Usted ha seleccionado: $item"
            }
        }
    }
}

