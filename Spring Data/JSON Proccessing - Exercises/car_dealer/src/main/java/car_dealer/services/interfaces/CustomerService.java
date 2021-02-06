package car_dealer.services.interfaces;

import car_dealer.domain.dtos.CustomerCreateDto;
import car_dealer.domain.dtos.CustomerTotalSalesViewDto;
import car_dealer.domain.dtos.CustomerViewDto;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerCreateDto> customerCreateDtoList);

    List<CustomerViewDto> getCustomersOrderByBirthDateAndExperience() throws IllegalStateException;

    List<CustomerTotalSalesViewDto> totalSalesByCustomer() throws IllegalStateException;
}
