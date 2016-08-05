package com.edu.utn.infoba;

import java.util.HashSet;
import java.util.Date;


public class Banco extends PuntoDeInteres
{
	private HashSet<Servicio> Servicios;
	
    public Banco(String nombre, Direccion direccion, Coordenadas coordenadas)
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
	       	
	public boolean disponibilidad(Date tiempo , Servicio ser)
	    {
		
		 if(tiempo.getHours() <= 15 && tiempo.getHours() >= 10)
	    	{
			
	    	if( ser != null)
	    	{
	    		return ser.estoyDisponible(tiempo);
	    	}
	    	else
	    	{System.out.println(this.Servicios);
	    		for (Servicio s : this.Servicios) {
	    			 
	    		    if(s.estoyDisponible(tiempo))
	    		    {
	    		    	return true;
	    		    }
	    		}
	    		return false;
	    	}
	    	
	    }
		 return false;
	    }
}
