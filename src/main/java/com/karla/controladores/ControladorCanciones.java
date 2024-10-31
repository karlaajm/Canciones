package com.karla.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.karla.modelos.Cancion;
import com.karla.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	@Autowired
	ServicioCanciones servicio;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		List<Cancion> canciones =  servicio.obtenerTodasLasCanciones();
		modelo.addAttribute("canciones", canciones);
		return "canciones.jsp";
	}
	
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(Model modelo, @PathVariable Long idCancion) {
		Cancion cancion = servicio.obtenerCancionPorId(idCancion);
		modelo.addAttribute("cancion", cancion);
		return "detalleCancion.jsp";
	}
	
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(@ModelAttribute Cancion cancion) {
		return "agregarCancion.jsp";
	}
	
	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion, BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "agregarCancion.jsp";
		}
		servicio.agregarCancion(cancion);
		return "redirect:/canciones";
	}
	
	@GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(Model modelo, @PathVariable Long idCancion) {
		Cancion cancion = servicio.obtenerCancionPorId(idCancion);
		modelo.addAttribute("cancion", cancion);
		return "editarCancion.jsp";
	}
	
	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@Valid @ModelAttribute Cancion cancion, BindingResult validaciones, @PathVariable Long idCancion) {
		if (validaciones.hasErrors()) {
			return "editarCancion.jsp";
		}
		cancion.setId(idCancion);
		servicio.actualizarCancion(cancion);
		return "redirect:/canciones";
	}
	
	@DeleteMapping("/canciones/eliminar/{idCancion}")
   	public String procesarEliminarCancion(@PathVariable Long idCancion) {
		servicio.eliminaCancion(idCancion);
		return "redirect:/canciones";
   	}
}
