package com.example.elementosvisuales3
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.DialogFragment
class EstudianteDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
       // return super.onCreateDialog(savedInstanceState)
        //Alert Dialog Osea es una pantalla que tiene 2 botones  uno de si y otro de no
        val builder =AlertDialog.Builder(activity)
        //Metodos del objeto builder

        builder.setMessage("¿Eres estudiante de IDS?")
            .setPositiveButton("Si"){ dialogInterface, i ->
                mostar_mensaje("Si es estudiante de IDS")
            }//Despues del positivo se crea el negativo

            .setNegativeButton("No") {dialogInterface, i ->
                mostar_mensaje("No eres estudiante de IDS")
            }
        return builder.create()
    }
fun mostar_mensaje(msj:String){
    val toast = Toast.makeText(activity,msj,Toast.LENGTH_LONG)
    toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0 ,0)
    toast.show()

}

}