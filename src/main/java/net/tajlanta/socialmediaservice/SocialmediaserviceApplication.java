package net.tajlanta.socialmediaservice;

import net.tajlanta.socialmediaservice.entity.User;
import net.tajlanta.socialmediaservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SocialmediaserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(SocialmediaserviceApplication.class, args);
	}


}
