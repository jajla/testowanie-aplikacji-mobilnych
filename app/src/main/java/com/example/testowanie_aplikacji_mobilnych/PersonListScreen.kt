package com.example.testowanie_aplikacji_mobilnych

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class PersonListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        val db = DatabaseHelper(this)
        val persons = db.getAllPersons()

        val listView = findViewById<ListView>(R.id.listViewPersons)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            persons.map { "${it.firstName} ${it.lastName} - ${it.phone}" }
        )

        listView.adapter = adapter
    }
}
