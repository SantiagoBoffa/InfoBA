package com.edu.utn.infoba;

import java.util.Collection;
import java.util.HashSet;

public class Repositorio
{
	private HashSet<PuntoDeInteres> PuntosDeInteres;
	private HashSet<Administrador> Administradores;
	
	public Repositorio()
    {
		PuntosDeInteres = new HashSet<PuntoDeInteres>();
		Administradores = new HashSet<Administrador>();
	}
	
	public void agregarPuntoDeInteres(PuntoDeInteres puntoDeInteres){
		this.PuntosDeInteres.add(puntoDeInteres);
	}
	
	public void eliminarPuntoDeInteres(PuntoDeInteres puntoDeInteres){
		this.PuntosDeInteres.remove(puntoDeInteres);
	}
	
	public Collection<PuntoDeInteres> buscarPuntoDeInteresPorTexto(String texto){
		HashSet<PuntoDeInteres> puntosDeInteres;
		puntosDeInteres = new HashSet<PuntoDeInteres>();
		
		for(PuntoDeInteres poi : PuntosDeInteres){
			if(poi.buscarTexto(texto)){
				puntosDeInteres.add(poi);
			}
		}
		return puntosDeInteres;
	}
	
	public Boolean login(String usuario, String password){
		return false;
	}
	
	public void agregarAdministrador(Administrador admin){
		Administradores.add(admin);
	}
	
	public void eliminarAdministrador(Administrador admin){
		Administradores.remove(admin);
	}
}