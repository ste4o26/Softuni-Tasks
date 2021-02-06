package car_dealer.services;

import car_dealer.domain.dtos.SupplierCreateDto;
import car_dealer.domain.dtos.SupplierViewDto;
import car_dealer.domain.entities.Supplier;
import car_dealer.repositories.SupplierRepository;
import car_dealer.services.interfaces.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers(List<SupplierCreateDto> supplierCreateDtoList) throws IOException, URISyntaxException {
        //1 - READ JSON FILE
        //2 - PARSE JSON TO DTO
        //3 - PARSE DTO TO ENTITY
        //4 - SAVE ENTITY
        if (this.supplierRepository.count() > 0) {
            return;
        }

        supplierCreateDtoList
                .stream()
                .map(supplierCreateDto -> this.modelMapper.map(supplierCreateDto, Supplier.class))
                .forEach(this.supplierRepository::saveAndFlush);
    }

    @Override
    public List<SupplierViewDto> getAllLocalSuppliers() {
        return this.supplierRepository
                .findAllByImporterIsFalse()
                .orElseThrow(() -> new IllegalStateException("There are no local suppliers into the database!"))
                .stream()
                .map(supplier -> this.modelMapper.map(supplier, SupplierViewDto.class))
                .collect(Collectors.toList());
    }
}
