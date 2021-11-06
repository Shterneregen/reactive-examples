package random.sfgreactivebrewery.web.mappers;

import org.mapstruct.Mapper;
import random.sfgreactivebrewery.domain.Beer;
import random.sfgreactivebrewery.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
