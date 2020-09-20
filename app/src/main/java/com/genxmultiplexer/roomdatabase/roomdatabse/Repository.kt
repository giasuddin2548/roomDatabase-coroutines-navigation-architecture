package com.genxmultiplexer.roomdatabase.roomdatabse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Repository {
    fun getAllData():LiveData<NoteEntity>{
        val mutable=MutableLiveData<NoteEntity>()


        return mutable
    }
}