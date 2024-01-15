package com.example.sensoresandroid
import android.Manifest
import android.app.Dialog
import android.app.KeyguardManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.hardware.fingerprint.FingerprintManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.security.keystore.KeyProperties
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import java.security.KeyStore
import javax.crypto.Cipher

class SensorHuella : AppCompatActivity() {
    private lateinit var btnAuteticacion:Button


    private var cancelationSignal:CancellationSignal?=null
    private val autenticacionCallBack:BiometricPrompt.AuthenticationCallback
    get()=
       @RequiresApi(Build.VERSION_CODES.P)
       object :BiometricPrompt.AuthenticationCallback(){
           override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
               super.onAuthenticationError(errorCode, errString)
               notificacionUser("Autetificacion eroor $errString")

           }

           override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
               super.onAuthenticationSucceeded(result)
               notificacionUser("Todo salio bien con la autenticacion")
               startActivity(Intent(this@SensorHuella, MainActivity::class.java))
           }
       }
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_huella)

        btnAuteticacion = findViewById(R.id.Autenticar)
        checkBiometricSupport()
        btnAuteticacion.setOnClickListener{
                val biometricPrompt = BiometricPrompt.Builder(this)
                    .setTitle("Title of prompt")
                    .setSubtitle("Autenticacion")
                    .setNegativeButton("Cancel", this.mainExecutor, DialogInterface.OnClickListener{
                        dialog, ehich ->
                        notificacionUser("Autentiocacion cancelada")
                    }).build()
            biometricPrompt.authenticate(getCacellationSignal(), mainExecutor, autenticacionCallBack)
        }

    }


    private fun checkBiometricSupport():Boolean {
        val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        if (!keyguardManager.isKeyguardSecure){
            notificacionUser("Algo salio mal")
            return false
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.USE_BIOMETRIC)!=PackageManager.PERMISSION_GRANTED){
            notificacionUser("No tienes los permisos")
            return false
        }
        return if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            true
        }else true
    }

    private fun notificacionUser(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun getCacellationSignal(): CancellationSignal{
        cancelationSignal = CancellationSignal()
        cancelationSignal?.setOnCancelListener {
            notificacionUser("Autenticacion cancelada")
        }
return cancelationSignal as CancellationSignal
    }
   }