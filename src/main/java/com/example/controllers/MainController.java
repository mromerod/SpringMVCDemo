package com.example.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Telefono;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;
import com.example.services.TelefonoService;

@Controller
@RequestMapping("/") //para hacer peticiones, las url que va a recibir, manda todo lo que termine en /
public class MainController {
    private static final Logger LOG = Logger.getLogger("MainController"); //para mensajes si todo peta

@Autowired
private EstudianteService estudianteService;
@Autowired
private FacultadService facultadService;
@Autowired
private TelefonoService telefonoService;


/**
 * Responde a algo en concreto y lo delega en un metodo quee tiene en cuenta el verbo utilizando del protocolo http
 * utilizado para realizar la petición
 * verbos: get,put,post,opcion,delete
 * 
 */

    @GetMapping("/listar") //metodo get a traves de la pagina
    public ModelAndView listar() {
         // devuelve un listado de estudiantes


        List<Estudiante> estudiantes = estudianteService.findAll();


        ModelAndView mav = new ModelAndView("views/listarEstudiantes");
            mav.addObject("estudiantes", estudiantes);
        return mav;
 
 
 
   }




   /**
    * Muestra el formulario de alta de estudiante

    */






@GetMapping("/frm")
    public String formularioAltaEstudiante(Model model){

        List<Facultad> facultades = facultadService.findAll();
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("facultades", facultades);

        return "views/formularioAltaEstudiante";

    }

@PostMapping("/altaEstudiante")

public String altaEstudiante(@ModelAttribute Estudiante estudiante,
 @RequestParam(name = "numerosTelefonos") String telefonosrecibidos){

    LOG.info("telefonos recibidos:" + telefonosrecibidos);

    List<String> listadoNumerosTelefonos = null; //la declara fuera para poder usarla


if(telefonosrecibidos != null) {
    String[] arrayTelefonos = telefonosrecibidos.split(";"); // covierte los telefonos en un 
    //array y los separa por ;
    listadoNumerosTelefonos = Arrays.asList(arrayTelefonos);
}
    estudianteService.save(estudiante);
    
    if(listadoNumerosTelefonos != null) {

        listadoNumerosTelefonos.stream().forEach(n -> {

        Telefono telefonoObjet = Telefono
                .builder()
                .numero(n)
                .estudiante(estudiante)
                .build();

                telefonoService.save(telefonoObjet);
    
    
    }
        
        
        );  

    }

    return "redirect:/listar";
}


}


