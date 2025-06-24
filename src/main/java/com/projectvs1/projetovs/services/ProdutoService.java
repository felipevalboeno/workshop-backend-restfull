package com.projectvs1.projetovs.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectvs1.projetovs.model.Produto;
import com.projectvs1.projetovs.model.exception.ResourceNotFoundException;
import com.projectvs1.projetovs.repository.ProdutoRepository;
import com.projectvs1.projetovs.shared.ProdutoDTO;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método para retornar uma lista de produtos
     * 
     * @return Lista de produtos
     */
    public List<ProdutoDTO> obterTodos() {

        // retorna uma lista de produtos model
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream()
                .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Métodoque retorna o produto encontrado pelo seu id
     * 
     * @param id do produto que será localizado
     * @return retona um produto caso tenha encontrado
     */
    public Optional<ProdutoDTO> obterPorId(Integer id) {
        // Obtendo optional de produto por id
        Optional<Produto> produto = produtoRepository.findById(id);
        // Se não encontrar lança uma exception
        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Produto com id: " + id + "não encontrado");
        }
        // Convertendo o Optional de produto em produtoDto
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        // Criando e retornando um Optional de produtoDto
        return Optional.of(dto);
    }

    /**
     * Método para adicionar produto na lista
     * 
     * @param produto a ser adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto) {

        // Removendo o id para garantir o cadastro
        produtoDto.setId(null);

        // Criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

        // Converter o produtoDTO em um produto model.
        Produto produto = mapper.map(produtoDto, Produto.class);

        // salvar o produto no banco
        produto = produtoRepository.save(produto);
        produtoDto.setId(produto.getId());

        // retornar o produtoDto atualizado
        return produtoDto;
    }

    /**
     * Método para deletar um produto por id
     * 
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id) {
        // Verificar se o produto existe
        Optional<Produto> produto = produtoRepository.findById(id);
        // Se não existir o id lança uma exception
        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível encontrar o produto com id: " + id);

        }

        produtoRepository.deleteById(id);
    }

    /**
     * Método para atualizar o produto na lista
     * 
     * @param produto que será atualizado
     * @param id      do produto
     * @return Retorna o produto após atualizar a lista;
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto) {

        // Passar o id para o produtoDto
        produtoDto.setId(id);

        // Criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        // Converter o produtoDTO em um produto
        Produto produto = mapper.map(produtoDto, Produto.class);
        // Atualizar o produto no banco.
        produtoRepository.save(produto);
       
        // Retornar o produtoDto atualizado
        return produtoDto;
    }

}
