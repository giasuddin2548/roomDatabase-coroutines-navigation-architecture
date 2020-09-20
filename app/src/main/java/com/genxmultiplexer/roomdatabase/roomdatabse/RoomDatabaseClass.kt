package com.genxmultiplexer.roomdatabase.roomdatabse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class RoomDatabaseClass : RoomDatabase() {



    abstract fun getNoteDao(): DoaInterface

    companion object {

        @Volatile
        private var instance: RoomDatabaseClass? = null
        private var Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }



        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RoomDatabaseClass::class.java,
            "MyNote.db"
        ).build()








        /*
        Room.databaseBuilder(
                     context.getApplicationContext(),
                     AppDatabase.class,
                     "database_name.db")
.openHelperFactory(new AssetSQLiteOpenHelperFactory())
.allowMainThreadQueries()
.build();

         */

    }


}