package com.tunombre.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.tunombre.modelos.Cancion;
import com.tunombre.servicios.ServiciosCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ControladorCanciones {

	@Autowired
	private ServiciosCanciones servicioCanciones;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		modelo.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
		return "Canciones";
	}
	
	@GetMapping("/canciones/detalle/{id}")
	public String desplegarDetalleCancion(@PathVariable("id") long id, Model modelo) {
		modelo.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(id));
		return "detalleCancion";
	}
	
	@GetMapping("/canciones/formulario/agregar")
	public String formularioAgregarCancion(Model model) {
	    model.addAttribute("cancion", new Cancion());
	    return "agregarCancion";
	}

	@PostMapping("/canciones/procesa/agregar")
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult resultado) {
	    if (resultado.hasErrors()) {
	        return "agregarCancion";
	    }
	    servicioCanciones.agregarCancion(cancion);
	    return "redirect:/canciones";
	}
}