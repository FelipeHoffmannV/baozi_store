package com.keeper.baozistore.controllers;

import com.keeper.baozistore.model.Pedido;
import com.keeper.baozistore.repository.PedidoRepository;
import com.keeper.baozistore.repository.ClienteRepository;
import com.keeper.baozistore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String abrirPedidos(Model model) {

        model.addAttribute("pedido", new Pedido());


        model.addAttribute("pedidos", pedidoRepository.findAll());


        model.addAttribute("clientes", clienteRepository.findAll());


        model.addAttribute("produtos", produtoRepository.findAll());

        return "pedidos";
    }

    @PostMapping
    public String salvarPedido(@ModelAttribute("pedido") Pedido pedido) {
        pedidoRepository.save(pedido);
        return "redirect:/pedidos";
    }

    @PostMapping("/excluir/{id}")
    public String excluirPedido(@PathVariable("id") Long id) {
        pedidoRepository.deleteById(id);
        return "redirect:/pedidos";
    }
}
