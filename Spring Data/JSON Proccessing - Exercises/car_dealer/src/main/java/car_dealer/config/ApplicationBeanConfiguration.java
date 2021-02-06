package car_dealer.config;

import car_dealer.domain.dtos.CustomerTotalSalesViewDto;
import car_dealer.domain.dtos.SupplierViewDto;
import car_dealer.domain.entities.Customer;
import car_dealer.domain.entities.Part;
import car_dealer.domain.entities.Sale;
import car_dealer.domain.entities.Supplier;
import car_dealer.utils.FileUtil;
import car_dealer.utils.FileUtilImpl;
import com.google.gson.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class ApplicationBeanConfiguration {
    private ModelMapper modelMapper;
    private Gson gson;
    private FileUtil fileUtil;

    public ApplicationBeanConfiguration() {
    }

    @Bean
    public ModelMapper modelMapper() {
        if (this.modelMapper == null) {
            this.modelMapper = new ModelMapper();
        }

        this.modelMapper
                .createTypeMap(Supplier.class, SupplierViewDto.class)
                .addMapping(source -> source.getParts().size(), (destination, value) -> destination.setPartsCount((Integer) value));

        this.modelMapper
                .createTypeMap(Customer.class, CustomerTotalSalesViewDto.class)
                .addMapping(Customer::getName, CustomerTotalSalesViewDto::setFullName)
                .addMapping(source -> source.getSales().size(), CustomerTotalSalesViewDto::setBoughtCars);
//                .addMappings(new PropertyMap<Customer, CustomerTotalSalesViewDto>() {
//                    @Override
//                    protected void configure() {
//                        BigDecimal totalPrice = BigDecimal.ONE;
//
//                        Set<Sale> sales = source.getSales();
//                        for (Sale sale : sales) {
//                            Set<Part> parts = sale.getCar().getParts();
//                            for (Part part : parts) {
//                                BigDecimal price = part.getPrice();
//                                totalPrice.add(price);
//                            }
//                        }
//
//                        destination.setSpentMoney(totalPrice);
//                    }
//                });

        return this.modelMapper;
    }

    @Bean
    public Gson gson() {
        if (this.gson == null) {
            this.gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                        @Override
                        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                            return LocalDateTime
                                    .parse(json.getAsString(), dateTimeFormatter);
                        }
                    })
                    .registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

                        @Override
                        public JsonElement serialize(LocalDateTime dateTime, Type typeOfSrc, JsonSerializationContext context) {
                            return new JsonPrimitive(dateTimeFormatter.format(dateTime));
                        }
                    })
                    .create();
        }

        return this.gson;
    }

    @Bean
    public FileUtil fileUtil() {
        if (this.fileUtil == null) {
            this.fileUtil = new FileUtilImpl();
        }

        return fileUtil;
    }
}