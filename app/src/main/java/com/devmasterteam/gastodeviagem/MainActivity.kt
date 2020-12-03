package com.devmasterteam.gastodeviagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        SendButton.setOnClickListener {
            if( VerificaVazio() )  {
                try {
                    CalculaGasto(
                        distance.text.toString().toDouble(),
                        price.text.toString().toDouble(),
                        auto.text.toString().toDouble()
                    )
                }catch(e: NumberFormatException){
                    Toast.makeText(this, getString(R.string.numero_correto), Toast.LENGTH_LONG ).show()
                }
            }else{
                Toast.makeText(this, getString(R.string.preencha_todos_campos), Toast.LENGTH_LONG ).show()
            }
        }
    }

    fun CalculaGasto(distance: Double, price: Double, auto: Double) {
        val final = ((distance / auto) * price)
        total.text = "R$ ${"%.2f".format(final)}"
    }

    fun VerificaVazio(): Boolean {
        return (!(distance.text.toString().isEmpty() || distance.text.toString() == "0" || price.text.toString().isEmpty() || price.text.toString() == "0" || auto.text.toString().isEmpty() || auto.text.toString() == "0" ))

    }
}


