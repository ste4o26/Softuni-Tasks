package softuni_game_store.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni_game_store.utils.ValidatorUtil;
import softuni_game_store.utils.ValidatorUtilImpl;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidatorConfiguration {
    private Validator validator;
    private ValidatorUtil validatorUtil;

    public ValidatorConfiguration() {
    }

    @Bean
    public Validator validator() {
        if (this.validator == null){
            this.validator = Validation
                    .byDefaultProvider()
                    .configure()
                    .buildValidatorFactory()
                    .getValidator();
        }

        return this.validator;
    }

    @Bean
    public ValidatorUtil validatorUtil() {
        if (this.validatorUtil == null){
            this.validatorUtil = new ValidatorUtilImpl(this.validator());
        }

        return this.validatorUtil;
    }
}
