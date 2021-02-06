package softuni.library.config;

import com.google.gson.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.library.util.ValidatorUtil;
import softuni.library.util.ValidatorUtilImpl;
import softuni.library.util.XmlParser;
import softuni.library.util.XmlParserImpl;

import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Configuration
public class ApplicationBeanConfiguration {
    private Gson gson;
    private ValidatorUtil validationUtil;
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
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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
    public ValidatorUtil validatorUtil() {
        if (this.validationUtil == null) {
            this.validationUtil = new ValidatorUtilImpl(this.validator());
        }

        return this.validationUtil;
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
    public ModelMapper modelMapper() {
        if (this.modelMapper == null) {
            this.modelMapper = new ModelMapper();
        }

        return this.modelMapper;
    }

    @Bean
    public XmlParser xmlParser() {
        if (this.xmlParser == null) {
            this.xmlParser = new XmlParserImpl();
        }

        return this.xmlParser;
    }

}
