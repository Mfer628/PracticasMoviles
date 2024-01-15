package com.example.loginsqlite

import java.lang.ref.SoftReference
import javax.sql.StatementEvent

class Usuario {
    var id: Int = 0
    var nombre:String=""
    var apellido:String = ""
    var edad:Int = 0;
    var email:String = ""
    var password:String = ""
    constructor(nombre:String, apellido:String , edad:Int, email: String , password:String ){
        this.nombre=nombre
        this.apellido = apellido
        this.edad = edad
        this.email = email
        this.password = password
    }
    constructor(){

    }
}