package com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note


@Database(
    entities = [Note::class],
    version = 1,
    exportSchema=false
)
 abstract class NoteDatabase:RoomDatabase() {
     abstract val noteDao:NoteDao
     //now room will do rest of for us
     companion object {
         const val DATABASE_NAME = "notes_db"
     }
}