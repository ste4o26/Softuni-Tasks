package car_dealer.services.interfaces;

import car_dealer.domain.dtos.CarCreateDto;
import car_dealer.domain.dtos.CarPartViewDto;
import car_dealer.domain.dtos.CarViewDto;

import java.util.List;

public interface CarService {
    void seedCars(List<CarCreateDto> carCreateDtoList);

    List<CarViewDto> getAllCarsWithMakeToyota() throws IllegalStateException;

    List<CarPartViewDto> getAllCarsAndTheirParts() throws IllegalStateException;
}
