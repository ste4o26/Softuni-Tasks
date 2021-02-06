package softuni.exam.config;

import com.google.gson.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.models.dtos.CarCreateDto;
import softuni.exam.models.entities.Car;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParser;
import softuni.exam.util.XmlParserImpl;

import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class ApplicationBeanConfiguration {
    private Gson gson;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;
    private Validator validator;
    private XmlParser xmlParser;

    @Bean
    public Gson gson() {
        if (this.gson == null) {
            this.gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                        @Override
                        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            return LocalDate
                                    .parse(json.getAsString(), dateTimeFormatter);
                        }
                    })
                    .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                        @Override
                        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            return LocalDateTime
                                    .parse(json.getAsString(), dateTimeFormatter);
                        }
                    })
                    .create();
        }

        return this.gson;
    }

    @Bean
    public ValidationUtil validationUtil() {
        if (this.validationUtil == null) {
            this.validationUtil = new ValidationUtilImpl(this.validator());
        }

        return this.validationUtil;
    }

    @Bean
    public ModelMapper modelMapper() {
        if (this.modelMapper == null) {
            this.modelMapper = new ModelMapper();
        }

        return this.modelMapper;
    }

    @Bean
    public Validator validator() {
        if (this.validator == null) {
            this.validator = Validation
                    .buildDefaultValidatorFactory()
                    .getValidator();
        }

        return this.validator;
    }

    @Bean
    public XmlParser xmlParser() {
        if (this.xmlParser == null) {
            this.xmlParser = new XmlParserImpl();
        }

        return this.xmlParser;
    }
}
