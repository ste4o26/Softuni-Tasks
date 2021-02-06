package json_demo_lab.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json_demo_lab.domain.dtos.PostCreateDto;
import json_demo_lab.domain.dtos.PostViewDto;
import json_demo_lab.domain.entities.Post;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {
    private ModelMapper modelMapper;
    private Gson gson;

    public ApplicationBeanConfiguration() {
    }

    @Bean
    public Gson gson() {
        if (this.gson == null) {
            this.gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setPrettyPrinting()
                    .create();
        }

        return this.gson;
    }

    @Bean
    public ModelMapper modelMapper() {
        if (this.modelMapper == null) {
            this.modelMapper = new ModelMapper();
            this.modelMapper.validate();
        }

        return this.modelMapper;
    }
}
