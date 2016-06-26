
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Before;
import org.junit.Test;

public class testDisponibilidad {
	private Banco banco;
	private CGP cgp;
	private Comercio comercio;
	private ParadaColectivos colectivo;
	private DisponibilidadHoraria disponi ;
	private DisponibilidadHoraria disponi1 ;
	private DisponibilidadHoraria disponi2 ;
	private Servicio serv1 ;
	private Servicio serv2 ;
	private Servicio serv3 ;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date = new Date();
	private DisponibilidadHoraria disponi3;
	private DisponibilidadHoraria disponi4;
	private DisponibilidadHoraria disponi5;
	private DisponibilidadHoraria disponi6;
	private Servicio serv4;
	private Servicio serv5;
	private Servicio serv6;
	private Date tiempo1;
	private Date tiempo2;
	private Date tiempo3;
	private Date tiempo4;
	private Date tiempo5;
	private Date tiempoM;
	@Before
	public void setUp() throws Exception {
		
		colectivo = new ParadaColectivos("7y101",null,new Coordenadas(new Double(2),new Double(13)));
		
		cgp = new CGP("Comuna10",null,new Coordenadas(new Double(2),new Double(13)));
		
		disponi =  new DisponibilidadHoraria(3, 11, 0 , 19, 30);
		disponi1 =  new DisponibilidadHoraria(6, 11, 0 , 19, 30);
		disponi2 =  new DisponibilidadHoraria(1, 10, 0 , 15, 00);
		
		serv1 = new Servicio("Rentas");
		cgp.agregarServicio(serv1);
		serv1.setDisponibilidadHoraria(disponi);
		
		serv2 = new Servicio("Pagos");
		cgp.agregarServicio(serv2);
		serv2.setDisponibilidadHoraria(disponi1);
		
		serv3 = new Servicio("Tramites");
		cgp.agregarServicio(serv3);
		serv3.setDisponibilidadHoraria(disponi2);
		
		
		banco = new Banco("ITAU",null,new Coordenadas(new Double(1),new Double(10)));
		disponi3 =  new DisponibilidadHoraria(4, 10, 0 , 15, 00);
		disponi4 =  new DisponibilidadHoraria(3, 10, 0 , 15, 00);
		disponi5 =  new DisponibilidadHoraria(4, 10, 0 , 11, 30);
		
		serv4 = new Servicio("Atencion ciudadana");
		serv4.setDisponibilidadHoraria(disponi3);
		banco.agregarServicio(serv4);
		
		serv5 = new Servicio("Pagos");
		serv5.setDisponibilidadHoraria(disponi4);
		banco.agregarServicio(serv5);
		
		serv6 = new Servicio("Tramites");
		serv6.setDisponibilidadHoraria(disponi5);
		banco.agregarServicio(serv6);
		
		comercio = new Comercio("LosMuebles",null,new Coordenadas(new Double(15),new Double(55)),new Rubro("Muebleria",200));
		disponi6 =  new DisponibilidadHoraria(5, 8, 0 , 19, 30);
		comercio.setDisponibilidadHoraria(disponi6);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "15-06-2016 10:20:56";
		tiempo1 = sdf.parse(dateInString);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString1 = "23-06-2016 11:00:56";
		tiempo2 = sdf1.parse(dateInString1);
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString3 = "22-06-2016 17:20:56";
		tiempo3 = sdf3.parse(dateInString3);
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString4 = "06-06-2016 10:20:56";
		tiempo4 = sdf4.parse(dateInString4);
		
		SimpleDateFormat sdf5 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString5 = "24-06-2016 11:20:56";
		tiempo5 = sdf5.parse(dateInString5);
		
		SimpleDateFormat sdf6 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString6 = "24-06-2016 23:20:56";
		tiempoM = sdf6.parse(dateInString6);
	}

	@Test
	public void testBanco() {
		assertTrue("Fall� disponibilidad de Banco con servicio",banco.disponibilidad(tiempo2, serv4));
		assertTrue("Fall� disponibilidad de Banco con servicio null ",banco.disponibilidad(tiempo2, null));
		assertFalse("Fall� disponibilidad falsa por servicio no diponible",banco.disponibilidad(tiempoM, null));
	}

	@Test
	public void testCGP() {
		
		assertTrue("Fall� disponibilidad de CGP con servicio",cgp.disponibilidad(tiempo3, serv1));
		assertTrue("Fall� disponibilidad de CGP con servicio null",cgp.disponibilidad(tiempo4, null));
		assertFalse("Fall� disponibilidad falsa por servicio no diponible",cgp.disponibilidad(tiempoM, null));
	}
	
	@Test
	public void testComercio() {
		assertTrue("Fall� disponibilidad de Comercio",comercio.disponibilidad(tiempo5, null));
	}
	
	@Test
	public void testColectivo() {
		assertTrue("Fall� el calculo de la diponibilidad en colectivo",colectivo.disponibilidad(tiempo1, null));
	}
	
}
