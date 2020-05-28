package com.example.recyclappli.ui.company

import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.recyclappli.R
import android.view.LayoutInflater

class CompanyAdapter(private val inflater: LayoutInflater, private val listCompany: Array<Company>, private val list: List<String>)
    : ArrayAdapter<String>(inflater.context, R.layout.display_company, list) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {

        val rowView = inflater.inflate(R.layout.display_company, null, true)

        val siret = rowView.findViewById(R.id.siret) as TextView
        val raisonsociale = rowView.findViewById(R.id.raisonsociale) as TextView
        val norueentr = rowView.findViewById(R.id.norueentr) as TextView
        val rueentr = rowView.findViewById(R.id.rueentr) as TextView
        val cpostalentr = rowView.findViewById(R.id.cpostalentr) as TextView
        val villeentr = rowView.findViewById(R.id.villeentr) as TextView
        val notel = rowView.findViewById(R.id.notel) as TextView
        val contact = rowView.findViewById(R.id.contact) as TextView

        siret.text = listCompany[position].siret.toString()
        raisonsociale.text = listCompany[position].raisonsociale
        norueentr.text = listCompany[position].norueentr.toString()
        rueentr.text = listCompany[position].rueentr
        cpostalentr.text = listCompany[position].cpostalentr.toString()
        villeentr.text = listCompany[position].villeentr
        notel.text = listCompany[position].notel
        contact.text = listCompany[position].contact

        return rowView
    }
}