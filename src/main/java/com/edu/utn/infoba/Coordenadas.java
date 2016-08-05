package com.edu.utn.infoba;

public class Coordenadas
{
   /*
    *  Coordenadas de ejemplo
    *  (-34.603075, -58.381653) - Obelisco
    *  (-34.608333, -58.371944) - Plaza de mayo.
    */

   public Double Latitud;
   public Double Longitud;

   public Coordenadas(Double latitud, Double longitud)
   {
      this.Latitud = latitud;
      this.Longitud = longitud;
   }

   /*
    * Calcula la distancia de una coordenada con otra.
    * OtraCoordenada: juego de coordenadas.
    * @returns: distancia entre las dos coordenadas (en metros).
    */
   public Double distanciaCon(Coordenadas OtraCoordenada)
   {

      /*
       *
       *  var R = 6371e3; // metres
       *  var φ1 = lat1.toRadians();
       *  var φ2 = lat2.toRadians();
       *  var Δφ = (lat2-lat1).toRadians();
       *  var Δλ = (lon2-lon1).toRadians();
       *
       *  var a = Math.sin(Δφ/2) * Math.sin(Δφ/2) + Math.cos(φ1) * Math.cos(φ2) * Math.sin(Δλ/2) * Math.sin(Δλ/2);
       *  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
       *  var d = R * c;
       *
      */


      Double lat1 = this.Latitud;
      Double lat2 = OtraCoordenada.Latitud;
      Double lon1 = this.Longitud;
      Double lon2 = OtraCoordenada.Longitud;

      Double R = 6371e3; // metres -- RADIO DE LA TIERRA?

      Double phi1 = Math.toRadians(this.Latitud);
      Double phi2 = Math.toRadians(OtraCoordenada.Latitud);
      Double dphi = Math.toRadians(lat2 - lat1);
      Double dDelta = Math.toRadians(lon2 - lon1);

      Double a = Math.sin(dphi/2) * Math.sin(dphi/2) + Math.cos(phi1) * Math.cos(phi2) * Math.sin(dDelta/2) * Math.sin(dDelta/2);
      Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

      Double d = R * c;

      return d;
   }

}
