package softuni.spring_fund_exam.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {
    private ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        if (this.modelMapper == null){
            this.modelMapper = new ModelMapper();
        }

        return this.modelMapper;
    }
}
