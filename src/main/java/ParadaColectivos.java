
import java.util.Date;

public class ParadaColectivos extends PuntoDeInteres
{
    public ParadaColectivos(String nombre, Direccion direccion, Coordenadas coordenadas)
    {
        // Llamada al constructor de POI.
        super(nombre, direccion, coordenadas);
    }

    // Esta cerca de otra parada de colectivos si esta a menos de una cuadra (e.d 100 metros).
    public Boolean cercaDe(PuntoDeInteres otroPunto)
    {
        return distanciaMenorA(100.0, otroPunto);
    }
    public boolean disponibilidad(Date tiempo , Servicio servicio)
    {
    	return true;
    }

}