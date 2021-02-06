package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PictureCreateDto;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@Service
public class PictureServiceImpl implements PictureService {
    private static final String PICTURES_JSON_PATH = "src/main/resources/files/json/pictures.json";
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final CarRepository carRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, CarRepository carRepository) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.carRepository = carRepository;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return String.join("", Files.readAllLines(Path.of(PICTURES_JSON_PATH)));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(this.gson
                .fromJson(this.readPicturesFromFile(), PictureCreateDto[].class))
                .map(this.mapDtoToEntity())
                .forEach(this.validateAndSave(sb));

        return sb.toString();
    }

    private Consumer<Picture> validateAndSave(StringBuilder sb) {
        return picture -> {
            Optional<Picture> byName = this.pictureRepository.findByName(picture.getName());
            if (!(byName.isEmpty() && this.validationUtil.isValid(picture))) {
                sb.append("Invalid picture")
                        .append(System.lineSeparator());
                return;
            }


            sb.append(String.format("Successfully import picture - %s",
                    picture.getName()))
                    .append(System.lineSeparator());

            this.pictureRepository.saveAndFlush(picture);
        };
    }

    private Function<PictureCreateDto, Picture> mapDtoToEntity() {
        return pictureDto -> {
            Car car = this.carRepository
                    .findById(pictureDto.getCar())
                    .orElseThrow(() -> new IllegalStateException(String
                            .format("No car with id: %d was found",
                                    pictureDto.getCar())));


            Picture picture = this.modelMapper.map(pictureDto, Picture.class);
            picture.setCar(car);
            return picture;
        };
    }
}