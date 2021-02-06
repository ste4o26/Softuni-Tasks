package car_dealer.services;

import car_dealer.domain.entities.Car;
import car_dealer.domain.entities.Customer;
import car_dealer.domain.entities.Sale;
import car_dealer.repositories.CarRepository;
import car_dealer.repositories.CustomerRepository;
import car_dealer.repositories.SaleRepository;
import car_dealer.services.interfaces.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private CarRepository carRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository, CustomerRepository customerRepository) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void seedSales() {
        if (this.saleRepository.count() > 0) {
            return;
        }

        for (int i = 0; i < 20; i++) {
            Car car = this.getRandomCar();
            Customer customer = this.getRandomCustomer();
            Integer discount = this.getRandomDiscount();
            Sale sale = new Sale(discount, car, customer);
            this.saleRepository.saveAndFlush(sale);
        }
    }

    private Integer getRandomDiscount() {
        List<Integer> discountPercentages = List.of(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50);
        long discountIndex = this.getRandomIndexInBounds(discountPercentages.size() - 1);
        return discountPercentages.get((int) discountIndex);

    }

    private Customer getRandomCustomer() {
        long customerId = this.getRandomIndexInBounds((int) this.customerRepository.count());
        return this.customerRepository
                .findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException(String
                        .format("Customer with id %d does not exists!", customerId)));
    }

    private Car getRandomCar() {
        long carId = this.getRandomIndexInBounds((int) this.carRepository.count());
        return this.carRepository
                .findById(carId)
                .orElseThrow(() -> new IllegalArgumentException(String
                        .format("Car with id %d does not exists!", carId)));
    }

    private long getRandomIndexInBounds(int bounds) {
        Random random = new Random();
        return (long) random.nextInt(bounds) + 1;
    }
}
