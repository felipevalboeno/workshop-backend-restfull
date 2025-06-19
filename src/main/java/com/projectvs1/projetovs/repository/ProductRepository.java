package com.projectvs1.projetovs.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.projectvs1.projetovs.model.Product;

@Repository
public class ProductRepository {

    private List<Product> produtos = new ArrayList<Product>();
    private Integer ultimoId = 0;

    /**
     * Método para retornar uma lista de produtos
     * @return lista de produtos
     */
    public List<Product> obterTodos(){
        return produtos;
    }

    /**
     * Métodoque retorna o produto encontrado pelo seu id
     * @param id do produto que será localizado
     * @return retona um produto caso tenha encontrado
     */
    public Optional<Product> obterPorId(Integer id){
        return produtos
        .stream()
        .filter(product -> product.getId() == id).findFirst();
    }


    /**
     * Método para adicionar produto na lista
     * @param produto a ser adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Product adicionar (Product produto){

        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }


    /**
     * Método para atualizar o produto na lista
     * @param produto que será atualizado
     * @return Retorna o produto após atualizar a lista;
     */
    public Product atualizar(Product produto){
       Optional<Product> produtoencontrado =  obterPorId(produto.getId());

       if(produtoencontrado.isEmpty()){
        throw new InputMismatchException("Produto não encontrado");

       }
       deletar(produto.getId());

       produtos.add(produto);

       return produto;

    }

    /**
     * Método para deletar um produto por id
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }
}
