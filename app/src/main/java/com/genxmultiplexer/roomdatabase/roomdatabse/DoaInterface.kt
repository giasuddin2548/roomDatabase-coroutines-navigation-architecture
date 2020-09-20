package com.genxmultiplexer.roomdatabase.roomdatabse

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DoaInterface {
    @Insert
    suspend fun noteInsert(note: NoteEntity): Long

    @Update
    suspend fun noteUpdate(note: NoteEntity)


    @Delete
    suspend fun noteDelete(note: NoteEntity)

    @Query("SELECT  * FROM NoteEntity ORDER BY id")
    suspend fun getNoteData(): List<NoteEntity>


    @Query("DELETE FROM NoteEntity")
    suspend fun deleteNoteData()


}