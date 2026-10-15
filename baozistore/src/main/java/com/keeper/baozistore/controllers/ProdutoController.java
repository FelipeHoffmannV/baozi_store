package com.keeper.baozistore.controllers;

import com.keeper.baozistore.model.Produto;
import com.keeper.baozistore.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String abrirProdutos(Model model) {

        model.addAttribute("produto", new Produto());

        model.addAttribute("produtos", produtoRepository.findAll());
        return "produtos";
    }

    @PostMapping
    public String salvarProduto(@ModelAttribute("produto") Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    @PostMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/produtos";
    }
}
