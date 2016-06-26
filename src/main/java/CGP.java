
import java.util.HashSet;
import java.util.Date;


public class CGP extends PuntoDeInteres
{
	private HashSet<Servicio> Servicios;
	
    public CGP(String nombre, Direccion direccion, Coordenadas coordenadas)
    {
        super(nombre, direccion, coordenadas);
        Servicios = new HashSet<Servicio>();
    }

    public boolean buscarServicios(String texto){
  	   return Servicios.stream().anyMatch(serv -> serv.getNombre().contains(texto));
     }
    
    public boolean agregarServicio(Servicio servicio){
    	return Servicios.add(servicio);
    }
    
    public boolean removerServicio(Servicio servicio){
    	return Servicios.remove(servicio);
    }
    public boolean disponibilidad(Date tiempo , Servicio servicio)
    {
    	if( servicio != null)
    	{
    		
    	return servicio.estoyDisponible(tiempo);
    	}
    	else
    	{
    		//Si esta vacio recorre todos los servicios a ver si alguno esta disponible en ese horario
    		return this.Servicios.stream().anyMatch(serv -> serv.estoyDisponible(tiempo));
    	}
    }
}
