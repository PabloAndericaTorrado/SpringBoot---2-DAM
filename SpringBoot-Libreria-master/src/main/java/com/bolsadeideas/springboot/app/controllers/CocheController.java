package com.bolsadeideas.springboot.app.controllers;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Coche;
import com.bolsadeideas.springboot.app.models.service.ICocheService;
import com.bolsadeideas.springboot.app.models.service.IUploadFileService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("coche")
public class CocheController {

    @Autowired
    private ICocheService cocheService;
    
    @Autowired
	private IUploadFileService upLoadFileService;
	
	private final Logger log= LoggerFactory.getLogger(getClass());
	private final static String UPLOADS_FOLDER="uploads";
	
	@GetMapping(value="/uploads/{filename:.+}")

	public ResponseEntity<Resource> verFoto(@PathVariable String filename){
		 Resource recurso=null;
		try {
			 recurso=upLoadFileService.load(filename);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+recurso.getFilename()+"\"").body(recurso);
	}
	@GetMapping({"/", "", "/index"})
	public String index(Model model) {
		return "index";
	}
	
	
	@GetMapping(value="/verCoche/{id}")
	public String ver(@PathVariable(value="id") Long id,Map<String, Object> model,RedirectAttributes flash) {
	
		Coche coche=cocheService.findOne(id);
		if(coche==null) {
			flash.addFlashAttribute("error","El Coche no existe en nuestra BBDD");
			return "redirect:/listarCoches";
					}
		model.put("coche", coche);
		model.put("titulo", "Detalles del Coche: "+coche.getMarca()+", "+coche.getMatricula());
		return "verCoche";
	}
	
	

	@RequestMapping(value = "/listarCoches", method = RequestMethod.GET)
	public String listar(@RequestParam(name="page",defaultValue="0") int page,Model model) {
		Pageable pageRequest= PageRequest.of(page,5);
		Page<Coche> coches= cocheService.findAll(pageRequest);
		
		PageRender<Coche> pageRender= new PageRender<>("/listarCoches",coches);
		
		model.addAttribute("titulo", "Listado de Coches por página");
		model.addAttribute("coches", coches);
		model.addAttribute("page",pageRender);
		return "listarCoches";
	}

	@RequestMapping(value = "/formCoches")
	public String crear(Map<String, Object> model) {

		Coche coche = new Coche();
		model.put("coche", coche);
		model.put("titulo", "Formulario de Coches");
		return "formCoches";
	}

	@RequestMapping(value = "/formCoches/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Coche coche = null;

		if (id > 0) {
			coche = cocheService.findOne(id);
			if (coche == null) {
				flash.addFlashAttribute("error", "El ID del Coche no existe en la BBDD!");
				return "redirect:/listarCoches";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del Coche no puede ser cero!");
			return "redirect:/listarCoches";
		}
		model.put("coche", coche);
		model.put("titulo", "Editar Coche");
		return "formCoches";
	}

	@RequestMapping(value = "/formCoches", method = RequestMethod.POST)
	public String guardar(@Valid Coche Coche, SessionStatus status) {
		Coche.setCreateAt(new Date());
		cocheService.save(Coche);
		status.setComplete();
		return "redirect:listarCoches";
	}

	@RequestMapping(value = "/eliminarCoche/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			Coche coche=cocheService.findOne(id);			
			cocheService.delete(id);
			}
		return "redirect:/listarCoches";
	}
}
