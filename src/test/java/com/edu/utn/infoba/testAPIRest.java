package com.edu.utn.infoba;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.edu.utn.infoba.*;
import java.net.*;
import java.io.*;

public class testAPIRest
{
    String UTF8Encoding = java.nio.charset.StandardCharsets.UTF_8.toString();

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testServicioBancos()
    {
        String configFile = "C:\\Users\\User\\Desktop\\com.edu.utn.infoba\\src";
        String query = "banco?servicio=pago&banco=galicia";

        Configuracion config = new Configuracion();
        String urlComponente = config.obtenerURLComponenteExterno(configFile);
        String apiURL = urlComponente + query;

        UtilidadesRest utils = new UtilidadesRest();
        String respuesta = utils.LeerDeURL(apiURL);

        System.out.println(respuesta);

        assertNotNull(respuesta);
        assertTrue(respuesta.length() > 0);
    }

    @Test
    public void testServicioCentros()
    {
        String configFile = "C:\\Users\\User\\Desktop\\com.edu.utn.infoba\\src";
        String query = "centro?zona=Boedo";

        Configuracion config = new Configuracion();
        String urlComponente = config.obtenerURLComponenteExterno(configFile);
        String apiURL = urlComponente + query;

        UtilidadesRest utils = new UtilidadesRest();
        String respuesta = utils.LeerDeURL(apiURL);

        System.out.println(respuesta);

        assertNotNull(respuesta);
        assertTrue(respuesta.length() > 0);
    }

}
