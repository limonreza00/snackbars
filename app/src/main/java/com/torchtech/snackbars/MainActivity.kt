package com.torchtech.snackbars

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val snackButton = findViewById<Button>(R.id.snackButton)
        snackButton.setOnClickListener {
            val snack = Snackbar.make(it,"This is Snack Bar",Snackbar.LENGTH_LONG).setAction("Okay") {
                 Toast.makeText(this,"Snack Action worked",Toast.LENGTH_SHORT).show()
            }
            snack.show()
        }
    }
}