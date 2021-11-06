package random.sfgreactivebrewery.services;

import org.springframework.data.domain.PageRequest;
import random.sfgreactivebrewery.web.model.BeerDto;
import random.sfgreactivebrewery.web.model.BeerPagedList;
import random.sfgreactivebrewery.web.model.BeerStyleEnum;

import java.util.UUID;

public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerDto getByUpc(String upc);

    void deleteBeerById(UUID beerId);
}
