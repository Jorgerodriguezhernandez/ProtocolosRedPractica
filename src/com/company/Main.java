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

        try{
            session = new JSch().getSession(usuario, host, puerto);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("ls -l");

            ByteArrayOutputStream response = new ByteArrayOutputStream();
            channel.setOutputStream(response);
            channel.connect();

        }catch (JSchException e) {
            e.printStackTrace();
        }

    }
}
