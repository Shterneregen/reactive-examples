package random.sfgreactivebrewery.web.mappers;

import org.mapstruct.Mapper;
import random.sfgreactivebrewery.domain.Customer;
import random.sfgreactivebrewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto dto);

    CustomerDto customerToCustomerDto(Customer customer);
}
