package car_dealer.services;

import car_dealer.domain.dtos.CustomerCreateDto;
import car_dealer.domain.dtos.CustomerTotalSalesViewDto;
import car_dealer.domain.dtos.CustomerViewDto;
import car_dealer.domain.entities.Customer;
import car_dealer.repositories.CustomerRepository;
import car_dealer.services.interfaces.CustomerService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, Gson gson) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void seedCustomers(List<CustomerCreateDto> customerCreateDtoList) {
        if (this.customerRepository.count() > 0) {
            return;
        }

        customerCreateDtoList
                .stream()
                .map(customerDto -> this.modelMapper.map(customerDto, Customer.class))
                .forEach(this.customerRepository::saveAndFlush);
    }

    @Override
    public List<CustomerViewDto> getCustomersOrderByBirthDateAndExperience() throws IllegalStateException {
        return this.customerRepository
                .findAllOrderByBirthDateAndYoungDriver()
                .orElseThrow(() -> new IllegalStateException("No Customers presents in database!"))
                .stream()
                .map(customer -> this.modelMapper.map(customer, CustomerViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerTotalSalesViewDto> totalSalesByCustomer() throws IllegalStateException {
        return this.customerRepository.findAllCustomersWithAtLeastOneSale()
                .orElseThrow(() -> new IllegalStateException("No customers with cars present in database!"))
                .stream()
                .map(customer ->  this.modelMapper.map(customer, CustomerTotalSalesViewDto.class))
                .collect(Collectors.toList());
    }
}
