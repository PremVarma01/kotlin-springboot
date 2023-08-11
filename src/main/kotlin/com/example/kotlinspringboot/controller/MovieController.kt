package com.example.kotlinspringboot.controller

import com.example.kotlinspringboot.dto.MovieDTO
import com.example.kotlinspringboot.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieController(
    private val movieService: MovieService
) {

    @GetMapping
    fun getMovies(): ResponseEntity<List<MovieDTO>> {
        return ResponseEntity(movieService.getMovies(), HttpStatus.OK) //200.
    }

    //localhost:8080/1
    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: Int): ResponseEntity<MovieDTO> {
        return ResponseEntity.ok(movieService.getMovie(id))
    }

    @PostMapping
    fun createMovie(@RequestBody movieDTO: MovieDTO): ResponseEntity<MovieDTO>? {
        return ResponseEntity(movieService.createMovie(movieDTO), HttpStatus.CREATED); //201
    }

    @PutMapping
    fun updateMovie(@RequestBody movieDTO: MovieDTO): ResponseEntity<MovieDTO> {
        return ResponseEntity(movieService.updateMovie(movieDTO), HttpStatus.OK); //200
    }

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id: Int): ResponseEntity<Unit> =
        ResponseEntity(movieService.deleteMovie(id), HttpStatus.NO_CONTENT)  // 204
}