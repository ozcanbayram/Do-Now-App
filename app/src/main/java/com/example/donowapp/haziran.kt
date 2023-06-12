package com.example.donowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class haziran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haziran)
    }
    fun gunum(view: View){
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun gorevler(view: View){
        val intent = Intent(applicationContext,gorevler::class.java)
        startActivity(intent)
        finish()
    }

    fun takvim(view: View){
        val intent = Intent(applicationContext,takvim::class.java)
        startActivity(intent)
        finish()
    }
}