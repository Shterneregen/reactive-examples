package random.sfgreactivebrewery.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import random.sfgreactivebrewery.domain.Beer;
import random.sfgreactivebrewery.repositories.BeerRepository;
import random.sfgreactivebrewery.web.mappers.BeerMapper;
import random.sfgreactivebrewery.web.model.BeerDto;
import random.sfgreactivebrewery.web.model.BeerPagedList;
import random.sfgreactivebrewery.web.model.BeerStyleEnum;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Cacheable(cacheNames = "beerListCache", condition = "#showInventoryOnHand == false ")
    @Override
    public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {

        BeerPagedList beerPagedList = null;
        Page<Beer> beerPage;

//        if (!StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
//            //search both
//            beerPage = beerRepository.findAllByBeerNameAndBeerStyle(beerName, beerStyle, pageRequest);
//        } else if (!StringUtils.isEmpty(beerName) && StringUtils.isEmpty(beerStyle)) {
//            //search beer_service name
//            beerPage = beerRepository.findAllByBeerName(beerName, pageRequest);
//        } else if (StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)) {
//            //search beer_service style
//            beerPage = beerRepository.findAllByBeerStyle(beerStyle, pageRequest);
//        } else {
//            beerPage = beerRepository.findAll(pageRequest);
//        }
//
//        if (showInventoryOnHand) {
//            beerPagedList = new BeerPagedList(beerPage
//                    .getContent()
//                    .stream()
//                    .map(beerMapper::beerToBeerDtoWithInventory)
//                    .collect(Collectors.toList()),
//                    PageRequest
//                            .of(beerPage.getPageable().getPageNumber(),
//                                    beerPage.getPageable().getPageSize()),
//                    beerPage.getTotalElements());
//        } else {
//            beerPagedList = new BeerPagedList(beerPage
//                    .getContent()
//                    .stream()
//                    .map(beerMapper::beerToBeerDto)
//                    .collect(Collectors.toList()),
//                    PageRequest
//                            .of(beerPage.getPageable().getPageNumber(),
//                                    beerPage.getPageable().getPageSize()),
//                    beerPage.getTotalElements());
//        }

        return beerPagedList;
    }

    @Cacheable(cacheNames = "beerCache", key = "#beerId", condition = "#showInventoryOnHand == false ")
    @Override
    public Mono<BeerDto> getById(Integer beerId, Boolean showInventoryOnHand) {
        if (showInventoryOnHand) {
            return beerRepository.findById(beerId).map(beerMapper::beerToBeerDtoWithInventory);
        } else {
            return beerRepository.findById(beerId).map(beerMapper::beerToBeerDto);
        }
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
//        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
        return null;
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
//        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
//
//        beer.setBeerName(beerDto.getBeerName());
//        beer.setBeerStyle(BeerStyleEnum.PILSNER.valueOf(beerDto.getBeerStyle()));
//        beer.setPrice(beerDto.getPrice());
//        beer.setUpc(beerDto.getUpc());
//
//        return beerMapper.beerToBeerDto(beerRepository.save(beer));
        return null;
    }

    @Cacheable(cacheNames = "beerUpcCache")
    @Override
    public Mono<BeerDto> getByUpc(String upc) {
        return beerRepository.findByUpc(upc).map(beerMapper::beerToBeerDto);
    }

    @Override
    public void deleteBeerById(Integer beerId) {
        beerRepository.deleteById(beerId);
    }
}
