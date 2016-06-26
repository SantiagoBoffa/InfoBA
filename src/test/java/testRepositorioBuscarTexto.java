
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class testRepositorioBuscarTexto {
	private Repositorio repositorio;
	private Banco banco;
	private CGP cgp;
	private Comercio comercio;
	private ParadaColectivos colectivo;
	@Before
	public void setUp() throws Exception {
		repositorio = new Repositorio();
		banco = new Banco("ITAU",null,new Coordenadas(new Double(1),new Double(10)));
		banco.agregarServicio(new Servicio("Cobros"));
		banco.agregarServicio(new Servicio("Pagos"));
		banco.agregarServicio(new Servicio("Atencion al cliente"));
		banco.agregarTag("tag1");
		cgp = new CGP("Comuna10",null,new Coordenadas(new Double(2),new Double(13)));
		cgp.agregarServicio(new Servicio("Atencion ciudadana"));
		cgp.agregarServicio(new Servicio("Pagos"));
		cgp.agregarServicio(new Servicio("Tramites"));
		cgp.agregarTag("tag2");
		comercio = new Comercio("LosMuebles",null,new Coordenadas(new Double(15),new Double(55)),new Rubro("Muebleria",200));
		comercio.agregarTag("tag3");
		colectivo = new ParadaColectivos("7y101",null,new Coordenadas(new Double(2),new Double(13)));
		colectivo.agregarTag("UTN");
		repositorio.agregarPuntoDeInteres(banco);
		repositorio.agregarPuntoDeInteres(cgp);
		repositorio.agregarPuntoDeInteres(comercio);
		repositorio.agregarPuntoDeInteres(colectivo);
		
	}

	@Test
	public void testBanco() {
		assertTrue("Fall� busqueda de banco por nombre",repositorio.buscarPuntoDeInteresPorTexto("ITAU").contains(banco));
		assertTrue("Fall� busqueda de banco por tags",repositorio.buscarPuntoDeInteresPorTexto("tag1").contains(banco));
		assertTrue("Fall� busqueda de banco por servicio1",repositorio.buscarPuntoDeInteresPorTexto("Cobros").contains(banco));
		assertTrue("Fall� busqueda de banco por servicio2",repositorio.buscarPuntoDeInteresPorTexto("Atencion").contains(banco));
	}

	@Test
	public void testCGP() {
		assertTrue("Fall� busqueda de CGP por nombre",repositorio.buscarPuntoDeInteresPorTexto("Comuna").contains(cgp));
		assertTrue("Fall� busqueda de CGP por tag",repositorio.buscarPuntoDeInteresPorTexto("tag2").contains(cgp));
		assertTrue("Fall� busqueda de CGP por servicio1",repositorio.buscarPuntoDeInteresPorTexto("Pagos").contains(cgp));
		assertTrue("Fall� busqueda de CGP por servicio2",repositorio.buscarPuntoDeInteresPorTexto("ciudadana").contains(cgp));
	}
	
	@Test
	public void testComercio() {
		assertTrue("Fall� busqueda de comercio por nombre",repositorio.buscarPuntoDeInteresPorTexto("Muebles").contains(comercio));
		assertTrue("Fall� busqueda de comercio por tags",repositorio.buscarPuntoDeInteresPorTexto("tag3").contains(comercio));
		assertTrue("Fall� busqueda de comercio por rubro",repositorio.buscarPuntoDeInteresPorTexto("Muebleria").contains(comercio));
	}
	
	@Test
	public void testColectivo() {
		assertTrue("Fall� busqueda de colectivo por nombre",repositorio.buscarPuntoDeInteresPorTexto("101").contains(colectivo));
		assertTrue("Fall� busqueda de colectivo por tags",repositorio.buscarPuntoDeInteresPorTexto("UTN").contains(colectivo));
	}
	
}
