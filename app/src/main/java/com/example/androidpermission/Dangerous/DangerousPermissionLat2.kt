package com.example.androidpermission.Dangerous

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.androidpermission.R
import com.example.androidpermission.databinding.ActivityDangerousPermissionLat2Binding

class DangerousPermissionLat2 : AppCompatActivity() {

    lateinit var binding: ActivityDangerousPermissionLat2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDangerousPermissionLat2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        checkCameraPermission()

        val myButton = findViewById<Button>(R.id.btnTakePhoto)
        myButton.setOnClickListener {
            // Aksi yang ingin dilakukan ketika tombol diklik
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }


    }

    private val REQUEST_CODE_CAMERA = 1



    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CODE_CAMERA
            )
        } else {
            // Permission already granted
            openCamera()
        }
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            val image = data?.extras?.get("data") as Bitmap
            // Do something with the image
        }
    }
}