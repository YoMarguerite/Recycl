package com.example.recyclappli.ui.trash

import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.recyclappli.R
import android.view.LayoutInflater

class TrashAdapter(private val inflater: LayoutInflater, private val listTrash: Array<Trash>, private val list: List<String>)
    : ArrayAdapter<String>(inflater.context, R.layout.display_trash, list) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {

        val rowView = inflater.inflate(R.layout.display_trash, null, true)

        val type = rowView.findViewById(R.id.type) as TextView
        val qte = rowView.findViewById(R.id.qte) as TextView


        type.text = listTrash[position].type
        qte.text = listTrash[position].qte.toString()

        return rowView
    }
}