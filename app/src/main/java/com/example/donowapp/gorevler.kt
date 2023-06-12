package com.example.donowapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.donowapp.databinding.ActivityMainBinding

class gorevler : AppCompatActivity() {
    private lateinit var checkbox1: CheckBox
    private lateinit var checkbox2: CheckBox
    private lateinit var checkbox3: CheckBox
    private lateinit var checkbox4: CheckBox
    private lateinit var checkbox5: CheckBox
    private lateinit var checkbox6: CheckBox

    private lateinit var hafta1: EditText
    private lateinit var hafta2: EditText
    private lateinit var hafta3: EditText

    private lateinit var ay1: EditText
    private lateinit var ay2: EditText
    private lateinit var ay3: EditText

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gorevler)

        //Butonları vs.. tanımlayalım

        checkbox1 = findViewById(R.id.checkBox1)
        checkbox2 = findViewById(R.id.checkBox2)
        checkbox3 = findViewById(R.id.checkBox3)
        checkbox4 = findViewById(R.id.checkBox4)
        checkbox5 = findViewById(R.id.checkBox5)
        checkbox6 = findViewById(R.id.checkBox6)

        hafta1 = findViewById(R.id.hafta1)
        hafta2 = findViewById(R.id.hafta2)
        hafta3 = findViewById(R.id.hafta3)

        ay1 = findViewById(R.id.ay1)
        ay2 = findViewById(R.id.ay2)
        ay3 = findViewById(R.id.ay3)

        //kaydedebilmek için sharedPrefences tanımlalyalım

        sharedPref = getSharedPreferences("gorevler", Context.MODE_PRIVATE)

        //Kaydet butonuna view görevi ver

        val kaydetButton: Button = findViewById(R.id.kaydetButton)
        kaydetButton.setOnClickListener {
            kaydet(it)
        }

        okunanVerileriGoster() // Verileri oku ve görüntüle
    }

    fun kaydet(view: View) {

        val editor: Editor = sharedPref.edit()

        editor.putBoolean("checkbox1", checkbox1.isChecked)
        editor.putBoolean("checkbox2", checkbox2.isChecked)
        editor.putBoolean("checkbox3", checkbox3.isChecked)
        editor.putBoolean("checkbox4", checkbox4.isChecked)
        editor.putBoolean("checkbox5", checkbox5.isChecked)
        editor.putBoolean("checkbox6", checkbox6.isChecked)

        editor.putString("hafta1", hafta1.text.toString())
        editor.putString("hafta2", hafta2.text.toString())
        editor.putString("hafta3", hafta3.text.toString())

        editor.putString("ay1", ay1.text.toString())
        editor.putString("ay2", ay2.text.toString())
        editor.putString("ay3", ay3.text.toString())

        editor.apply()

        Toast.makeText(this, "Adımlar kaydedildi.", Toast.LENGTH_SHORT).show()
    }

    //kaydettiğimiz verileri okuyabilecek fonksiyon
    fun okunanVerileriGoster() {
        val cb1 = sharedPref.getBoolean("checkbox1", false)
        val cb2 = sharedPref.getBoolean("checkbox2", false)
        val cb3 = sharedPref.getBoolean("checkbox3", false)
        val cb4 = sharedPref.getBoolean("checkbox4", false)
        val cb5 = sharedPref.getBoolean("checkbox5", false)
        val cb6 = sharedPref.getBoolean("checkbox6", false)

        //Checkbox durumunu güncelleyebilmek için
        checkbox1.isChecked = cb1
        checkbox2.isChecked = cb2
        checkbox3.isChecked = cb3
        checkbox4.isChecked = cb4
        checkbox5.isChecked = cb5
        checkbox6.isChecked = cb6

        val hafta1Value = sharedPref.getString("hafta1", "")
        val hafta2Value = sharedPref.getString("hafta2", "")
        val hafta3Value = sharedPref.getString("hafta3", "")

        // EditText'lerin değerlerini güncellemek için
        hafta1.setText(hafta1Value)
        hafta2.setText(hafta2Value)
        hafta3.setText(hafta3Value)

        val ay1Value = sharedPref.getString("ay1", "")
        val ay2Value = sharedPref.getString("ay2", "")
        val ay3Value = sharedPref.getString("ay3", "")

        // EditText'lerin değerlerini güncellemek için
        ay1.setText(ay1Value)
        ay2.setText(ay2Value)
        ay3.setText(ay3Value)
    }

    fun gunum(view: View) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun gorevler(view: View) {
        val intent = Intent(applicationContext, gorevler::class.java)
        startActivity(intent)
        finish()
    }

    fun takvim(view: View) {
        val intent = Intent(applicationContext, takvim::class.java)
        startActivity(intent)
        finish()
    }

    fun bilgiMesaji(view: View) {
        val uyariMesaji = AlertDialog.Builder(this)
        uyariMesaji.setTitle("Görevler sayfası ne işe yarar?")
        uyariMesaji.setMessage("Bir ayda 3 görev belirleyin ve bunu haftalık 3 alt başlığa ayırın. Ve günlük görevleriniz ile hayalinizdeki başarılara adım adım ilerleyin! ")
        uyariMesaji.setPositiveButton(
            "ANLADIM",
            DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Hadi başlayalım!", Toast.LENGTH_SHORT).show()
            })

        uyariMesaji.show()
    }
}

