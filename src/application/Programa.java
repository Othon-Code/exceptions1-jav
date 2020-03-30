package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Programa {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	try {
			System.out.print("Numero do quarto: ");
			int num = sc.nextInt();
			System.out.print("Data de check-In (dd/mm/yyyy): ");
			Date dataChecIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/yyyy): ");
			Date dataChecOut = sdf.parse(sc.next());
		
			Reserva reserv = new Reserva(num, dataChecIn, dataChecOut);
			System.out.println("Reserva: " + reserv);
		
			System.out.println();
			System.out.println("Entre com a data para a atualização da reserva:");
			System.out.print("Data de check-In (dd/mm/yyyy): ");
			dataChecIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/yyyy): ");
			dataChecOut = sdf.parse(sc.next());
		
			reserv.updateData(dataChecIn, dataChecOut);
			System.out.println("Reserva: " + reserv);
         }
	catch(ParseException e) {
		System.out.println("Formato inválido de data");
	}
	catch(DomainException e) {
		System.out.println("Erro na resreva: "+e.getMessage());
	}
	catch(RuntimeException e) {
		System.out.println("Erro inexperado !!!");
	}

		sc.close();
	}
}
