
package com.example.proyectotercerparcial

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class UsuarioDialog : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        val builder = AlertDialog.Builder(activity)

        //Metodos del objeto Builder
        builder.setMessage("Usuario y contraseña Incorrecta ")
            .setPositiveButton("ok"){ dialogInterface, i ->
               mostar_mensaje("No puedes Continuar");
            }
            .setNegativeButton(""){ dialogInterface, i ->
                mostar_mensaje("Ok");
            }
        return builder.create()
    }

    fun mostar_mensaje(msj:String){
        val toast = Toast.makeText(activity,msj,Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0 ,0)
        toast.show()
    }



}