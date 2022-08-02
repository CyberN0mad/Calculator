package com.hfad.attractorassignment.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var name: String,
    var secondName: String,
    var photo: Int,
    var education: Int,
    var company: List<Company> = listOf()
)

@Serializable
data class Company(
    val name: String,
    val position: String
)