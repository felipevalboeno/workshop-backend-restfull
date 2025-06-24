package com.projectvs1.projetovs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectvs1.projetovs.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    

}
