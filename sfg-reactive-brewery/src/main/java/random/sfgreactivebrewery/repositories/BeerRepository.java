package random.sfgreactivebrewery.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import random.sfgreactivebrewery.domain.Beer;

import java.util.UUID;

public interface BeerRepository extends ReactiveCrudRepository<Beer, UUID> {
//    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);
//
//    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);
//
//    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

    Beer findByUpc(String upc);
}
