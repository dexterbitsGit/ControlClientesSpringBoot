package com.dexterbits.web;

import com.dexterbits.domain.Persona;
import com.dexterbits.service.*;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author guillermo
 */
@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user ) {
        
    var personas = personaService.listarPersonas();
        
//        log.info("ejecutando el controlador Spring MVC");
        log.info("Usuario que hizo Login:" + user);
        model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        
        return "modificar";
        
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        
        if(errores.hasErrors()){
            return "modificar";
        }
        
        // Nota: En automatico recupera del objeto persona que esta en memoria en el formulario y lo inyecta para guardarlo    
        personaService.guardar(persona);
        //Redireccion a la pagina de inicio
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        //Nota: en automatico spring busca el objeto persona por medio del id y hace set (Actualiza) al objeto de manera automatica
        // es por ello que solo debemos recuperar el objeto con encontrarPersona para mostrar los cambios         
        persona = personaService.encontrarPersona(persona);
        
        model.addAttribute("persona", persona);
        
        // Redirigir a la vista modificar
        return "modificar";
        
    }
    
//    @GetMapping("/eliminar/{idPersona}")
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        
        return "redirect:/";
    }
    
    
}
