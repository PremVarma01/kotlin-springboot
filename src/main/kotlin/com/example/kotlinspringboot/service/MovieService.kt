package com.example.kotlinspringboot.service

import com.example.kotlinspringboot.dto.MovieDTO

interface MovieService {
    fun createMovie(movieDTO: MovieDTO): MovieDTO
    fun getMovies(): List<MovieDTO>
    fun getMovie(id: Int): MovieDTO
    fun updateMovie(movieDTO: MovieDTO): MovieDTO
    fun deleteMovie(id: Int)
}