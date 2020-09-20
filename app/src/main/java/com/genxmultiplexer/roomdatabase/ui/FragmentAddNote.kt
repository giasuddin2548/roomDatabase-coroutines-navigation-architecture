package com.genxmultiplexer.roomdatabase.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.Navigation
import com.genxmultiplexer.roomdatabase.R

import com.genxmultiplexer.roomdatabase.roomdatabse.NoteEntity
import com.genxmultiplexer.roomdatabase.roomdatabse.RoomDatabaseClass
import com.genxmultiplexer.roomdatabase.utils.toast
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch


class FragmentAddNote : BaseFragment() {

    var receivedNote:NoteEntity?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_add_note,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments.let {
            receivedNote= it?.let { it1 -> FragmentAddNoteArgs.fromBundle(it1).argName }
            eTNoteTitleId.setText(receivedNote?.title)
            eTNoteBodyId.setText(receivedNote?.note)
        }



        buttonSaveId.setOnClickListener{view ->

            val noteTitle=eTNoteTitleId.text.toString().trim()
            val noteBody=eTNoteBodyId.text.toString().trim()

            if (noteTitle.isEmpty()){
                eTNoteTitleId.error="Title required"
                eTNoteTitleId.requestFocus()
                return@setOnClickListener
            }

            if (noteBody.isEmpty()){
                eTNoteTitleId.error="Title required"
                eTNoteTitleId.requestFocus()
                return@setOnClickListener
            }

            launch {

                context?.let {
                    val note=NoteEntity(noteTitle,noteBody)

                    if (receivedNote==null){

                        RoomDatabaseClass(it).getNoteDao().noteInsert(note)
                        it.toast("Data Inserted Successfully")

                    }else {

                        note.id= receivedNote!!.id
                        RoomDatabaseClass(it).getNoteDao().noteUpdate(note)
                        it.toast("Data Updated Successfully")

                    }




                    val action=FragmentAddNoteDirections.actionSaveNoteId()
                    Navigation.findNavController(view).navigate(action)
                }

            }






        }
    }


}