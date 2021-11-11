package random.sfgreactivebrewery.services;

import org.springframework.data.domain.PageRequest;
import random.sfgreactivebrewery.web.model.BeerDto;
import random.sfgreactivebrewery.web.model.BeerPagedList;
import random.sfgreactivebrewery.web.model.BeerStyleEnum;
import reactor.core.publisher.Mono;

public interface BeerService {
    Mono<BeerPagedList> listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    Mono<BeerDto> getById(Integer beerId, Boolean showInventoryOnHand);

    Mono<BeerDto> saveNewBeerMono(Mono<BeerDto> beerDto);

    Mono<BeerDto> saveNewBeer(BeerDto beerDto);

    Mono<BeerDto> updateBeer(Integer beerId, BeerDto beerDto);

    Mono<BeerDto> getByUpc(String upc);

    void deleteBeerById(Integer beerId);

    Mono<Void> reactiveDeleteById(Integer beerId);
}
