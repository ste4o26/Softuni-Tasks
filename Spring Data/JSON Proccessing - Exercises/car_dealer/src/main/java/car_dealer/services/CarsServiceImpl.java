package car_dealer.services;

import car_dealer.domain.dtos.CarCreateDto;
import car_dealer.domain.dtos.CarPartViewDto;
import car_dealer.domain.dtos.CarViewDto;
import car_dealer.domain.entities.Car;
import car_dealer.domain.entities.Part;
import car_dealer.repositories.CarRepository;
import car_dealer.repositories.PartRepository;
import car_dealer.services.interfaces.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarsServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private PartRepository partRepository;

    public CarsServiceImpl(CarRepository carRepository, ModelMapper modelMapper, PartRepository partRepository) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.partRepository = partRepository;
    }

    @Transactional
    @Override
    public void seedCars(List<CarCreateDto> carCreateDtoList) throws IllegalArgumentException {
        if (this.carRepository.count() > 0) {
            return;
        }

        carCreateDtoList
                .stream()
                .map(carDto -> this.modelMapper.map(carDto, Car.class))
                .forEach(car -> {
                    Set<Part> parts = this.getBetween10And20RandomParts();
                    car.setParts(parts);
                    this.carRepository.saveAndFlush(car);
                });
    }

    @Override
    public List<CarViewDto> getAllCarsWithMakeToyota() throws IllegalStateException {
        String make = "Toyota";
        return this.carRepository
                .findAllByMakeOrderByModelAscTravelledDistanceDesc(make)
                .orElseThrow(() -> new IllegalStateException(String
                        .format("No cars with make %s have been found!", make)))
                .stream()
                .map(car -> this.modelMapper.map(car, CarViewDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarPartViewDto> getAllCarsAndTheirParts() throws IllegalStateException {
        return this.carRepository
                .findAllCarsWithTheirParts()
                .orElseThrow(() -> new IllegalStateException("There are no parts in database at all!"))
                .stream()
                .map(car -> this.modelMapper.map(car, CarPartViewDto.class))
                .collect(Collectors.toList());
    }

    //TODO pet sa ne sa mejdu 10 i 20
    private Set<Part> getBetween10And20RandomParts() throws IllegalArgumentException {
        Random random = new Random();
        HashSet<Part> parts = new HashSet<>();

        int partsCount = random.nextInt(5) + 1;
        for (int i = 0; i < partsCount; i++) {
            Part part = this.getRandomPart();
            parts.add(part);
        }

        return parts;
    }

    private Part getRandomPart() {
        Random random = new Random();
        long partId = (long) random.nextInt((int) this.partRepository.count()) + 1;

        return this.partRepository.findById(partId)
                .orElseThrow(() -> new IllegalArgumentException(String
                        .format("Part with id %d does not exists!", partId)));
    }
}
