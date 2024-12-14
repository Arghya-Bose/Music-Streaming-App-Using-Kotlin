package com.example.mymusicapp.models

data class CategaryModel(
    val name : String,
    val coverUrl : String,
    var song : List<String>
){
    constructor():this("", "", listOf())
}
