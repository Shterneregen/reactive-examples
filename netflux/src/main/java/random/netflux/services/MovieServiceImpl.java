package random.netflux.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import random.netflux.domain.Movie;
import random.netflux.domain.MovieEvent;
import random.netflux.repositories.MovieRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Date;

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

    /**
     * This is going to emit a new movie event every second.
     * We are using the SynchronousSink to create a continuous stream of movie events.
     */
    @Override
    public Flux<MovieEvent> streamMovieEvents(String id) {
        return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
            movieEventSynchronousSink.next(new MovieEvent(id, new Date()));
        }).delayElements(Duration.ofSeconds(1));
    }
}
