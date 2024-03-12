package com.bolsadeideas.springboot.app.controllers;
import java.util.List;
import java.util.Map;

import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Coche;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.service.IClienteService;
import com.bolsadeideas.springboot.app.models.service.ICocheService;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
	@Autowired
	private IClienteService clienteService;

	@Autowired
	private ICocheService iCocheService;
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value="clienteId") Long clienteId, Map<String,Object> model,
			RedirectAttributes flash) {
		Cliente cliente =  clienteService.findOne(clienteId);
		if(cliente==null) {
			flash.addFlashAttribute("error","El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		Factura factura = new Factura();
		factura.setCliente(cliente);
		List<Coche> coches= iCocheService.findAll();

		model.put("coches", coches);
		model.put("factura", factura);
		model.put("titulo", "Creando la factura");
		
		
		return "factura/form";
		
	}

	@PostMapping("/form")
	public String guardar(@Valid Factura factura, BindingResult result, Model model, @RequestParam(name="itemId[]", required = false) Long[] itemId,
	@RequestParam(name="cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash, SessionStatus status){

	    if(result.hasErrors()){
	        model.addAttribute("titulo","NOOOOO");
	        return "factura/form";
	    }
	    if(itemId ==null || itemId.length ==0){
	        model.addAttribute("titulo","SIIIIIIII");
	        model.addAttribute("error","Error: la factura no puede no tener lineas! ");
	        return "factura/form";
	    }
	    for (int i = 0; i < itemId.length; i++) {
	        Coche coche = clienteService.findCocheById(itemId[i]);
	        ItemFactura linea = new ItemFactura();
	        linea.setCantidad(cantidad[i]);
	        linea.setCoche(coche);
	        factura.addItemFactura(linea);
	    }

	    clienteService.saveFactura(factura);
	    status.setComplete();
	    flash.addFlashAttribute("success","Factura creada con exito");
	    return"redirect:/ver/"+factura.getCliente().getId();
	}

	@GetMapping(value="/cargar-coche/{term}", produces= {"application/json"})
	public @ResponseBody List<Coche> cargarCoches(@PathVariable String term){
		return clienteService.findByNombre(term);
	}
	
	
	

}
