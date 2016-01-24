/**
 * 
 */
package org.makenotes.appl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.client.RestTemplate;

/**
 * @author udayd
 *
 */
@SpringBootApplication
@EnableSpringDataWebSupport
public class MakeNoteApplication {
	private final static Logger LOG = LoggerFactory.getLogger(MakeNoteApplication.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOG.info("Starting makenotes application");
		ApplicationContext ctx = SpringApplication.run(MakeNoteApplication.class, args);
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setFallbackToSystemLocale(true);
	    messageSource.setCacheSeconds(3600);
	    return messageSource;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
