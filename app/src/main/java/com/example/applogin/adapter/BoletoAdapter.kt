package com.example.applogin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applogin.R
import com.example.applogin.model.Boleto

class BoletoAdapter (val boletos : List<Boleto>) : RecyclerView.Adapter<BoletoAdapter.BoletoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BoletoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_boleto, parent, false)
        return BoletoAdapter.BoletoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: BoletoViewHolder,
        position: Int
    ) {
        val boleto = boletos[position]
        holder.taxa.text = boleto.descricao
        holder.valor.text = boleto.valor.toString()
        holder.vencimento.text = boleto.vencimento
    }

    override fun getItemCount(): Int {
        return boletos.size
    }

    class  BoletoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val taxa : TextView = itemView.findViewById(R.id.txtTitulo)
        val valor : TextView = itemView.findViewById(R.id.txtValor)
        val vencimento : TextView = itemView.findViewById(R.id.txtVencimento)

    }
}