

public class Rubro{
	private String Nombre;
	private Number RadioCercania;
	
	public Rubro(String nombre,Number radioCercania){
		this.Nombre = nombre;
		this.RadioCercania = radioCercania;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Number getRadioCercania() {
		return RadioCercania;
	}
	public void setRadioCercania(Number radioCercania) {
		RadioCercania = radioCercania;
	}
}

