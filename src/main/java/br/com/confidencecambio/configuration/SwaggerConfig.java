package br.com.confidencecambio.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket api() {
		return new Docket( DocumentationType.SWAGGER_2 )
				.apiInfo( apiInfo() )
                .select()
				.apis( apis() )
				.paths( PathSelectors.any() )
                .build();
    }

	private Predicate<RequestHandler> apis() {
		return RequestHandlerSelectors.basePackage( "br.com.confidencecambio.controller" );
	}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
				.title( "SPRING REST API CLIENT" )
				.description( "Documentação da API REST" )
				.build();
    }

	@Override
	protected void addResourceHandlers( ResourceHandlerRegistry registry ) {
		registry.addResourceHandler( "swagger-ui.html" ).addResourceLocations( "classpath:/META-INF/resources/" );
		registry.addResourceHandler( "/webjars/**" ).addResourceLocations( "classpath:/META-INF/resources/webjars/" );
	}
}
