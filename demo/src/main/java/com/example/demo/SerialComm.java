package com.example.demo;
import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;

public class SerialComm {

    public boolean ligado;
    SerialPort arduino = SerialPort.getCommPort("COM3");

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

    public void setEstado(boolean ligado) throws IOException {

        this.ligado = ligado;

            if (ligado == true) {

                arduino.getOutputStream().write('1');

            } else {

                arduino.getOutputStream().write('2');

            }

    }
}
