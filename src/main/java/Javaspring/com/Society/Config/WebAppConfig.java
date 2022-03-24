package Javaspring.com.Society.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class WebAppConfig {
	
		@Bean
		public CommonsMultipartResolver multipartResolver() {
			CommonsMultipartResolver resolver = new CommonsMultipartResolver();
			resolver.setDefaultEncoding("UTF-8");
			
			return resolver;
		}
		@Bean
		public Cloudinary cloudinary() {
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
						"cloud_name", "dbjjh1p4j",
						"api_key", "145656188982428",
						"api_secret", "cPCyf3vXKa4thTNl9jRH-PiQ9Ck",
						"secure",true
					));
			return cloudinary;
		}
		
}
