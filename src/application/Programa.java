package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int num = sc.nextInt();
		System.out.print("Data de check-In (dd/mm/yyyy): ");
		Date dataChecIn = sdf.parse(sc.next());
		System.out.print("Data do check-out (dd/mm/yyyy): ");
		Date dataChecOut = sdf.parse(sc.next());

		if (!dataChecOut.after(dataChecIn)) {
			System.out.println("ERRO na reserva - A data de Check-Out deve ser depois da de Ckeck-In");
		} else {
			Reserva reserv = new Reserva(num, dataChecIn, dataChecOut);
			System.out.println("Reserva: " + reserv);

			System.out.println();
			System.out.println("Entre com a data para a atualização da reserva:");
			System.out.print("Data de check-In (dd/mm/yyyy): ");
			dataChecIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/yyyy): ");
			dataChecOut = sdf.parse(sc.next());

			Date agora = new Date();

			if (dataChecIn.before(agora) || dataChecOut.before(dataChecOut)) {
				System.out.println("Erro  - As datas de atualização da reserva devem ser futuras.");
			} else if (!dataChecOut.after(dataChecIn)) {
				System.out.println("ERRO na reserva - A data de Check-Out deve ser depois da de Ckeck-In");

			} else {

				reserv.updateData(dataChecIn, dataChecOut);
				System.out.println("Reserva: " + reserv);
			}
		}
	}
}
