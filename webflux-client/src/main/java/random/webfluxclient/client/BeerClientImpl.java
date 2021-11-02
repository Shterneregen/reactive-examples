package random.webfluxclient.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import random.webfluxclient.model.BeerDto;
import random.webfluxclient.model.BeerPagedList;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static java.util.Optional.ofNullable;
import static random.webfluxclient.config.WebClientProperties.BEER_V1_PATH;
import static random.webfluxclient.config.WebClientProperties.BEER_V1_UPC_PATH;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final WebClient webClient;

    @Override
    public Mono<BeerDto> getBeerById(UUID id, Boolean showInventoryOnHand) {
        return webClient.get().uri(uriBuilder -> uriBuilder.path(BEER_V1_PATH + "/" + id.toString())
                        .queryParamIfPresent("showInventoryOnHand", ofNullable(showInventoryOnHand))
                        .build()
                ).retrieve()
                .bodyToMono(BeerDto.class);
    }

    @Override
    public Mono<BeerPagedList> listBeers(Integer pageNumber, Integer pageSize, String beerName,
                                         String beerStyle, Boolean showInventoryOnhand) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(BEER_V1_PATH)
                        .queryParamIfPresent("pageNumber", ofNullable(pageNumber))
                        .queryParamIfPresent("pageSize", ofNullable(pageSize))
                        .queryParamIfPresent("beerName", ofNullable(beerName))
                        .queryParamIfPresent("beerStyle", ofNullable(beerStyle))
                        .queryParamIfPresent("showInventoryOnhand", ofNullable(showInventoryOnhand))
                        .build()
                )
                .retrieve()
                .bodyToMono(BeerPagedList.class);
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
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(BEER_V1_UPC_PATH + "/" + upc).build())
                .retrieve()
                .bodyToMono(BeerDto.class);
    }
}
