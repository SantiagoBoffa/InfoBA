

import java.util.Date;
import java.util.HashSet;

public abstract class PuntoDeInteres
{
   public String Nombre;
   public Direccion Direccion;
   public Coordenadas Coordenadas;
   public String Descripcion;
   private HashSet<String> Tags; 

   public PuntoDeInteres(String nombre, Direccion direccion, Coordenadas coordenadas)
   {
     this.Nombre = nombre;
     this.Direccion = direccion;
     this.Coordenadas = coordenadas;
     this.Tags = new HashSet<String>();
   }

   public Boolean distanciaMenorA(Double metros, PuntoDeInteres otroPunto)
   {
       Double distancia = this.Coordenadas.distanciaCon(otroPunto.Coordenadas);

       return (distancia < metros);
   }

   // Tiene nombre y esta geolocalizado (tiene coordenadas)
   public Boolean esValido()
   {
     return ((Nombre!=null) && !Nombre.isEmpty()&& (Coordenadas!= null));
   }

   public Boolean cercaDe(PuntoDeInteres otroPunto)
   {
      return distanciaMenorA(5.0, otroPunto);
   }

   
   public String getInfo()
    {
        return "Info.";
    }
   
   public void agregarTag(String tag){
	   Tags.add(tag);
   }
   
   public void sacarTag(String tag){
	   Tags.remove(tag);
   }
   
   public Boolean buscarTexto(String texto){
	   return (Tags.contains(texto) || this.Nombre.contains(texto) || this.buscarServicios(texto) || this.buscarRubros(texto) );
   }
   
   public boolean buscarServicios(String texto){
	   return false;
   }
   
   public boolean buscarRubros(String texto){
	   return false;
   }
   public boolean disponibilidad(Date tiempo , Servicio serv)
   {
   	return false;
   }

}