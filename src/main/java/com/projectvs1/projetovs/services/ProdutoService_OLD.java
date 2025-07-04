package com.projectvs1.projetovs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectvs1.projetovs.model.Produto;
import com.projectvs1.projetovs.repository.ProdutoRepository_old;

@Service
public class ProdutoService_OLD {

    @Autowired
    private ProdutoRepository_old produtoRepository;


    /**
     * Método para retornar uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){

        return produtoRepository.obterTodos();
    }

      /**
     * Métodoque retorna o produto encontrado pelo seu id
     * @param id do produto que será localizado
     * @return retona um produto caso tenha encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

      /**
     * Método para adicionar produto na lista
     * @param produto a ser adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionar (Produto produto){

        return produtoRepository.adicionar(produto);
    }
 
    /**
     * Método para deletar um produto por id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }

        /**
     * Método para atualizar o produto na lista
     * @param produto que será atualizado
     * @param id do produto
     * @return Retorna o produto após atualizar a lista;
     */
    public Produto atualizar(Integer id, Produto produto){
       
        produto.setId(id);

        return produtoRepository.atualizar(produto);
    }


    
}
