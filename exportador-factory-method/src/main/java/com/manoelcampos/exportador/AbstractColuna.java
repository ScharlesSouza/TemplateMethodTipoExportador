/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manoelcampos.exportador;

import java.util.function.Function;


public abstract class AbstractColuna implements Coluna {

    private final Function<Produto, Object> obtemValorColuna;
    private String titulo;

    public AbstractColuna(Function<Produto, Object> obtemValorColuna, String titulo) {
        this.obtemValorColuna = obtemValorColuna;
        this.titulo = titulo;
    }
    
    
    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    @Override
    public String exportarCabecalho() {
        return abrir() + titulo + fechar();
    }

    @Override
    public String exportarDado(Produto produto) {
        Object retorno = obtemValorColuna.apply(produto);  //Coluna.getDescrição()
        return abrir() + retorno.toString() + fechar();
    }
    
}
