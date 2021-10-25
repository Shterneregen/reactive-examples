package random.netflux.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import random.netflux.domain.Movie;
import random.netflux.repositories.MovieRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) {
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>", "The Fluxxinator",
                                        "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                                .map(Movie::new)
                                .flatMap(movieRepository::save)
                ).subscribe(null, null,
                        () -> movieRepository.findAll().subscribe(System.out::println));
    }
}
