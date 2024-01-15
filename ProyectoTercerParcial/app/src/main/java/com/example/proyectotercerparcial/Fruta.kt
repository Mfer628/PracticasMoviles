package com.example.proyectotercerparcial

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon

class Fruta {

     private var Nombre : String =""
     //public var cant: Int = 0
      private var Imagen : Drawable?


     constructor(Nombre: String, Imagen: Drawable?) {
          this.Nombre = Nombre
          this.Imagen = Imagen
     }


     fun getNombre (): String{
              return this.Nombre
          }
     fun getImagen(): Drawable? {
          return this.Imagen
     }

          fun setNombre (_Nombre :String) {
          this.Nombre= _Nombre;
          }

     fun setImagen(_Imagen: Drawable?) {
          this.Imagen = _Imagen
     }



}