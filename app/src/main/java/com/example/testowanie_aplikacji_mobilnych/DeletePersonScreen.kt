package com.example.testowanie_aplikacji_mobilnych

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class DeletePersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_person)

        val db = DatabaseHelper(this)
        val listView = findViewById<ListView>(R.id.listViewDelete)

        refreshList(db, listView)
    }

    private fun refreshList(db: DatabaseHelper, listView: ListView) {
        val persons = db.getAllPersons()

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            persons.map { "${it.firstName} ${it.lastName}" }
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            db.deletePerson(persons[position].id)
            refreshList(db, listView)
        }
    }
}
