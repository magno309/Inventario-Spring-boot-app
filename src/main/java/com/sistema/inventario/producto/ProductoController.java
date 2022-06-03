package com.sistema.inventario.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.categoria.CategoriaRepository;

@Controller
public class ProductoController {
    
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/productos")
    public String listarProductos(Model modelo) {
        List<Producto> listaProductos = productoRepository.findAll();
        modelo.addAttribute("listaProductos", listaProductos);
        return "productos";
    }

    @GetMapping("productos/nuevo")
    public String formNuevaProductos(Model modelo){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        modelo.addAttribute("listaCategorias", listaCategorias);
        modelo.addAttribute("producto", new Producto());
        return "agregarProducto";
    }

    @PostMapping("productos/guardar")
    public String guardarProducto(Producto nuevoProducto){
        productoRepository.save(nuevoProducto);
        return "redirect:/productos";
    }

}
