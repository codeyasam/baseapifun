package codeyasam.baseapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import codeyasam.baseapi.config.StorageProperties;

@SpringBootApplication
public class BaseAPI {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BaseAPI.class, args);
		Path path = Paths.get("/home/codeyasam/Pictures/task.png");
		Path textFile = Paths.get("/home/codeyasam/Desktop/encodedImage.txt");
		try {
			byte[] byteArr = Files.readAllBytes(path);
			Files.write(textFile, Base64.getEncoder().encode(byteArr));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StorageProperties storageProperties = (StorageProperties) ctx.getBean("storageProperties");
		System.out.println(storageProperties.toString());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
