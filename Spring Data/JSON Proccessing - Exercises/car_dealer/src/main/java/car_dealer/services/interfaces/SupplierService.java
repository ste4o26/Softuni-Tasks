package car_dealer.services.interfaces;

import car_dealer.domain.dtos.SupplierCreateDto;
import car_dealer.domain.dtos.SupplierViewDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface SupplierService {
    void seedSuppliers(List<SupplierCreateDto> supplierCreateDtoList) throws IOException, URISyntaxException;

    List<SupplierViewDto>  getAllLocalSuppliers();
}
