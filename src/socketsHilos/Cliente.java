package socketsHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String Host="localhost";
		int Puerto=44000;
		Socket Cliente=new Socket (Host,Puerto);
		
		PrintWriter fsalida=new PrintWriter(Cliente.getOutputStream(),true);
		BufferedReader fentrada=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String cadena,eco="";
		
		do {
			System.out.println("Introduce cadena: ");
			cadena=in.readLine();
			fsalida.print(cadena);	
			eco=fentrada.readLine();
			System.out.println("    =>ECO: "+eco);
		}while(!cadena.trim().equals("*"));
		
		fsalida.close();
		fentrada.close();
		System.out.println("Fin del envío");
		in.close();
		Cliente.close();
		
	}

}
