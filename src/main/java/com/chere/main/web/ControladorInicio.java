package com.chere.main.web;

import com.chere.domain.Precios;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    Precios precioService = new Precios();
    int valorTotal =  0;
    
    @GetMapping("/")
    public String inicio(Model model) {

       String valorTotal = "$" + this.valorTotal;
        model.addAttribute("precioIndividual", precioService.getPrecioIndividual());
        model.addAttribute("precioMediaDocena", precioService.getPrecioMediaDocena());
        model.addAttribute("precioDocena", precioService.getPrecioDocena());
        model.addAttribute ("valorTotal", valorTotal);
       

        return "index";

    }

    @PostMapping("/calcular")
    public String calcular(Model model, int cantidad) {

        this.valorTotal = precioService.algoritmo(cantidad);

        

        return "redirect:/";
    }

    @PostMapping("/cambiarPrecio")
    public String cambiarPrecios(Model model, Precios precio) {

       precioService.cambiarPrecios(precio);
       

        return "redirect:/";
    }
}
