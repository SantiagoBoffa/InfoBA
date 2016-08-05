package com.edu.utn.infoba;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class testCercaniaPOI
{

    private Repositorio repositorio;
    private Banco banco;
    private CGP cgp;
    private Comercio comercio;
    private ParadaColectivos colectivo;

    @Before
    public void setUp() throws Exception
    {
        repositorio = new Repositorio();

        Coordenadas coordenadas  = new Coordenadas(-34.603075, -58.381653); // Obelisco
        Coordenadas coordenadas2 = new Coordenadas(-34.608333, -58.371944); // Plaza de mayo
        Coordenadas coordenadas3 = new Coordenadas(22.0, 15.0);
        Rubro rubro = new Rubro("Muebleria", 200.0);

        Banco banco1 = new Banco("ITAU", null, coordenadas);
        Banco banco2 = new Banco("Nacion", null, coordenadas);

        Banco cgp1 = new Banco("CGP1", null, coordenadas2);
        Banco cgp2 = new Banco("CGP24", null, coordenadas2);

        comercio = new Comercio("LosMuebles", null, coordenadas3, rubro);

        colectivo = new ParadaColectivos("7y101",null, coordenadas3);

        repositorio.agregarPuntoDeInteres(banco);
        repositorio.agregarPuntoDeInteres(cgp);
        repositorio.agregarPuntoDeInteres(comercio);
        repositorio.agregarPuntoDeInteres(colectivo);
    }

    @Test
    public void testBanco()
    {
        Coordenadas coordenadas  = new Coordenadas(-34.603075, -58.381653); // Obelisco
        Coordenadas coordenadas2 = new Coordenadas(-34.608333, -58.371944); // Plaza de mayo

        Banco banco1 = new Banco("ITAU", null, coordenadas);
        Banco banco2 = new Banco("Nacion", null, coordenadas);

        Banco banco3 = new Banco("Nacion", null, coordenadas2);

        Boolean cercaniaBancos  = banco1.cercaDe(banco2);
        Boolean cercaniaBancos2 = banco1.cercaDe(banco3);

        // TODO: esto dá 1.0636 KM o 1063,6836 M
        System.out.print(coordenadas.distanciaCon(coordenadas2));

        assertTrue(cercaniaBancos);
        assertFalse(cercaniaBancos2);

    }

    @Test
    public void testCGP()
    {

        Coordenadas coordenadas = new Coordenadas(51.0,73.0);

        Banco cgp1 = new Banco("CGP1", null, coordenadas);
        Banco cgp2 = new Banco("CGP24", null, coordenadas);

        Coordenadas coordenadas2 = new Coordenadas(51.0,20.0);
        Banco cgp3 = new Banco("CGP25", null, coordenadas2);

        Boolean cercaniaCGP = cgp1.cercaDe(cgp2);
        Boolean cercaniaCGP2 = cgp1.cercaDe(cgp3);

        assertTrue(cercaniaCGP);
        assertFalse(cercaniaCGP2);

    }

    @Test
    public void testComercio()
    {
        Coordenadas coordenadas  = new Coordenadas(-34.603075, -58.381653); // Obelisco
        Coordenadas coordenadas2 = new Coordenadas(-34.608333, -58.371944); // Plaza de mayo

        Rubro rubroKiosko = new Rubro("Kiosko",100.0);

        Comercio comercio1 = new Comercio("Kiosko 1", null, coordenadas, rubroKiosko);
        Comercio comercio2 = new Comercio("Kiosko2", null, coordenadas, rubroKiosko);

        Comercio comercio3 = new Comercio("CGP25", null, coordenadas2, rubroKiosko);

        Boolean cercaniaComercio = comercio1.cercaDe(comercio2);
        Boolean cercaniaComercio2 = comercio1.cercaDe(comercio3);

        assertTrue(cercaniaComercio);
        assertFalse(cercaniaComercio2);
    }

    @Test
    public void testParadaColectivo()
    {
        Coordenadas coordenadas = new Coordenadas(51.0,73.0);

        ParadaColectivos parada1 = new ParadaColectivos("CGP1", null, coordenadas);
        ParadaColectivos parada2 = new ParadaColectivos("CGP24", null, coordenadas);

        Coordenadas coordenadas2 = new Coordenadas(51.0,20.0);
        ParadaColectivos parada3 = new ParadaColectivos("CGP25", null, coordenadas2);

        Boolean cercaniaParada = parada1.cercaDe(parada2);
        Boolean cercaniaParada2 = parada1.cercaDe(parada3);


        assertTrue(cercaniaParada);
        assertFalse(cercaniaParada2);
    }
}
