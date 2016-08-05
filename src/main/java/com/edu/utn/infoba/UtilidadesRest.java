package com.edu.utn.infoba;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UtilidadesRest
{

    public String LeerDeURL(String designatedURL)
    {
        String respuesta = "";

        try
        {
            URL restAPIURL = new URL(designatedURL);
            URLConnection yc = restAPIURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null)
            {
                respuesta += inputLine;
            }

            in.close();
        }
        catch (Exception e)
        {
            // Ocurrio una excepción de algun tipo.
            System.out.print(e.toString());
            return null;
        }

        return respuesta;

    }

}
