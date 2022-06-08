package com.sistema.inventario.marca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.categoria.CategoriaRepository;

@Controller
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/marcas")
    public String listarProductos(Model modelo) {
        List<Marca> listaMarcas = marcaRepository.findAll();
        modelo.addAttribute("listaMarcas", listaMarcas);
        return "marcas";
    }

    @GetMapping("/marcas/nuevo")
    public String formNuevaMarca(Model modelo) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("listaCategorias", listaCategorias);
        modelo.addAttribute("marca", new Marca());
        return "frmMarca";
    }

    @PostMapping("/marcas/guardar")
    public String guardarMarca(Marca marca) {
        marcaRepository.save(marca);
        return "redirect:/marcas";
    }

    @GetMapping("marcas/editar/{id}")
    public String editarMarca(@PathVariable("id") Integer id, Model modelo){
        Marca marca = marcaRepository.findById(id).get();
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("marca", marca);
        modelo.addAttribute("listaCategorias", listaCategorias);
        return "frmMarca";
    }

    @GetMapping("marcas/eliminar/{id}")
    public String eliminarMarca(@PathVariable("id") Integer id){
        marcaRepository.deleteById(id);
        return "redirect:/marcas";
    }
}
