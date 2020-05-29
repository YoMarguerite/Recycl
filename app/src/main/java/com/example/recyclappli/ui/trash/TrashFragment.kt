package com.example.recyclappli.ui.trash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.recyclappli.R
import com.google.gson.Gson


class TrashFragment : Fragment(), View.OnClickListener {

    private lateinit var listView: ListView
    private lateinit var root: View
    private lateinit var inflat: LayoutInflater

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflat = inflater
        root = inflater.inflate(R.layout.fragment_trash, container, false)

        listView = root.findViewById(R.id.list_trash)

        val upButton = root.findViewById(R.id.button) as Button
        upButton.setOnClickListener(this)

        return root
    }

    fun request(date: String, date1: String){
        var gson = Gson()
        val queue = Volley.newRequestQueue(context)
        val url = "https://apex.oracle.com/pls/apex/recycl-mspr/hr/trash/" + date + "/" + date1

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                println(response)
                var trashReceiver = gson?.fromJson(response, Receiver::class.java)
                val listTrash = trashReceiver.items
                val list = mutableListOf<String>()
                listTrash.forEach {
                    list.add(it.type)
                }

                listView.adapter = TrashAdapter(inflat, listTrash, list)
            },
            Response.ErrorListener { error -> println(error.toString()) })

        queue.add(stringRequest)
    }

    override fun onClick(v: View) {
        val date = root.findViewById<EditText>(R.id.date)
        val date1 = root.findViewById<EditText>(R.id.date1)
        request(date.text.toString(), date1.text.toString())
    }
}