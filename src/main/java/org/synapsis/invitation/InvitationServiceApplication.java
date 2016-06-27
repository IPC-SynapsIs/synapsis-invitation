package org.synapsis.invitation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class InvitationServiceApplication {

	/**
	 *
	 * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(InvitationServiceApplication.class, args);
	}
}
