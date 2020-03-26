package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) {
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}

	public String updateData(Date checkIn, Date checkOut) {

		Date agora = new Date();

		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro  - As datas de atualização da reserva devem ser futuras.";
		}
		if (!checkOut.after(checkIn)) {
			return "ERRO na reserva - A data de Check-Out deve ser depois da de Ckeck-In";

		}

		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Quarto: " + numQuarto + ", Check-In: " + sdf.format(checkIn) + ", Check-Out: " + sdf.format(checkOut)
				+ ", " + duracao() + " noites";
	}

}
