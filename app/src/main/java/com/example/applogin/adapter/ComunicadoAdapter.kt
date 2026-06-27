package com.example.applogin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applogin.R
import com.example.applogin.model.Comunicado

class ComunicadoAdapter(private val comunicados: List<Comunicado>) :
    RecyclerView.Adapter<ComunicadoAdapter.ComunicadoViewHolder>() {

    class ComunicadoViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        val titulo: android.widget.TextView = itemView.findViewById(R.id.txtTituloComunicado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComunicadoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comunicado, parent, false)
        return ComunicadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComunicadoViewHolder, position: Int) {
        holder.titulo.text = comunicados[position].titulo
    }

    override fun getItemCount(): Int = comunicados.size
}