package random.sfgreactivebrewery.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import random.sfgreactivebrewery.domain.Beer;
import random.sfgreactivebrewery.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    @Mapping(target = "quantityOnHand", ignore = true)
    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
