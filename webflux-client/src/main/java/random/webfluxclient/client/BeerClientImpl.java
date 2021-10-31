package random.webfluxclient.client;

import org.springframework.http.ResponseEntity;
import random.webfluxclient.model.BeerDto;
import random.webfluxclient.model.BeerPagedList;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class BeerClientImpl implements BeerClient {

    @Override
    public Mono<BeerDto> getBeerById(UUID id, Boolean showInventoryOnHand) {
        return null;
    }

    @Override
    public Mono<BeerPagedList> listBeers(
            Integer pageNumber, Integer pageSize, String beerName, String beerStyle, Boolean showInventoryOnhand) {
        return null;
    }

    @Override
    public Mono<ResponseEntity> createBeer(BeerDto beerDto) {
        return null;
    }

    @Override
    public Mono<ResponseEntity> updateBeer(BeerDto beerDto) {
        return null;
    }

    @Override
    public Mono<ResponseEntity> deleteBeerById(UUID id) {
        return null;
    }

    @Override
    public Mono<BeerDto> getBeerByUPC(String upc) {
        return null;
    }
}
