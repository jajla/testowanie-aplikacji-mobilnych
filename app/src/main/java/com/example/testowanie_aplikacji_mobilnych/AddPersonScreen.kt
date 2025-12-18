package com.example.testowanie_aplikacji_mobilnych

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddPersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        val db = DatabaseHelper(this)

        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val person = Person(
                firstName = findViewById<EditText>(R.id.etFirstName).text.toString(),
                lastName = findViewById<EditText>(R.id.etLastName).text.toString(),
                birthDate = findViewById<EditText>(R.id.etBirthDate).text.toString(),
                phone = findViewById<EditText>(R.id.etPhone).text.toString(),
                email = findViewById<EditText>(R.id.etEmail).text.toString(),
                address = findViewById<EditText>(R.id.etAddress).text.toString()
            )

            db.insertPerson(person)
            finish() // powrót do MainActivity
        }
    }
}
