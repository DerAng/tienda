package co.ufps.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "co.ufps.edu.*" })
public class WebConfig extends WebMvcConfigurerAdapter {
	// Bean name must be "multipartResolver", by default Spring uses method name as
	// bean name.
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	  @Bean
	  public ViewResolver resourceBundleViewResolver() {
	    ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
	    viewResolver.setBasename("views");
	    viewResolver.setOrder(1);
	    return viewResolver;
	  }

	
	@Bean
	public InternalResourceViewResolver resolver() {
		// 2. Registra los jsp
		System.out.println("Cargar clasee");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(2);
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 3. Registrar los Recursos (Css,JS,font,entre otros)
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
