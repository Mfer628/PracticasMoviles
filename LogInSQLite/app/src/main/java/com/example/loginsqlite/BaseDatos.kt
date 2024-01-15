package com.example.loginsqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

var BaseDato = "basedatos"

class BaseDatos(contexto: Context): SQLiteOpenHelper(contexto, BaseDato, null,1 ){
    //Comando para crear la tabla
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE Users (id Integer PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(250), apellido VARCHAR(250), edad INTEGER, email VARCHAR(250), password VARCHAR(250))"
        db?.execSQL(sql)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
    fun insertarDatos (user: Usuario): String{
        val db = this.writableDatabase
        val contenedor = ContentValues()

        contenedor.put("nombre", user.nombre)
        contenedor.put("apellido" , user.apellido)
        contenedor.put("edad", user.edad)
        contenedor.put("email", user.email)
        contenedor.put("password",user.password )
        var resultado = db.insert("Users" , null, contenedor)
        if (resultado == -1.toLong()){
            return "falla en la base de datos"
        }else{
            return "ah salido to bien en el  insert"
        }
    }
    fun ListarDatos(): MutableList<Usuario>{
        val lista: MutableList<Usuario> = ArrayList()
        val db = this.readableDatabase
        val sql = "select * from Users"
        val resultado = db.rawQuery(sql, null)

        if (resultado.moveToFirst()){
            val idColumnIndex = resultado.getColumnIndex("id")
            val nombreColumnIndex = resultado.getColumnIndex("nombre")
            val apellidoColumnIndex = resultado.getColumnIndex("apellido")
            val edadColumnIndex = resultado.getColumnIndex("edad")
            val emailColumnIndex = resultado.getColumnIndex("email")
            val passwordColumnIndex = resultado.getColumnIndex("password")

            do{
                val use = Usuario()
                use.id = resultado.getInt(idColumnIndex)
                use.nombre = resultado.getString(nombreColumnIndex)
                use.apellido = resultado.getString(apellidoColumnIndex)
                use.edad = resultado.getInt(edadColumnIndex)
                use.email = resultado.getString(emailColumnIndex)
                use.password = resultado.getString(passwordColumnIndex)
                lista.add(use)
            }while (resultado.moveToNext())
            resultado.close()
            db.close()
        }
        return (lista)

    }
    fun actualizar(id:String, nombre:String, apellido:String ,edad: Int, email:String, password: String ):String{
        val db = this.writableDatabase
        var contenedor = ContentValues()
        contenedor.put("nombre", nombre)
        contenedor.put("apellido" , apellido)
        contenedor.put("edad", edad)
        contenedor.put("email", email)
        contenedor.put("password", password)
        var resultado = db.update("Users", contenedor, "id=?", arrayOf(id))
        if (resultado > 0 ){
            return "Actualizacion Realizada"
        }else{
            return "No se actualizo Correctamente "
        }
    }

    fun borrarDato (id:String){
        var db = this.writableDatabase
        if (id.length > 0){
            db.delete("Users" , "id=?", arrayOf(id))
        }
    }
    fun verificarCredenciales(nombre: String, password: String): Boolean {
        val db = this.readableDatabase
        val consulta = "SELECT 1 FROM Users WHERE nombre = ? AND password = ? LIMIT 1"
        val resultado = db.rawQuery(consulta, arrayOf(nombre, password))

        val seEncontro = resultado.moveToFirst()

        resultado.close()
        db.close()

        return seEncontro
    }

}
