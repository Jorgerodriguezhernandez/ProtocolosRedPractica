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



    }
}
