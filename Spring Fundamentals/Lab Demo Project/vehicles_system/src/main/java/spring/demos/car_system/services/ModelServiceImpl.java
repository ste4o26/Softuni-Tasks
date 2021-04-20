package spring.demos.car_system.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.demos.car_system.domain.binding_models.ModelCreateDto;
import spring.demos.car_system.domain.entities.Brand;
import spring.demos.car_system.domain.entities.Model;
import spring.demos.car_system.domain.enums.Category;
import spring.demos.car_system.repositories.BrandRepository;
import spring.demos.car_system.repositories.ModelRepository;
import spring.demos.car_system.services.interfaces.ModelService;
import spring.demos.car_system.init.ErrorMessage;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Model> getAllModels() {
        return this.modelRepository.findAll(Sort.by("name"));
    }

    @Override
    public Model getModelByName(String name) {
        return this.modelRepository
                .findByName(name)
                .orElseThrow(ErrorMessage
                        .entityNotFoundException(ErrorMessage.NOT_EXISTING_ENTITY_WITH_NAME, Model.class.getSimpleName(), name));
    }

    @Override
    public Model getModelById(Long id) {
        return this.modelRepository
                .findById(id)
                .orElseThrow(ErrorMessage
                        .entityNotFoundException(ErrorMessage.NOT_EXISTING_ENTITY_WITH_ID, Model.class.getSimpleName(), String.valueOf(id)));
    }

    @Override
    public Model createModel(@Valid ModelCreateDto modelCreateDto) {
        try {
            this.getModelByName(modelCreateDto.getName());
            throw new IllegalArgumentException(String
                    .format(ErrorMessage.ENTITY_WITH_NAME_ALREADY_EXISTS,
                            Model.class.getSimpleName(),
                            modelCreateDto.getName()));

        } catch (EntityNotFoundException enfe) {
            if (modelCreateDto.getCreated() == null) {
                modelCreateDto.setCreated(LocalDateTime.now());
            }

            modelCreateDto.setModified(LocalDateTime.now());

            Brand brand = this.brandRepository
                    .findByName(modelCreateDto.getBrandName())
                    .orElseThrow(ErrorMessage.entityNotFoundException(ErrorMessage.NOT_EXISTING_ENTITY_WITH_NAME,
                            Brand.class.getSimpleName(),
                            modelCreateDto.getBrandName()));

            Model model = this.modelMapper.map(modelCreateDto, Model.class);
            model.setBrand(brand);
            model.setCategory(Category.CAR);

            return this.modelRepository.saveAndFlush(model);
        }
    }

    @Override
    public Model updateModel(@Valid Model model) {
        //Throws exception if model with that id doesnt exists!
        Model modelById = this.getModelById(model.getId());

        model.setModified(LocalDateTime.now());
        model.setBrand(modelById.getBrand());
        model.setCreated(modelById.getCreated());
        model.setCategory(Category.MOTORCYCLE);

        return this.modelRepository.saveAndFlush(model);
    }

    @Override
    public Model deleteModel(Long id) {
        //Throws exception if model with that id doesnt exists!
        Model modelById = this.getModelById(id);

        this.modelRepository.deleteById(id);

        return modelById;
    }

    private Brand getRandomBrand() {
        Random random = new Random();
        long index = random.nextInt((int) this.brandRepository.count()) + 1;
        return this.brandRepository
                .findById(index)
                .orElseThrow(ErrorMessage
                        .entityNotFoundException(ErrorMessage.NOT_EXISTING_ENTITY_WITH_ID,
                                Brand.class.getSimpleName(),
                                String.valueOf(index)));
    }
}
