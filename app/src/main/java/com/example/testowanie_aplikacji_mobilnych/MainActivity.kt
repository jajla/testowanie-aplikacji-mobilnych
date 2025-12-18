package com.example.testowanie_aplikacji_mobilnych

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            startActivity(Intent(this, AddPersonActivity::class.java))
        }

        findViewById<Button>(R.id.btnList).setOnClickListener {
            startActivity(Intent(this, PersonListActivity::class.java))
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            startActivity(Intent(this, DeletePersonActivity::class.java))
        }
    }
}
