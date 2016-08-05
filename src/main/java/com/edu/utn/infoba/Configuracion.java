package com.edu.utn.infoba;

import java.io.*;
import java.util.Properties;

public class Configuracion
{

   public String obtenerURLComponenteExterno(String filePath)
   {
       String result = "";
       InputStream inputStream = null;

        try
        {
            Properties prop = new Properties();
            inputStream = new FileInputStream(filePath);

            if (inputStream != null)
            {
                prop.load(inputStream);
            }
            else
            {
                throw new FileNotFoundException("property file '" + filePath + "' not found in the classpath");
            }

            // get the property value and print it out
            result = prop.getProperty("consultasURL");
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
        }
        finally
        {
            try { inputStream.close(); }
            catch (IOException e) {return null;}
        }

        return result;
   }
}
