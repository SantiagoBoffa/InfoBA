package com.edu.utn.infoba;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class Comercio extends PuntoDeInteres
{

    public Rubro Rubro;
    public Rubro getRubro() {
		return Rubro;
	}

	public void setRubro(Rubro rubro) {
		Rubro = rubro;
	}

	private HashSet<DisponibilidadHoraria> DisponibilidadesHoraria;

    public Comercio(String nombre, Direccion direccion, Coordenadas coordenadas, Rubro rubro)
    {
        // Llamada al constructor de POI.
        super(nombre, direccion, coordenadas);
        this.DisponibilidadesHoraria = new HashSet<DisponibilidadHoraria>();
        this.Rubro = rubro;
    }

    // Esta cerca de otra parada de colectivos si esta a menos de una cuadra (e.d 100 metros).
    public Boolean cercaDe(PuntoDeInteres otroPunto)
    {
        return distanciaMenorA(this.Rubro.RadioCercania, otroPunto);
    }
    
    public boolean buscarRubros(String texto){
 	   return this.Rubro.Nombre.contains(texto);
    }
  

    public HashSet<DisponibilidadHoraria> getDisponibilidadHoraria() 
    {
    	return DisponibilidadesHoraria;
    }

    public void setDisponibilidadHoraria(DisponibilidadHoraria disponibilidadHoraria)
    {
		DisponibilidadesHoraria.add(disponibilidadHoraria);
	}

    public boolean disponibilidad(Date tiempo , Servicio servicio)
    {
    	String diaNumero = new SimpleDateFormat("u").format(tiempo);

    	if( Integer.parseInt(diaNumero) != 6 && Integer.parseInt(diaNumero) != 7)
    	{		
    		for (DisponibilidadHoraria s : DisponibilidadesHoraria) {
    		    if(s.coincideTiempo(tiempo))
    		    {
    		    	return true;
    		    }
    		}
    		return false;
    	}
    	else
    	{
    		return false;
    	}
    }
    public void modificar(String nombre, Direccion direccion, Coordenadas coordenadas, Rubro rubro)
	{
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setCoordenadas(coordenadas);
		this.setRubro(rubro);
	}
}
