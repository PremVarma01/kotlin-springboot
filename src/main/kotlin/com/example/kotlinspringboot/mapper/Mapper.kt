package com.example.kotlinspringboot.mapper

// movieDTO => Movie
// movie => MovieDTO

interface Mapper<D, E> {
    fun toDto(entity: E): D
    fun toEntity(dto: D): E
}