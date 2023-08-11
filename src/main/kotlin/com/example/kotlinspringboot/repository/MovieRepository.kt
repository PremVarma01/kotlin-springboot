package com.example.kotlinspringboot.repository

import com.example.kotlinspringboot.entity.Movie
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CrudRepository<Movie, Int> {

    @Query("SELECT a from Movie as a")
    fun getAllMovies(): List<Movie>
}