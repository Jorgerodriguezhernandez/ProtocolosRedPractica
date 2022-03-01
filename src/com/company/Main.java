package com.company;

import com.jcraft.jsch.*;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Session session = null;
        ChannelExec channel = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce usuario");
        String usuario= sc.nextLine();
        System.out.println("Introduce Contraseña");
        String password= sc.nextLine();
        System.out.println("Introduce puerto");
        int puerto = sc.nextInt();
        System.out.println("introduce IP");
        String host = sc.nextLine();
        boolean encontrado = true;

        try{
            session = new JSch().getSession(usuario, host, puerto);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            while (encontrado) {
                System.out.println("Introduce el nombre del archivo a leer o 'salir' para abandonar el programa");
                String archivo = sc.nextLine();
                if (archivo.equals("salir")){
                    System.out.println("Has salido del programa >> salir <<");
                    encontrado=false;
                }else{
                    channel = (ChannelExec) session.openChannel("exec");
                    channel.setCommand("cat /var/log/" + archivo);

                    ByteArrayOutputStream response = new ByteArrayOutputStream();
                    channel.setOutputStream(response);
                    channel.connect();

                    while (channel.isConnected()) {
                        Thread.sleep(100);
                    }

                    String responseString = new String(response.toByteArray());
                    System.out.println(responseString);
                }

            }

        }catch (JSchException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
