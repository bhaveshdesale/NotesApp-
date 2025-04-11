package com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
//This interface defines how your app will interact with the database for the Note entity
// — like fetching, inserting, and deleting notes — using Room's annotations.

// interface is a collection of abstract methods and properties that define a common contract for classes that implement the interface
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNotes():Flow<List<Note>>

    @Query("SELECT * FROM note where id=:id")
    suspend fun getNoteById(id:Int):Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)
    //suspend keeps long operations off the main thread — no lag!

    @Delete
    suspend fun deleteNote(note:Note)
}