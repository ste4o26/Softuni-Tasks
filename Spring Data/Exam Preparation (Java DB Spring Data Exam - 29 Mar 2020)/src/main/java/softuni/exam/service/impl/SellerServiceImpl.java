package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.SellerCreateDtoList;
import softuni.exam.models.entities.Rating;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {
    private static final String SELLERS_XML_PATH = "src/main/resources/files/xml/sellers.xml";

    private final SellerRepository sellerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return String.join("", Files.readAllLines(Path.of(SELLERS_XML_PATH)));
    }

    @Override
    public String importSellers() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        this.xmlParser
                .fromXml(SELLERS_XML_PATH, SellerCreateDtoList.class)
                .getSellers()
                .forEach(sellerDto -> {
                    Rating rating = null;
                    try {
                        rating = Rating.valueOf(sellerDto.getRating());
                    } catch (IllegalArgumentException iae) {
                        sb.append("Invalid seller")
                                .append(System.lineSeparator());
                        return;
                    }

                    Optional<Seller> byEmail = this.sellerRepository.findByEmail(sellerDto.getEmail());
                    Seller seller = this.modelMapper.map(sellerDto, Seller.class);
                    if (!(byEmail.isEmpty() && this.validationUtil.isValid(seller))) {
                        sb.append("Invalid seller")
                                .append(System.lineSeparator());
                        return;
                    }

                    seller.setRating(rating);
                    sb.append(String.format("Successfully import seller %s - %s",
                            seller.getLastName(),
                            seller.getEmail()))
                            .append(System.lineSeparator());

                    this.sellerRepository.saveAndFlush(seller);
                });

        return sb.toString();
    }
}
