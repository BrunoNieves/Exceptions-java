package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
	
	
		
	Scanner teclado = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		
	//Entradas Processamento
	
	System.out.print("Room number: ");
	int number = teclado.nextInt();
	
	System.out.print("Check-in date (DD/MM/YYYY): ");
	Date checkIn = sdf.parse(teclado.next());
	
	System.out.print("Check-out date (DD/MM/YYYY): ");
	Date checkOut = sdf.parse(teclado.next());
	
	if (!checkOut.after(checkIn)) {
		System.out.println("Error in reservation: Check-out date must be after Check-in date");
	}
	else {
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);
		
		
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		
		System.out.print("Check-in date (DD/MM/YYYY): ");
		checkIn = sdf.parse(teclado.next());
		
		System.out.print("Check-out date (DD/MM/YYYY): ");
		checkOut = sdf.parse(teclado.next());
		
		String error = reservation.updateDates(checkIn, checkOut);
		if (error != null) {
			System.out.println("Error in reservation: " + error);
		}
		else { 
			System.out.println("Reservation: " + reservation);
		}
		
		
	}
	
	
	//Saida de Dados
	

	teclado.close();
	

	}

}
