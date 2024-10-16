package com.java.gestao_vendas.repository;

import java.sql.Connection;


public class ProdutoRepository {
    Connection connection;

    public ProdutoDAO(Connection conn) {
        this.connection = connection;
    }

}
