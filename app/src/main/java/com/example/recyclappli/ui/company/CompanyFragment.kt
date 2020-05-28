package com.example.recyclappli.ui.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.recyclappli.R
import com.google.gson.Gson


class CompanyFragment : Fragment(), View.OnClickListener {

    private lateinit var listView: ListView
    private lateinit var root: View
    private lateinit var inflat: LayoutInflater

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflat = inflater
        root = inflater.inflate(R.layout.fragment_company, container, false)

        listView = root.findViewById(R.id.list_company)

        val upButton = root.findViewById(R.id.button) as Button
        upButton.setOnClickListener(this)

        request()

        return root
    }

    fun request(){
        var gson = Gson()
        val queue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(
            Request.Method.GET, "https://apex.oracle.com/pls/apex/recycl-mspr/hr/company",
            Response.Listener<String> { response ->
                println(response)
                var companyReceiver = gson?.fromJson(response, Receiver::class.java)
                val listCompany = companyReceiver.items
                val list = mutableListOf<String>()
                listCompany.forEach {
                    list.add(it.rueentr)
                }

                listView.adapter = CompanyAdapter(inflat, listCompany, list)
            },
            Response.ErrorListener { error -> println(error.toString()) })

        queue.add(stringRequest)
    }

    override fun onClick(v: View) {
        val edit = root.findViewById<EditText>(R.id.editText)
        Toast.makeText(context, "Entreprise avec plus de demandes que " + edit.text, Toast.LENGTH_LONG).show()
    }
}