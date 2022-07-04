package com.spsoftwares.notesapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(note: Note) // suspend is a co-routines of kotlin so the i/o functions can run easily in background.

    @Delete
     fun delete(note: Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}