package com.personal.personale;

import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.logging.Log;



@SpringBootApplication
public class PersonalApplication {

		protected static final Log logger = LogFactory.getLog(PersonalApplication.class);


		public static void main(String[] args) {

		logger.info("the document  Swagger is in link: ==>  http://localhost:1111/personal/swagger-ui.html");

			SpringApplication.run(PersonalApplication.class, args);


		logger.info("the document  Swagger is in link: ==>  http://localhost:1111/personal/swagger-ui.html");
	}

}

