package com.bolsadeideas.springboot.app.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.IClienteService;
import com.bolsadeideas.springboot.app.models.service.IUploadFileService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IUploadFileService upLoadFileService;
	
	private final Logger log= LoggerFactory.getLogger(getClass());
	private final static String UPLOADS_FOLDER="uploads";
	
	
	
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Long id,Map<String, Object> model,RedirectAttributes flash) {
	
		Cliente cliente=clienteService.findOne(id);
		if(cliente==null) {
			flash.addFlashAttribute("error","El cliente no existe en nuestra BBDD");
			return "redirect:/listar";
					}
		model.put("cliente", cliente);
		model.put("titulo", "Detalles del Cliente: "+cliente.getNombre()+" "+cliente.getApellido());
		return "ver";
	}
	
	

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name="page",defaultValue="0") int page,Model model) {
		Pageable pageRequest= PageRequest.of(page,5);
		Page<Cliente> clientes= clienteService.findAll(pageRequest);
		
		PageRender<Cliente> pageRender= new PageRender<>("/listar",clientes);
		
		model.addAttribute("titulo", "Listado de clientes por página");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page",pageRender);
		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "form";
	}

	@RequestMapping(value = "/formCliente/{id}")
	public String editar(@PathVariable(value = "id") String id, Map<String, Object> model, RedirectAttributes flash) {

	    Cliente cliente = null;

	    try {
	        Long idCliente = Long.parseLong(id);
	        cliente = clienteService.findOne(idCliente);
	        
	        if (cliente == null) {
	            flash.addFlashAttribute("error", "El ID del cliente no existe en la BBDD!");
	            return "redirect:/listar";
	        }
	    } catch (NumberFormatException e) {
	        flash.addFlashAttribute("error", "El ID del cliente no es válido!");
	        return "redirect:/listar";
	    }

	    model.put("cliente", cliente);
	    model.put("titulo", "Editar Cliente");
	    return "form";
	}




	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status,@RequestParam(value = "file", required = false) MultipartFile foto) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		if(!foto.isEmpty()) {//REEEMPLAZO DE LA FOTO DEL CLIENTE, PRIMERO BORRAMOS
			/*
			 * Path directorioRecurso=Paths.get("src//main//resources//static/uploads");
			 * String rootPath=directorioRecurso.toFile().getAbsolutePath();
			 */
			//String rootPath="C://Temp//uploads";
			if(cliente.getId()!=null
					&& cliente.getId()>0
					&& cliente.getFoto().length()>0) {
				upLoadFileService.delete(cliente.getFoto());
															
			}
			String uniqueFilename=null;
			try {
				uniqueFilename=upLoadFileService.copy(foto);
			} catch (IOException e) {
				e.printStackTrace();
			}
			flash.addFlashAttribute("info","Has subido correctamente"+ uniqueFilename);
			cliente.setFoto(uniqueFilename);
			
			
		}
		
		String mensajeFlash = (cliente.getId() != null) ? "Cliente editado con éxito!" : "Cliente creado con éxito!";

		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}



	@RequestMapping(value = "/eliminarCliente/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			Cliente cliente=clienteService.findOne(id);			
			clienteService.delete(id);
			}
		
		return "redirect:/listar";
	}
}