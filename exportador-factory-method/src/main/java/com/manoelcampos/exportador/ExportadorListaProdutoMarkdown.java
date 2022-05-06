package com.manoelcampos.exportador;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Exporta dados de uma lista de {@link Produto} para Markdown (arquivos md).
 *
 * <p>Observe que, como estamos usando o padrão Simple Factory para instanciar
 * objetos {@link ExportadorListaProduto}, as classes concretas como esta são definidas com visibilidade "package",
 * não podendo ser acessadas fora do pacote.
 * Assim, não teremos como instanciar diretamente tais classes.
 * A Simple Factory faz isso pra nós.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
class ExportadorListaProdutoMarkdown extends AbstractExportadorListaProduto {
    private static final String SEPARADOR_LN = "-";
    private static final String SEPARADOR_COL = "|";

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "\n";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        //List<String> valores = new ArrayList<>();
        //for (int i = 0; i < TITULOS_COLUNAS.size(); i++) {
        //    valores.add("-----");
        //}
        //return gerarColunasLinha(valores);
        
        StringBuilder sb = new StringBuilder();
        for(Coluna coluna : getColunas()){
            sb.append(coluna.abrir()+"----");
        }
        sb.append("\n");
        
        return sb.toString();
    }

    @Override
    public void addNewColuna(Function<Produto, Object> obtemValorColuna, String titulo) {
        addColuna(new Colunamarkdown(obtemValorColuna, titulo));
        
    }

}
