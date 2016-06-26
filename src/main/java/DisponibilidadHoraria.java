

import java.util.Date;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import java.text.SimpleDateFormat;


public class DisponibilidadHoraria{
	private int Dia;
	private int HoraDesde;
	private int MinutoDesde;
	private int HoraHasta;
	private int MinutoHasta;
	
	public DisponibilidadHoraria(int i, int j, int k, int l, int m) {
		this.Dia = i;
		this.HoraDesde = j;
		this.MinutoDesde  = k;
		this.HoraHasta = l;
		this.MinutoHasta = m;
	}
	public int getDia() {
		return Dia;
	}
	public void setDia(int dia) {
		Dia = dia;
	}
	public int getHoraDesde() {
		return HoraDesde;
	}
	public void setHoraDesde(int horaDesde) {
		HoraDesde = horaDesde;
	}
	public int getMinutoDesde() {
		return MinutoDesde;
	}
	public void setMinutoDesde(int minutoDesde) {
		MinutoDesde = minutoDesde;
	}
	public int getHoraHasta() {
		return HoraHasta;
	}
	public void setHoraHasta(int horaHasta) {
		HoraHasta = horaHasta;
	}
	public int getMinutoHasta() {
		return MinutoHasta;
	}
	public void setMinutoHasta(int minutoHasta) {
		MinutoHasta = minutoHasta;
	}

	public boolean coincideTiempo(Date tiempo) {
		String diaNumero = new SimpleDateFormat("u").format(tiempo);

		if(Integer.parseInt(diaNumero) == this.getDia())
		{
			if(tiempo.getHours() < this.getHoraHasta() && tiempo.getHours() > this.getHoraDesde())
			{	
				return true;
			}
			
			else if (tiempo.getHours() == this.getHoraHasta()) {
				
				if(tiempo.getMinutes() <= this.getMinutoHasta() )
				{
					return true;
				}
			}
			else if (tiempo.getHours() == this.getHoraDesde())
			{
				if(tiempo.getMinutes() >= this.getMinutoDesde())
				{
					return true;
				}
			}
		}
		return false;
	}
}