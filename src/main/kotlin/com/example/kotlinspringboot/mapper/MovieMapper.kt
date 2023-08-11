package com.example.kotlinspringboot.mapper

import com.example.kotlinspringboot.dto.MovieDTO
import com.example.kotlinspringboot.entity.Movie
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class MovieMapper : Mapper<MovieDTO, Movie> {
    override fun toDto(entity: Movie): MovieDTO {
        return MovieDTO(
            entity.id,
            entity.name,
            entity.rating
        )
    }

    override fun toEntity(dto: MovieDTO): Movie {
        return Movie(
            dto.id,
            dto.name,
            dto.rating
        )
    }
}