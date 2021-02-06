package car_dealer.services;

import car_dealer.domain.dtos.PartCreateDto;
import car_dealer.domain.entities.Part;
import car_dealer.domain.entities.Supplier;
import car_dealer.repositories.PartRepository;
import car_dealer.repositories.SupplierRepository;
import car_dealer.services.interfaces.PartService;
import car_dealer.utils.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {
    private final ModelMapper modelMapper;
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;

    public PartServiceImpl(ModelMapper modelMapper,
                           PartRepository partRepository,
                           SupplierRepository supplierRepository) {
        this.modelMapper = modelMapper;
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void seedParts(List<PartCreateDto> partCreateDtoList) throws IllegalArgumentException{
        if (this.partRepository.count() > 0) {
            return;
        }

        partCreateDtoList
                .stream()
                .map(partDto -> this.modelMapper.map(partDto, Part.class))
                .forEach(part -> {
                    Supplier supplier = this.getRandomSupplier();
                    part.setSupplier(supplier);
                    this.partRepository.saveAndFlush(part);
                });
    }

    private Supplier getRandomSupplier() throws IllegalArgumentException{
        Random random = new Random();
        long index = (long) random.nextInt((int) this.supplierRepository.count()) + 1;

        return this.supplierRepository.findById(index)
                .orElseThrow(() -> new IllegalArgumentException(String
                        .format("Supplier with index %d does not exists!", index)));
    }
}
