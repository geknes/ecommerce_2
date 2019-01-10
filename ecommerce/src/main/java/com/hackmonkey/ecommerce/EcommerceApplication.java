package com.hackmonkey.ecommerce;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hackmonkey.ecommerce.entity.Categoria;
import com.hackmonkey.ecommerce.entity.Maestra;
import com.hackmonkey.ecommerce.entity.Segmento;
import com.hackmonkey.ecommerce.entity.Usuario;
import com.hackmonkey.ecommerce.entity.seguridad.Rol;
import com.hackmonkey.ecommerce.entity.seguridad.UsuarioRol;
import com.hackmonkey.ecommerce.service.interfaces.CategoriaService;
import com.hackmonkey.ecommerce.service.interfaces.MaestraService;
import com.hackmonkey.ecommerce.service.interfaces.SegmentoService;
import com.hackmonkey.ecommerce.service.interfaces.UsuarioService;
import com.hackmonkey.ecommerce.util.SeguridadUtilidad;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner{

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	SegmentoService segmentoService;
	
	@Autowired
	MaestraService maestraService;
	
	@Autowired
	CategoriaService categoriaService;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario();
		user1.setUsername("admin");
		user1.setPrimerNombre("Jorge");
		user1.setApellido("Graza");
		user1.setPassword(SeguridadUtilidad.passwordEncoder().encode("admin"));
		//user1.setPassword("admin");
		user1.setEmail("admin@gmail.com");
		Set<UsuarioRol> usuarioRols = new HashSet<>();
		Rol role1= new Rol();
		role1.setIdRol(0);
		role1.setNombreRol("ROLE_ADMIN");
		usuarioRols.add(new UsuarioRol(user1, role1));
		System.out.println("INICIO RUN()");
		usuarioService.crearUsuario(user1, usuarioRols);
		
		
		Segmento segmento = new Segmento();
		segmento.setNombreSegmento("HOMBRE");
		segmento.setEstado(true);
		segmento = segmentoService.guardar(segmento);
		
		Segmento segmento2 = new Segmento();
		segmento2.setNombreSegmento("MUJER");
		segmento2.setEstado(true);
		segmento2 = segmentoService.guardar(segmento2);
		
		Segmento segmento3 = new Segmento();
		segmento3.setNombreSegmento("HOGAR");
		segmento3.setEstado(true);
		segmento3 = segmentoService.guardar(segmento3);
		
		Maestra maestra = new Maestra();
		maestra.setCodigoRegistro(1L);
		maestra.setEstado(true);
		maestra.setNombreCorto("TALLA-LETRA");
		maestra.setOrden(0);
		maestra.setSweditable(true);
		maestra.setValor1("NOMBRE DE TABLA");
		maestra = maestraService.guardar(maestra);
		
		Maestra maestra2 = new Maestra();
		maestra2.setCodigoRegistro(2L);
		maestra2.setEstado(true);
		maestra2.setNombreCorto("SEXO");
		maestra2.setOrden(0);
		maestra2.setSweditable(true);
		maestra2.setValor1("NOMBRE DE TABLA");
		maestraService.guardar(maestra2);
		
		Maestra maestra3 = new Maestra();
		maestra3.setCodigoRegistro(3L);
		maestra3.setEstado(true);
		maestra3.setNombreCorto("COLOR");
		maestra3.setOrden(0);
		maestra3.setSweditable(true);
		maestra3.setValor1("NOMBRE DE TABLA");
		maestraService.guardar(maestra3);
		
		Maestra maestra4 = new Maestra();
		maestra4.setCodigoRegistro(1L);
		maestra4.setEstado(true);
		maestra4.setNombreCorto("TALLA-NUMERO");
		maestra4.setOrden(0);
		maestra4.setSweditable(true);
		maestra4.setValor1("NOMBRE DE TABLA");
		maestra4 = maestraService.guardar(maestra4);
		
		
		
		Categoria categoria = new Categoria();
		Segmento segmento4 = new Segmento();
		segmento4.setIdSegmento(3L);
		categoria.setEstado(true);
		categoria.setNombreCategoria("PANTALONES");
		categoria.setSegmento(segmento);
		categoriaService.guardar(categoria);
		
		Categoria categoria2 = new Categoria();
		categoria2.setEstado(true);
		categoria2.setNombreCategoria("VESTIDOS");
		categoria2.setSegmento(segmento2);
		categoriaService.guardar(categoria2);
		
		Categoria categoria3 = new Categoria();
		categoria3.setEstado(true);
		categoria3.setNombreCategoria("POLOS");
		categoria3.setSegmento(segmento);
		categoriaService.guardar(categoria3);
		
		Categoria categoria4 = new Categoria();
		categoria4.setEstado(true);
		categoria4.setNombreCategoria("PERFUMES");
		categoria4.setSegmento(segmento2);
		categoriaService.guardar(categoria4);
		
		Categoria categoria5 = new Categoria();
		categoria5.setEstado(true);
		categoria5.setNombreCategoria("MUEBLES");
		categoria5.setSegmento(segmento3);
		categoriaService.guardar(categoria5);
		
		//TALLAS
		
		Maestra maestra10 = new Maestra();
		maestra10.setCodigoRegistro(maestra.getIdMaestra());
		maestra10.setEstado(true);
		maestra10.setNombreCorto("XS");
		maestra10.setNombreLargo("EXTRA SMALL");
		maestra10.setOrden(1);
		maestra10.setSweditable(true);
		maestra10.setValor1(maestra.getNombreCorto());
		maestraService.guardar(maestra10);
		
		Maestra maestra5 = new Maestra();
		maestra5.setCodigoRegistro(maestra.getIdMaestra());
		maestra5.setEstado(true);
		maestra5.setNombreCorto("S");
		maestra5.setNombreLargo("SMALL");
		maestra5.setOrden(2);
		maestra5.setSweditable(true);
		maestra5.setValor1(maestra.getNombreCorto());
		maestraService.guardar(maestra5);
		
		Maestra maestra6 = new Maestra();
		maestra6.setCodigoRegistro(maestra.getIdMaestra());
		maestra6.setEstado(true);
		maestra6.setNombreCorto("M");
		maestra6.setNombreLargo("MEDIANO");
		maestra6.setOrden(3);
		maestra6.setSweditable(true);
		maestra6.setValor1(maestra.getNombreCorto());
		maestraService.guardar(maestra6);
		
		Maestra maestra7 = new Maestra();
		maestra7.setCodigoRegistro(maestra.getIdMaestra());
		maestra7.setEstado(true);
		maestra7.setNombreCorto("L");
		maestra7.setNombreLargo("LARGE");
		maestra7.setOrden(4);
		maestra7.setSweditable(true);
		maestra7.setValor1(maestra.getNombreCorto());
		maestraService.guardar(maestra7);
		
		Maestra maestra8 = new Maestra();
		maestra8.setCodigoRegistro(maestra.getIdMaestra());
		maestra8.setEstado(true);
		maestra8.setNombreCorto("XL");
		maestra8.setNombreLargo("EXTRA LARGE");
		maestra8.setOrden(5);
		maestra8.setSweditable(true);
		maestra8.setValor1(maestra.getNombreCorto());
		maestraService.guardar(maestra8);
		
		
		Maestra maestra9 = new Maestra();
		maestra9.setCodigoRegistro(maestra4.getIdMaestra());
		maestra9.setEstado(true);
		maestra9.setNombreCorto("28");
		maestra9.setNombreLargo("VEINTIOCHO");
		maestra9.setOrden(5);
		maestra9.setSweditable(true);
		maestra9.setValor1(maestra4.getNombreCorto());
		maestraService.guardar(maestra9);
		
		// COLORES
		Maestra maestra11 = new Maestra();
		maestra11.setCodigoRegistro(maestra3.getIdMaestra());
		maestra11.setEstado(true);
		maestra11.setNombreCorto("ROJO");
		maestra11.setNombreLargo("#ff3300");
		maestra11.setOrden(1);
		maestra11.setSweditable(true);
		maestra11.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra11);
		
		
		Maestra maestra12 = new Maestra();
		maestra12.setCodigoRegistro(maestra3.getIdMaestra());
		maestra12.setEstado(true);
		maestra12.setNombreCorto("ROSA");
		maestra12.setNombreLargo("#ff99cc");
		maestra12.setOrden(1);
		maestra12.setSweditable(true);
		maestra12.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra12);
		
		Maestra maestra13 = new Maestra();
		maestra13.setCodigoRegistro(maestra3.getIdMaestra());
		maestra13.setEstado(true);
		maestra13.setNombreCorto("NARANJA");
		maestra13.setNombreLargo("#ff9900");
		maestra13.setOrden(1);
		maestra13.setSweditable(true);
		maestra13.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra13);
		
		Maestra maestra14 = new Maestra();
		maestra14.setCodigoRegistro(maestra3.getIdMaestra());
		maestra14.setEstado(true);
		maestra14.setNombreCorto("AMARILLO");
		maestra14.setNombreLargo("#ffff00");
		maestra14.setOrden(1);
		maestra14.setSweditable(true);
		maestra14.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra14);
		
		Maestra maestra15 = new Maestra();
		maestra15.setCodigoRegistro(maestra3.getIdMaestra());
		maestra15.setEstado(true);
		maestra15.setNombreCorto("AZUL");
		maestra15.setNombreLargo("#0000ff");
		maestra15.setOrden(1);
		maestra15.setSweditable(true);
		maestra15.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra15);
		
		Maestra maestra16 = new Maestra();
		maestra16.setCodigoRegistro(maestra3.getIdMaestra());
		maestra16.setEstado(true);
		maestra16.setNombreCorto("TURQUESA");
		maestra16.setNombreLargo("#00ffff");
		maestra16.setOrden(1);
		maestra16.setSweditable(true);
		maestra16.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra16);
		
		Maestra maestra17 = new Maestra();
		maestra17.setCodigoRegistro(maestra3.getIdMaestra());
		maestra17.setEstado(true);
		maestra17.setNombreCorto("CELESTE");
		maestra17.setNombreLargo("#33ccff");
		maestra17.setOrden(1);
		maestra17.setSweditable(true);
		maestra17.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra17);
		
		
		Maestra maestra18 = new Maestra();
		maestra18.setCodigoRegistro(maestra3.getIdMaestra());
		maestra18.setEstado(true);
		maestra18.setNombreCorto("VERDE");
		maestra18.setNombreLargo("#009900");
		maestra18.setOrden(1);
		maestra18.setSweditable(true);
		maestra18.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra18);
		
		
		Maestra maestra19 = new Maestra();
		maestra19.setCodigoRegistro(maestra3.getIdMaestra());
		maestra19.setEstado(true);
		maestra19.setNombreCorto("BLANCO");
		maestra19.setNombreLargo("#ffffff");
		maestra19.setOrden(1);
		maestra19.setSweditable(true);
		maestra19.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra19);
		
		Maestra maestra20 = new Maestra();
		maestra20.setCodigoRegistro(maestra3.getIdMaestra());
		maestra20.setEstado(true);
		maestra20.setNombreCorto("NEGRO");
		maestra20.setNombreLargo("#000000");
		maestra20.setOrden(1);
		maestra20.setSweditable(true);
		maestra20.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra20);
		
		Maestra maestra21 = new Maestra();
		maestra21.setCodigoRegistro(maestra3.getIdMaestra());
		maestra21.setEstado(true);
		maestra21.setNombreCorto("GRIS");
		maestra21.setNombreLargo("#808080");
		maestra21.setOrden(1);
		maestra21.setSweditable(true);
		maestra21.setValor1(maestra3.getNombreCorto());
		maestraService.guardar(maestra21);
		
	}
}
