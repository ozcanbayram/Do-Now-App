package com.example.donowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class takvim : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_takvim)
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

    fun ocak(view: View){
        val intent = Intent(applicationContext,ocak::class.java)
        startActivity(intent)
        finish()
    }

    fun subat(view: View){
        val intent = Intent(applicationContext,subat::class.java)
        startActivity(intent)
        finish()
    }

    fun mart(view: View){
        val intent = Intent(applicationContext,mart::class.java)
        startActivity(intent)
        finish()
    }

    fun nisan(view: View){
        val intent = Intent(applicationContext,nisan::class.java)
        startActivity(intent)
        finish()
    }

    fun mayis(view: View){
        val intent = Intent(applicationContext,mayis::class.java)
        startActivity(intent)
        finish()
    }

    fun haziran(view: View){
        val intent = Intent(applicationContext,haziran::class.java)
        startActivity(intent)
        finish()
    }

    fun temmuz(view: View){
        val intent = Intent(applicationContext,temmuz::class.java)
        startActivity(intent)
        finish()
    }

    fun agustos(view: View){
        val intent = Intent(applicationContext,agustos::class.java)
        startActivity(intent)
        finish()
    }

    fun eylul(view: View){
        val intent = Intent(applicationContext,eylul::class.java)
        startActivity(intent)
        finish()
    }

    fun ekim(view: View){
        val intent = Intent(applicationContext,ekim::class.java)
        startActivity(intent)
        finish()
    }

    fun kasim(view: View){
        val intent = Intent(applicationContext,kasim::class.java)
        startActivity(intent)
        finish()
    }

    fun aralik(view: View){
        val intent = Intent(applicationContext,aralik::class.java)
        startActivity(intent)
        finish()
    }

}