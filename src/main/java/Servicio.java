
import java.util.Date;
import java.util.HashSet;

public class Servicio {
	private String Nombre;
	private HashSet<DisponibilidadHoraria> DisponibilidadesHoraria;

	public Servicio(String nombre){
		this.Nombre = nombre;
		this.DisponibilidadesHoraria = new HashSet<DisponibilidadHoraria>();
	}
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public HashSet<DisponibilidadHoraria> getDisponibilidadHoraria() {
		return DisponibilidadesHoraria;
	}

	 public void setDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria) {			this.DisponibilidadesHoraria.add(disponibilidadHoraria);
		}

	public boolean estoyDisponible(Date tiempo) {

		for (DisponibilidadHoraria s : DisponibilidadesHoraria) {
		    if(s.coincideTiempo(tiempo))
		    {
		    	return true;
		    }
		}
		return false;
	}

}