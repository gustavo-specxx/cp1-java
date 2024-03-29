package br.com.fiap;

import javax.persistence.EntityManager;

public class ProdutoDAO {

    private EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Produto buscarPorId(int id) {
        return entityManager.find(Produto.class, id);
    }
}
