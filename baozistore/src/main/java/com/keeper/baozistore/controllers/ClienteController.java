package com.keeper.baozistore.controllers;

import com.keeper.baozistore.model.Cliente;
import com.keeper.baozistore.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping
    public String abrirClientes(Model model) {

        model.addAttribute("cliente", new Cliente());


        model.addAttribute("clientes", clienteRepository.findAll());

        return "clientes";
    }


    @PostMapping
    public String salvarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }


    @PostMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable("id") Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }

}

