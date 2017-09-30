package movietickets.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebSecurity
public class TicketsMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		String[] definitions = new String[] { "/WEB-INF/views/tiles.xml", "/WEB-INF/views/movies/tiles.xml" };
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(definitions);
		return tilesConfigurer;
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 1);
		return viewResolver;
	}
}
