package com.example.appsqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLiteOpenHelper (context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table articulos(codigo int primary key, descripcion text, precio real)")
        db.execSQL("insert into articulos(codigo,descripcion,precio) values(1,'Caramelos',20.5)")

        //db.execSQL("create table usuariologin(id_user int  PRIMARY KEY AUTOINCREMENT NOT NULL, username text NOT NULL,clave_user text NOT NULL)")
        /*Hacemos un insert para tener un valkor insertado como predeterminado*/
        //db.execSQL("insert into usuariologin(username,clave_user) values('admin','admin')")


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

}