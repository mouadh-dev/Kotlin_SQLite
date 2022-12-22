package com.example.sqliteproject.Ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqliteproject.R
import com.example.sqliteproject.Util.BaseConstant
import com.example.sqliteproject.databinding.ActivityMainBinding
import com.example.sqliteproject.repository.DBHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    @SuppressLint("Range")
    private fun initView() {
        binding.addName.setOnClickListener{
            val db = DBHelper(this, null)
            val name = binding.enterName.text.toString()
            val age = binding.enterAge.text.toString()

//            calling method to add to the database
            db.addName(name, age)
            Toast.makeText(this, name + "add to database", Toast.LENGTH_SHORT).show()

            binding.enterName.text.clear()
            binding.enterAge.text.clear()
        }

        binding.printName.setOnClickListener {

            //creatye dbHelper and passing context to it
            val db = DBHelper(this, null)

            val cursor = db.getName()

            cursor!!.moveToFirst()
            binding.name.append(cursor.getString(cursor.getColumnIndex(BaseConstant.instance().NAME_COl)) + "\n")
            binding.age.append(cursor.getString(cursor.getColumnIndex(BaseConstant.instance().AGE_COL)) + "\n")

            while (cursor.moveToNext()){
                binding.name.append(cursor.getString(cursor.getColumnIndex(BaseConstant.instance().NAME_COl)) + "\n")
                binding.age.append(cursor.getString(cursor.getColumnIndex(BaseConstant.instance().AGE_COL)) + "\n")
            }
            cursor.close()
        }
    }

}