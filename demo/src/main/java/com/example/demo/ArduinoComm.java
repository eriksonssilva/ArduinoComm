package com.example.demo;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ArduinoComm {

	SerialComm comm;

	public ArduinoComm() throws InterruptedException {
		comm = new SerialComm();
	}

	public static void main(String[] args) {
		SpringApplication.run(ArduinoComm.class, args);
	}

	@PostMapping("/")


	public void arduinoCommand(@RequestParam(value = "command") boolean command) throws IOException, InterruptedException {

		comm.setEstado(command);

	}
}

