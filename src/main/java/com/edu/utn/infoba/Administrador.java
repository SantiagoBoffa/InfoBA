package com.edu.utn.infoba;

import java.util.Collection;

public class Administrador
{
	private Repositorio repositorio;
	
	public void crear(String nombre, Direccion direccion, Coordenadas coordenadas, Rubro rubro)
	{
		Comercio Comercio  = new Comercio (nombre,direccion,coordenadas,rubro);
		repositorio.agregarPuntoDeInteres(Comercio);
	}
	public void crear(String nombre, Direccion direccion, Coordenadas coordenadas)
	{
		ParadaColectivos Parada_Colectivos  = new ParadaColectivos ( nombre,  direccion,  coordenadas);
		repositorio.agregarPuntoDeInteres(Parada_Colectivos);
	}
	public void delete (String texto)
	{
		Collection<PuntoDeInteres> puntosDeInteres;
		puntosDeInteres = repositorio.buscarPuntoDeInteresPorTexto(texto);
		for(PuntoDeInteres poi : puntosDeInteres)
		{
			repositorio.eliminarPuntoDeInteres(poi);
			poi=null;
		}
	}
	public void modificar (Comercio poi ,String nombre, Direccion direccion, Coordenadas coordenadas, Rubro rubro)
	{
		poi.modificar(nombre, direccion, coordenadas, rubro);
	}
	public void modificar (ParadaColectivos poi ,String nombre, Direccion direccion, Coordenadas coordenadas)
	{
		poi.modificar(nombre, direccion, coordenadas);
	}
	public Collection<PuntoDeInteres> consulta (String texto)
	{
		Collection<PuntoDeInteres> puntosDeInteres;
		puntosDeInteres = repositorio.buscarPuntoDeInteresPorTexto(texto);
		return puntosDeInteres;
	}
	
}