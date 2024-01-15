package com.example.elementosvisuales3

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.Calendar
import java.util.Date

//Siempre debe de instanciar de Dialog_Fragment
class FechaDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c: Calendar = Calendar.getInstance()
        val year: Int = c.get(Calendar.YEAR)
        val month: Int = c.get(Calendar.MONTH)
        val day: Int = c.get(Calendar.DAY_OF_MONTH)
        //DatePickerDialog
        //requireActivity() Esto nos sirve para dirigirse a la acitividad Tods los dialog deben de tener eso
        val dpd = DatePickerDialog(requireActivity(),DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            val toast: Toast = Toast.makeText(
                activity,
                dayOfMonth.toString() + " " + (monthOfYear + 1) + " " + year,
                Toast.LENGTH_LONG
            )
            toast.setGravity(Gravity.BOTTOM or Gravity.CENTER,0,0)
            toast.show()

        },2024,9,16)

            dpd.show();
            return dpd
        }


    override fun onCancel(dialog: DialogInterface) {
        val toast = Toast.makeText(activity,"El usuario cancelo la accion",Toast.LENGTH_LONG)
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER, 0 ,0)
        toast.show()
        return super.onCancel(dialog)
    }

}