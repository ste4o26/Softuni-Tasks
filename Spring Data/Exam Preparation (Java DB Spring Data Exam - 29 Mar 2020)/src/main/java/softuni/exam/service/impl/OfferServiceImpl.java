package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.OfferCreateDtoList;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Offer;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

@Service
public class OfferServiceImpl implements OfferService {
    private static final String OFFERS_XML_PATH = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final CarRepository carRepository;
    private final SellerRepository sellerRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, XmlParser xmlParser, CarRepository carRepository, SellerRepository sellerRepository, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.carRepository = carRepository;
        this.sellerRepository = sellerRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(OFFERS_XML_PATH)));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        this.xmlParser
                .fromXml(OFFERS_XML_PATH, OfferCreateDtoList.class)
                .getOffers()
                .forEach(offerDto -> {
                    if (!this.validationUtil.isValid(offerDto)) {
                        sb.append("Invalid offer")
                                .append(System.lineSeparator());
                        return;
                    }

                    Car car = this.carRepository.findById(offerDto.getCar().getId()).get();
                    Seller seller = this.sellerRepository.findById(offerDto.getSeller().getId()).get();

                    Offer offer = this.modelMapper.map(offerDto, Offer.class);
                    offer.setCar(car);
                    offer.setSeller(seller);
                    offer.setPictures(new HashSet<>(car.getPictures()));

                    sb.append(String
                            .format("Successfully import offer %s - %s",
                                    offer.getAddedOn().toString(),
                                    offer.isHasGoldStatus()))
                            .append(System.lineSeparator());

                    this.offerRepository.saveAndFlush(offer);
                });


        return sb.toString();
    }
}
