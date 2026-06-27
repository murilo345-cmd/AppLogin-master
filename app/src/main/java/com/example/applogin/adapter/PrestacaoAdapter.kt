package com.example.applogin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applogin.R
import com.example.applogin.model.Lancamento

class PrestacaoAdapter(private val lancamentos: List<Lancamento>) :
    RecyclerView.Adapter<PrestacaoAdapter.PrestacaoViewHolder>() {

    inner class PrestacaoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNome: TextView = itemView.findViewById(R.id.txtNomeLancamento)
        val txtData: TextView = itemView.findViewById(R.id.txtDataLancamento)
        val txtValor: TextView = itemView.findViewById(R.id.txtValorLancamento)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrestacaoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prestacao, parent, false)
        return PrestacaoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrestacaoViewHolder, position: Int) {
        val lancamento = lancamentos[position]
        holder.txtNome.text = lancamento.nome
        holder.txtData.text = lancamento.data
        holder.txtValor.text = "R$ %.0f".format(lancamento.valor)
    }

    override fun getItemCount(): Int = lancamentos.size
}