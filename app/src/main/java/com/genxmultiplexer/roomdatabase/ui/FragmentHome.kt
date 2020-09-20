package com.genxmultiplexer.roomdatabase.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.genxmultiplexer.roomdatabase.R
import com.genxmultiplexer.roomdatabase.roomdatabse.NoteEntity
import com.genxmultiplexer.roomdatabase.roomdatabse.RoomDatabaseClass
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch


class FragmentHome : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        recyclerViewId.setHasFixedSize(true)
//        recyclerViewId.layoutManager=GridLayoutManager(context,2)
        recyclerViewId.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)




        launch {
            context?.let {
                val note = RoomDatabaseClass(it).getNoteDao().getNoteData()
                recyclerViewId.adapter = NoteAdapter(note)

            }
        }





        buttonAddId.setOnClickListener {
            val action = FragmentHomeDirections.actionAddNoteId()
            Navigation.findNavController(it).navigate(action)
        }


    }


}