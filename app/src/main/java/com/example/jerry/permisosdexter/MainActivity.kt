package com.example.jerry.permisosdexter

import android.Manifest
import android.app.Activity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.TextView
import com.example.jerry.permisosdexter.enums.PermissionStatusEnum
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest


class MainActivity : Activity() { //Es activity para que soporte ventanas antiguas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setButtonClicks()



    }

    private fun setButtonClicks() {

        botonCamera.setOnClickListener {checkPermisoCamara()}

        botonContacts.setOnClickListener {checkPermisoContactos()}

        botonAudio.setOnClickListener {checkPermisoAudio()}
    }

    private fun checkPermisoCamara() {
        val contexto = this
        Dexter.withActivity(contexto)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse) {
                        /* ... */
                        txtCamera.text=getString(R.string.permisos_estado_concedido)
                        txtCamera.setTextColor(ContextCompat.getColor(contexto,R.color.colorPermissionStatusGranted))
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse) {
                        /* ... */
                        if (response.isPermanentlyDenied) {
                            txtCamera.text = getString(R.string.permisos_estado_denegado_permanentemente)
                            txtCamera.setTextColor(ContextCompat.getColor(contexto, R.color.colorPermissionStatusPermanentlyDenied))
                        } else {
                            txtCamera.text = getString(R.string.permisos_estado_denegado)
                            txtCamera.setTextColor(ContextCompat.getColor(contexto, R.color.colorPermissionStatusDenied))
                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest, token: PermissionToken) {
                        /* ... */
                        token.continuePermissionRequest()
                    }

                }).check()

    }

    private fun checkPermisoContactos() {
        val contexto = this
        Dexter.withActivity(contexto)
                .withPermission(Manifest.permission.READ_CONTACTS)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse) {
                        /* ... */
                        txtContacts.text=getString(R.string.permisos_estado_concedido)
                        txtContacts.setTextColor(ContextCompat.getColor(contexto,R.color.colorPermissionStatusGranted))
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse) {
                        /* ... */
                        if (response.isPermanentlyDenied) {
                            txtContacts.text = getString(R.string.permisos_estado_denegado_permanentemente)
                            txtContacts.setTextColor(ContextCompat.getColor(contexto, R.color.colorPermissionStatusPermanentlyDenied))
                        } else {
                            txtContacts.text = getString(R.string.permisos_estado_denegado)
                            txtContacts.setTextColor(ContextCompat.getColor(contexto, R.color.colorPermissionStatusDenied))
                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest, token: PermissionToken) {
                        /* ... */
                        token.continuePermissionRequest()
                    }

                }).check()

    }

    private fun checkPermisoAudio() {
        val contexto = this
        Dexter.withActivity(contexto)
                .withPermission(Manifest.permission.RECORD_AUDIO)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse) {
                        /* ... */
                        txtAudio.text=getString(R.string.permisos_estado_concedido)
                        txtAudio.setTextColor(ContextCompat.getColor(contexto,R.color.colorPermissionStatusGranted))
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse) {
                        /* ... */
                        if (response.isPermanentlyDenied) {
                            txtAudio.text = getString(R.string.permisos_estado_denegado_permanentemente)
                            txtAudio.setTextColor(ContextCompat.getColor(contexto, R.color.colorPermissionStatusPermanentlyDenied))
                        } else {
                            txtAudio.text = getString(R.string.permisos_estado_denegado)
                            txtAudio.setTextColor(ContextCompat.getColor(contexto, R.color.colorPermissionStatusDenied))
                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest, token: PermissionToken) {
                        /* ... */
                        token.continuePermissionRequest()
                    }

                }).check()

    }

    private fun setPermissionHandler(permiso: String, txt: TextView) {
        val contexto = this
        Dexter.withActivity(contexto)
                .withPermission(permiso)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse) {
                        /* ... */
                        txt.text=getString(R.string.permisos_estado_concedido)
                        txt.setTextColor(ContextCompat.getColor(contexto,R.color.colorPermissionStatusGranted))
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse) {
                        /* ... */
                        if (response.isPermanentlyDenied) {
                            txt.text = getString(R.string.permisos_estado_denegado_permanentemente)
                            txt.setTextColor(ContextCompat.getColor(contexto, R.color.colorPermissionStatusPermanentlyDenied))
                        } else {
                            txt.text = getString(R.string.permisos_estado_denegado)
                            txt.setTextColor(ContextCompat.getColor(contexto, R.color.colorPermissionStatusDenied))
                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest, token: PermissionToken) {
                        /* ... */
                        token.continuePermissionRequest()
                    }

                }).check()

    }

    private fun setPermissionStatus(txt: TextView, status: PermissionStatusEnum) {
        when (status){
            PermissionStatusEnum.GRANTED
        }

    }

}
