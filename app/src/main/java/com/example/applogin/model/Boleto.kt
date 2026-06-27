package com.example.applogin.model

data class Boleto(
    val id: Long,
    val descricao: String,
    val valor: Double,
    val vencimento: String
)
