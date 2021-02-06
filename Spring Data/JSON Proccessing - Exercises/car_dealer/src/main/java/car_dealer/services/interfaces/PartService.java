package car_dealer.services.interfaces;

import car_dealer.domain.dtos.PartCreateDto;

import java.util.List;

public interface PartService {
    void seedParts(List<PartCreateDto> partCreateDtoList);
}
