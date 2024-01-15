package com.example.camara

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.io.OutputStream

class MainActivity : AppCompatActivity() {
    private lateinit var capturedImageUri: Uri
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            val intent = result.data
            val imageBitmap = intent?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.imageViewCamara)
            imageView.setImageBitmap(imageBitmap)
            if (imageBitmap != null) {
                // Guarda la imagen en la galería
                guardarImagenEnGaleria(imageBitmap)
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCamara = findViewById<ImageButton>(R.id.ImgBtnCama)
        btnCamara.setOnClickListener {
            // Verificar si el permiso de la cámara está concedido
    abrirCamara()
        }
    }
    private fun abrirCamara() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "Nueva Imagen")
        values.put(MediaStore.Images.Media.DESCRIPTION, "Imagen desde la cámara")
        capturedImageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)!!

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startForResult.launch(intent)
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_CAMERA_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // El usuario concedió el permiso de la cámara, abrir la cámara
                abrirCamara()
            } else {
                // El usuario denegó el permiso de la cámara, puedes mostrar un mensaje de error o realizar alguna otra acción.
            }
        }
    }
    companion object {
        private const val REQUEST_CODE_CAMERA_PERMISSION = 101
    }

    private fun guardarImagenEnGaleria(bitmap: Bitmap) {
        val imageOutStream: OutputStream?
        try {
            imageOutStream = contentResolver.openOutputStream(capturedImageUri)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, imageOutStream)
            //bitmap.compress(Bitmap.CompressFormat.JPEG, 100, imageOutStream)
            imageOutStream?.close()
            // Indica a la galería que escanee la imagen para que aparezca en la galería
            sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, capturedImageUri))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}