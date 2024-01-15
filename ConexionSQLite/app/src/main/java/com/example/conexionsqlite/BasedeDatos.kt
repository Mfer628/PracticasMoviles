package com.example.conexionsqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

var BD = "baseDtos"

class BasedeDatos (contexto: Context): SQLiteOpenHelper(contexto, BD, null, 1 ) {
    override fun onCreate(db: SQLiteDatabase?) {
        //Comando para crear  la tabla
        val sql="CREATE TABLE Usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(250), edad Integer)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertarDatos (usuario: Usuario): String{
        // prepara la base de datos para escribir
        val db = this.writableDatabase
        val contenedor = ContentValues()

        contenedor.put("nombre", usuario.nombre)
        contenedor.put("edad" , usuario.edad)



        var resultado  =  db.insert("Usuario", null, contenedor)
        if (resultado == -1.toLong()){
            return "falla en la base de datos"
        }else{
            return "Ah salido todo bien Insert exitoso "
        }
    }
    fun listarDatos ():MutableList<Usuario>{
        val lista:MutableList<Usuario> = ArrayList()
        val db  = this.readableDatabase
        val sql = "select * from Usuario"
        val resultado = db.rawQuery(sql, null)
        if (resultado.moveToFirst()){
            val idColumnIndex = resultado.getColumnIndex("id")
            val nombreColumnIndex = resultado.getColumnIndex("nombre")
            val edadColumnIndex = resultado.getColumnIndex("edad")
            do{
                val usu = Usuario()
                usu.id = resultado.getInt(idColumnIndex)
                usu.nombre = resultado.getString(nombreColumnIndex)
                usu.edad = resultado.getInt(edadColumnIndex)
                lista.add(usu)
            }while (resultado.moveToNext())
            resultado.close()
            db.close()
        }

        return (lista)
    }

    fun actualizar(id:String, nombre:String, edad:Int): String{
        val db = this.writableDatabase
        var contenedor = ContentValues()
        contenedor.put("nombre", nombre)
        contenedor.put("edad", edad)
        var resultado = db.update("Usuario", contenedor, "id=?", arrayOf(id))
        if (resultado > 0){
            return "Actualizacion Realizada"
        }else{
            return "No se actualizo"
        }

    }

    fun borrarDatos (id:String){
        val db = this.writableDatabase
        if (id.length >0 ){
            db.delete("Usuario", "id=?", arrayOf(id))
        }

    }

}