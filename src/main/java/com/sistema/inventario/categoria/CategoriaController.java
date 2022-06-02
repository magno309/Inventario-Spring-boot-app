package com.sistema.inventario.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/categorias")
    public String listarCategorias(Model modelo) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("listaCategorias", listaCategorias);
        return "categorias";
    }

    @GetMapping("categorias/nuevo")
    public String formNuevaCategoria(Model modelo){
        modelo.addAttribute("categoria", new Categoria());
        return "agregarCategoria";
    }

    @PostMapping("categorias/guardar")
    public String guardarCategoria(Categoria nuevaCategoria){
        categoriaRepository.save(nuevaCategoria);
        return "redirect:/categorias";
    }
}
