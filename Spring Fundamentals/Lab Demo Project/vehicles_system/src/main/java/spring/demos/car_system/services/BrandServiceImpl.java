package spring.demos.car_system.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.demos.car_system.domain.binding_models.BrandCreateDto;
import spring.demos.car_system.domain.entities.Brand;
import spring.demos.car_system.repositories.BrandRepository;
import spring.demos.car_system.services.interfaces.BrandService;
import spring.demos.car_system.init.ErrorMessage;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Brand> getAllBrands() {
        return this.brandRepository
                .findAll(Sort.by("name"));
    }

    @Override
    public Brand getBrandByName(String name) {
        return this.brandRepository
                .findByName(name)
                .orElseThrow(ErrorMessage
                        .entityNotFoundException(ErrorMessage.NOT_EXISTING_ENTITY_WITH_NAME,Brand.class.getSimpleName(), name));
    }

    @Override
    public Brand getBrandById(Long id) {
        return this.brandRepository
                .findById(id)
                .orElseThrow(ErrorMessage
                        .entityNotFoundException(ErrorMessage.NOT_EXISTING_ENTITY_WITH_ID, Brand.class.getSimpleName(), String.valueOf(id)));
    }

    @Override
    public Brand createBrand(@Valid BrandCreateDto brandCreateDto) {
        if (brandCreateDto.getName().trim().isEmpty()){
            throw new IllegalArgumentException("Brand name is required!");
        }

        try {
            this.getBrandByName(brandCreateDto.getName());
            throw new IllegalArgumentException(String
                    .format(ErrorMessage.ENTITY_WITH_NAME_ALREADY_EXISTS,
                            Brand.class.getSimpleName(),
                            brandCreateDto.getName()));

        } catch (EntityNotFoundException enfe) {
            if (brandCreateDto.getCreated() == null){
                brandCreateDto.setCreated(LocalDateTime.now());
            }

            brandCreateDto.setModified(brandCreateDto.getCreated());

            Brand brand = this.modelMapper.map(brandCreateDto, Brand.class);

            return this.brandRepository.saveAndFlush(brand);
        }
    }

    @Override
    public Brand updateBrand(@Valid Brand brand) {
        //Throws exception if entity does not exists(invalid)!
        Brand brandById = this.getBrandById(brand.getId());

        brand.setModified(LocalDateTime.now());

        return this.brandRepository.saveAndFlush(brand);
    }

    @Override
    public Brand deleteBrand(Long id) {
        //Throws exception if entity does not exists(invalid)!
        Brand brandById = this.getBrandById(id);

        this.brandRepository.deleteById(id);

        return brandById;
    }

    @Override
    public Long getBrandsCount() {
        return this.brandRepository.count();
    }
}
