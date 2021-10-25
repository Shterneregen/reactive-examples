package random.netflux.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import random.netflux.domain.Movie;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
