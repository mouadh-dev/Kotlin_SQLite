package com.example.sqliteproject.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sqliteproject.Util.BaseConstant

class DBHelper(context: Context, factory:SQLiteDatabase.CursorFactory?):
SQLiteOpenHelper(context,BaseConstant.instance().DATABASE_NAME,factory, BaseConstant.instance().DATABASE_VERSION){

    //Create a new database by sqlite query
    override fun onCreate(db: SQLiteDatabase?) {
        val query = ("CREATE TABLE " + BaseConstant.instance().TABLE_NAME + " ("
                + BaseConstant.instance().ID_COL + "INTEGER PRIMARY KEY, " + BaseConstant.instance().NAME_COl
                 + " TEXT," + BaseConstant.instance().AGE_COL + " TEXT" + ")")

        //execute query
        db?.apply {
            execSQL(query)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.apply {
            execSQL("DROP TABLE IF EXISTS " + BaseConstant.instance().TABLE_NAME)
        }
        onCreate(db)
    }

    fun addName(name: String, age: String){

        //Create content values variables
        val values = ContentValues()

        values.put(BaseConstant.instance().NAME_COl, name)
        values.put(BaseConstant.instance().AGE_COL, age)

        val db = this.writableDatabase
        db.insert(BaseConstant.instance().TABLE_NAME, null, values)
        db.close()
    }

    fun getName(): Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + BaseConstant.instance().TABLE_NAME, null)
    }
}