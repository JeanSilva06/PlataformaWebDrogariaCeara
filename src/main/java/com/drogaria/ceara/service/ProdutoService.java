package com.drogaria.ceara.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.drogaria.ceara.dto.ProdutoRequestDTO;
import com.drogaria.ceara.dto.ProdutoResponseDTO;
import com.drogaria.ceara.exception.ProdutoNaoEncontradoException;
import com.drogaria.ceara.model.Produto;
import com.drogaria.ceara.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO requestDTO) {
        Produto produto = new Produto(
                requestDTO.getNome(),
                requestDTO.getCategoria(),
                requestDTO.getQuantidade(),
                requestDTO.getPreco(),
                requestDTO.getValidade());

        Produto novoProduto = produtoRepository.save(produto);
        return ProdutoResponseDTO.fromEntity(novoProduto);
    }

    public List<ProdutoResponseDTO> listarProdutos() {
        return produtoRepository.findAll().stream()
                .map(ProdutoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado!"));
        return ProdutoResponseDTO.fromEntity(produto);
    }

    @Transactional
    public ProdutoResponseDTO atualizarProduto(Long id, ProdutoRequestDTO requestDTO) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(requestDTO.getNome());
                    produto.setCategoria(requestDTO.getCategoria());
                    produto.setQuantidade(requestDTO.getQuantidade());
                    produto.setPreco(requestDTO.getPreco());
                    produto.setValidade(requestDTO.getValidade());

                    return ProdutoResponseDTO.fromEntity(produtoRepository.save(produto));
                })
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado!"));
    }

    @Transactional
    public void excluirProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado!"));
        produtoRepository.delete(produto);
    }
}
