package com.olmo.prueba.productos;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.olmo.prueba.proveedor.Proveedor;
import com.olmo.prueba.proveedor.ProveedorDAO;




@Controller
public class RutasProducto {

	
	@Autowired
	ProductoDAO productoDAO;
	
	@Autowired
	ProveedorDAO proveedorDAO;
	
	@GetMapping("/productos")
	public ModelAndView todosLosProductos() {
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index(nuevo)"); /*Nombre del html que se muestra*/
		mav.addObject("prod",new Producto());
		
		List<Producto> listaProductos = (List<Producto>)productoDAO.findAll();
		mav.addObject("productos",listaProductos);
		
		List<Proveedor> listaProveedores = (List<Proveedor>)proveedorDAO.findAll();
		mav.addObject("proveedores",listaProveedores);
		
		
		return mav;
	}
	
	@PostMapping("/productos/anadir")
	public String productoAnadir(@ModelAttribute Producto producto) {
		
		
		
		productoDAO.save(producto);
		
		return "redirect:/productos";
	}
	
	@GetMapping("/productos/borrar/{id}")
	public String productosBorrar(@PathVariable String id) {
		
		productoDAO.deleteById(id);
		
		return "redirect:/productos";
	}
	
}