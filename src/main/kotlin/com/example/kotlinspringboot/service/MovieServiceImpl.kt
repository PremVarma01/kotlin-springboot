package com.example.kotlinspringboot.service

import com.example.kotlinspringboot.dto.MovieDTO
import com.example.kotlinspringboot.exception.MovieException
import com.example.kotlinspringboot.mapper.MovieMapper
import com.example.kotlinspringboot.repository.MovieRepository
import org.springframework.stereotype.Service


// Entity => id,name,password
// DTO => id, name

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieService {
    override fun createMovie(movieDTO: MovieDTO): MovieDTO {
        if (movieDTO.id != null) {
            throw MovieException("Id should be null")
        }
        val movie = movieMapper.toEntity(movieDTO)
        movieRepository.save(movie)
        return movieMapper.toDto(movie);
    }

    override fun getMovies(): List<MovieDTO> {
        var movies = movieRepository.getAllMovies()
        if (movies.isEmpty()) {
            throw MovieException("Movie list is empty")
        }
        return movies.map {
            movieMapper.toDto(it)
        }
    }

    override fun getMovie(id: Int): MovieDTO {
        var movie = movieRepository.findById(id).orElseThrow {
            MovieException("Movie with $id doesn't exist")
        }
        return movieMapper.toDto(movie)
    }

    override fun updateMovie(movieDTO: MovieDTO): MovieDTO {
        getMovie(movieDTO.id!!)
        movieRepository.save(movieMapper.toEntity(movieDTO))
        return movieDTO
    }

    override fun deleteMovie(id: Int) {
        val exists = movieRepository.existsById(id);
        if (!exists)
            throw MovieException("Movie with $id doesn't exist")
        movieRepository.deleteById(id)
    }
}