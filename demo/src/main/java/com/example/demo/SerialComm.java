package com.example.demo;
import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class SerialComm {

    SerialPort arduino = SerialPort.getCommPort("COM3");
    PrintWriter arduinoOut = new PrintWriter(arduino.getOutputStream());
    InputStream in = arduino.getInputStream();
    String[] colors = {"Azul", "Verde", "Vermelho"};
    int[] led = {2, 3, 4};

    public SerialComm() {

        arduino.setComPortParameters(9600, 8, 1, 0);
        arduino.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (!arduino.openPort()) {

            System.out.println("Porta Fechada!");

        } else {

            System.out.println("Porta aberta. Conectado!");

        }
    }

    public void setState(String state) {

        arduinoOut.print(state);
        arduinoOut.flush();

    }

    public String getState(String command) throws IOException, InterruptedException {

        arduinoOut.print(command);
        arduinoOut.flush();

        char state = '0';

        Thread.sleep(60);

        while (in.available() > 0) {

            state = (char) in.read();
            in.close();

        }

        return calculateLabelState(command, state);

    }

    public String calculateLabelState (String command, char state) {

        int ledPosition = Integer.parseInt(command.substring(1));

        String labelState = "";

        for (int i = 0; i < led.length; i++) {

            if (ledPosition == led[i]) {

                if (state == '0') {

                    labelState = "O Led " + colors[i] + " está Ligado";

                } else {

                    labelState = "O Led " + colors[i] + " está Desligado";

                }
            }
        }

        return labelState;

    }
}