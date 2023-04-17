package com.example.androidpermission

import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.androidpermission.databinding.ActivityNormalPermissionBinding

class NormalPermission : AppCompatActivity() {

    lateinit var binding : ActivityNormalPermissionBinding
    lateinit var wifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNormalPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Latihan 1 : Show Image
        binding.btnShowImage.setOnClickListener {
            Glide.with(this)
                .load("https://i.ibb.co/zJHYGBP/binarlogo.jpg")
                .circleCrop()
                .into(binding.imgInternet)
        }

        //Latihan 2 : Permission WiFi
        binding.btnWifiOn.setOnClickListener {
            enableWifi(true)
        }

        binding.btnWifiOff.setOnClickListener {
            disableWifi(true)
        }

    }

    fun enableWifi(view: Boolean) {
        wifiManager.isWifiEnabled = true
        Toast.makeText(this, "Wifi enabled", Toast.LENGTH_SHORT).show()
    }
    fun disableWifi(view: Boolean) {
        wifiManager.isWifiEnabled = false
        Toast.makeText(this, "Wifi disabled", Toast.LENGTH_SHORT).show()
    }
}