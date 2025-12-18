package com.example.testowanie_aplikacji_mobilnych

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "persons.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE persons (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                firstName TEXT,
                lastName TEXT,
                birthDate TEXT,
                phone TEXT,
                email TEXT,
                address TEXT
            )
            """.trimIndent()
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS persons")
        onCreate(db)
    }

    fun insertPerson(person: Person) {
        val values = ContentValues().apply {
            put("firstName", person.firstName)
            put("lastName", person.lastName)
            put("birthDate", person.birthDate)
            put("phone", person.phone)
            put("email", person.email)
            put("address", person.address)
        }
        writableDatabase.insert("persons", null, values)
    }

    fun getAllPersons(): List<Person> {
        val list = mutableListOf<Person>()
        val cursor = readableDatabase.rawQuery("SELECT * FROM persons", null)

        while (cursor.moveToNext()) {
            list.add(
                Person(
                    id = cursor.getInt(0),
                    firstName = cursor.getString(1),
                    lastName = cursor.getString(2),
                    birthDate = cursor.getString(3),
                    phone = cursor.getString(4),
                    email = cursor.getString(5),
                    address = cursor.getString(6)
                )
            )
        }
        cursor.close()
        return list
    }

    fun deletePerson(id: Int) {
        writableDatabase.delete("persons", "id=?", arrayOf(id.toString()))
    }
}
