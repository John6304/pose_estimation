package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.camera.core.CameraSelector
import androidx.camera.core.CameraSelector.LENS_FACING_BACK
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.lifecycle.LifecycleOwner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startCamera()
    }

    private fun startCamera(){
        val preview = Preview.Builder().build()
        val previewView:PreviewView = findViewById(R.id.cameraPreview)
        val cameraSelector = CameraSelector.Builder().requireLensFacing(LENS_FACING_BACK).build()
        val cameraProvider = ProcessCameraProvider.getInstance(this)
        val camera = cameraProvider.get()
        camera.bindToLifecycle(this as LifecycleOwner, cameraSelector, preview)
        preview.setSurfaceProvider(previewView.surfaceProvider)
    }
}