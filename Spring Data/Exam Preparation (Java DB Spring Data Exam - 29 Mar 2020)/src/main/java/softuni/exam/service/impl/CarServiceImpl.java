package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.CarCreateDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CarServiceImpl implements CarService {
    private final static String CARS_JSON_PATH = "src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(CARS_JSON_PATH)));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(this.gson
                .fromJson(this.readCarsFileContent(), CarCreateDto[].class))
                .map(carDto -> this.modelMapper.map(carDto, Car.class))
                .forEach(car -> {
                    if (!this.validationUtil.isValid(car)) {
                        sb.append("Invalid car")
                                .append(System.lineSeparator());
                        return;
                    }

                    sb.append(String
                            .format("Successfully imported - %s - %s",
                                    car.getMake(),
                                    car.getModel()))
                            .append(System.lineSeparator());

                    this.carRepository.saveAndFlush(car);
                });

        return sb.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();

        this.carRepository
                .exportCars()
                .orElseThrow(() -> new IllegalStateException("No cars present in database!"))
                .forEach(car -> {
                    String carFormattedData = String.format("Car make - %s, model - %s%n" +
                                    "Kilometers - %d%n" +
                                    "Registered on - %s%n" +
                                    "Number of pictures - %d%n",
                            car.getMake(),
                            car.getModel(),
                            car.getKilometers(),
                            car.getRegisteredOn().toString(),
                            car.getPictures().size());

                    sb.append(carFormattedData)
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
