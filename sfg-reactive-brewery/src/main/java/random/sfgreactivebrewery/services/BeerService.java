package random.sfgreactivebrewery.services;

import org.springframework.data.domain.PageRequest;
import random.sfgreactivebrewery.web.model.BeerDto;
import random.sfgreactivebrewery.web.model.BeerPagedList;
import random.sfgreactivebrewery.web.model.BeerStyleEnum;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    Mono<BeerDto> getById(Integer beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    Mono<BeerDto> getByUpc(String upc);

    void deleteBeerById(Integer beerId);
}
