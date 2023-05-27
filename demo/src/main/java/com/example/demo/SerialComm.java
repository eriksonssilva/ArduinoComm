package com.example.demo;
import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.io.PrintWriter;

public class SerialComm {

    public int estado;
    SerialPort arduino = SerialPort.getCommPort("COM3");
    PrintWriter arduinoOut = new PrintWriter(arduino.getOutputStream());

    public SerialComm () throws InterruptedException {


        arduino.setComPortParameters(9600, 8, 1, 0);
        arduino.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (!arduino.openPort()) {

            System.out.println("Porta Fechada!");

        } else {

            Thread.sleep(2000);
            System.out.println("Porta aberta. Conectado!");

        }


    }

    public void setEstado(int estado) throws IOException {


        this.estado = estado;

        arduinoOut.println(this.estado);
        arduinoOut.flush();


    }
}
