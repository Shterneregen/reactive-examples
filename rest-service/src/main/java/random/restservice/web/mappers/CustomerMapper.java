package random.restservice.web.mappers;

import org.mapstruct.Mapper;
import random.restservice.domain.Customer;
import random.restservice.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto dto);

    CustomerDto customerToCustomerDto(Customer customer);
}
