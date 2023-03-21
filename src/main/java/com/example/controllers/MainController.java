package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Estudiante;
import com.example.services.EstudianteService;

@Controller
@RequestMapping("/") //para hacer peticiones, las url que va a recibir, manda todo lo que termine en /
public class MainController {

@Autowired
private EstudianteService estudianteService;


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


        model.addAttribute("estudiante", new Estudiante());
        return "views/formularioAltaEstudiante";
    }

@PostMapping("/altaEstudiante")
public String altaEstudiante(){


    return "redirect:/listar";
}


}


