package com.example.demo;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ArduinoComm {

	SerialComm serialPort;

	public ArduinoComm() {
		serialPort = new SerialComm();
	}

	public static void main(String[] args) {
		SpringApplication.run(ArduinoComm.class, args);
	}

	@PostMapping("/")
	public void arduinoSet(@RequestParam(value = "command") String command) throws IOException {

		serialPort.setState(command);

	}

	@GetMapping("/")
	public String arduinoGet(@RequestParam(value = "command") String command) throws IOException, InterruptedException {

		return serialPort.getState(command);

	}
}

