package com.genxmultiplexer.roomdatabase.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.genxmultiplexer.roomdatabase.R
import com.genxmultiplexer.roomdatabase.roomdatabse.NoteEntity

class NoteAdapter(private val list: List<NoteEntity>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.simple_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val index = list[position]

        holder.textViewTitle.text = index.title
        holder.textViewBody.text = index.note




        holder.itemView.setOnClickListener {
            val action = FragmentHomeDirections.actionAddNoteId(NoteEntity(index.title, index.note))
            Navigation.findNavController(it).navigate(action)

        }


    }

    override fun getItemCount(): Int {

        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.tVNoteTitleId)
        val textViewBody: TextView = itemView.findViewById(R.id.tVNoteBodyId)
    }
}