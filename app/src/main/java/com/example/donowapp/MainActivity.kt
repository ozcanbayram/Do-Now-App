package com.example.donowapp

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
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

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences: SharedPreferences
    var adim1: String? = null
    var adim2: String? = null
    var adim3: String? = null
    var adim4: String? = null
    var adim5: String? = null

    var baslikal: String? = null
    var checkBox1Checked: Boolean = false
    var checkBox2Checked: Boolean = false
    var checkBox3Checked: Boolean = false
    var checkBox4Checked: Boolean = false
    var checkBox5Checked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // Kaydedilen değerleri al
        adim1 = sharedPreferences.getString("adim1", null)
        adim2 = sharedPreferences.getString("adim2", null)
        adim3 = sharedPreferences.getString("adim3", null)
        adim4 = sharedPreferences.getString("adim4", null)
        adim5 = sharedPreferences.getString("adim5", null)

        baslikal = sharedPreferences.getString("baslikal", null)
        checkBox1Checked = sharedPreferences.getBoolean("checkBox1Checked", false)
        checkBox2Checked = sharedPreferences.getBoolean("checkBox2Checked", false)
        checkBox3Checked = sharedPreferences.getBoolean("checkBox3Checked", false)
        checkBox4Checked = sharedPreferences.getBoolean("checkBox4Checked", false)
        checkBox5Checked = sharedPreferences.getBoolean("checkBox5Checked", false)

        // Kaydedilen değerleri göster
        binding.adim1.setText(adim1)
        binding.adim2.setText(adim2)
        binding.adim3.setText(adim3)
        binding.adim4.setText(adim4)
        binding.adim5.setText(adim5)

        binding.baslik.setText((baslikal))
        binding.checkBox1.isChecked = checkBox1Checked
        binding.checkBox2.isChecked = checkBox2Checked
        binding.checkBox3.isChecked = checkBox3Checked
        binding.checkBox4.isChecked = checkBox4Checked
        binding.checkBox5.isChecked = checkBox5Checked

        Toast.makeText(this, "Hoşgeldiniz!", Toast.LENGTH_SHORT).show()

        binding.kaydetButton.setOnClickListener {
            kaydet()
        }

    }

    fun baslikEklemeButonu(view: View) {
        binding.baslik.text = binding.baslikEkle.text.toString()
        binding.baslikEkle.text.clear()
    }

    private fun kaydet() {
        adim1 = binding.adim1.text.toString()
        adim2 = binding.adim2.text.toString()
        adim3 = binding.adim3.text.toString()
        adim4 = binding.adim4.text.toString()
        adim5 = binding.adim5.text.toString()

        baslikal = binding.baslik.text.toString()

        checkBox1Checked = binding.checkBox1.isChecked
        checkBox2Checked = binding.checkBox2.isChecked
        checkBox3Checked = binding.checkBox3.isChecked
        checkBox4Checked = binding.checkBox4.isChecked
        checkBox5Checked = binding.checkBox5.isChecked

        // Değerleri kaydet
        val editor = sharedPreferences.edit()
        editor.putString("adim1", adim1)
        editor.putString("adim2", adim2)
        editor.putString("adim3", adim3)
        editor.putString("adim4", adim4)
        editor.putString("adim5", adim5)

        editor.putString("baslikal", baslikal)
        editor.putBoolean("checkBox1Checked", checkBox1Checked)
        editor.putBoolean("checkBox2Checked", checkBox2Checked)
        editor.putBoolean("checkBox3Checked", checkBox3Checked)
        editor.putBoolean("checkBox4Checked", checkBox4Checked)
        editor.putBoolean("checkBox5Checked", checkBox5Checked)

        editor.apply()

        Toast.makeText(this, "Adımlar kaydedildi.", Toast.LENGTH_SHORT).show()
    }


    fun bilgiMesaji(view: View) {
        val uyariMesaji = AlertDialog.Builder(this@MainActivity)
        uyariMesaji.setTitle("Uygulamannın amacı:")
        uyariMesaji.setMessage("Her gün yeni hedefler belirleyin ve 5 adımda hedefinize ulaşın!")
        uyariMesaji.setPositiveButton(
            "ANLADIM",
            DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "Hadi başlayalım!", Toast.LENGTH_SHORT).show()
            })

        uyariMesaji.show()
    }


    fun sil1(view: View) {
        binding.adim1.text.clear()
    }

    fun sil2(view: View) {
        binding.adim2.text.clear()
    }

    fun sil3(view: View) {
        binding.adim3.text.clear()
    }

    fun sil4(view: View) {
        binding.adim4.text.clear()
    }

    fun sil5(view: View) {
        binding.adim5.text.clear()
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
