package random.netflux.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import random.netflux.domain.Movie;
import random.netflux.repositories.MovieRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Mono<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
