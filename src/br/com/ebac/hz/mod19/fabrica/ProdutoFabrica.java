package br.com.ebac.hz.mod19.fabrica;


import br.com.ebac.hz.mod19.domain.Persistente;
import br.com.ebac.hz.mod19.domain.Produto;
import br.com.ebac.hz.mod19.domain.Cliente;
import br.com.ebac.hz.mod19.exception.DadosInvalidosException;



public class ProdutoFabrica implements FabricaPersistente {

    @Override
    public Persistente criarObjeto(String[] dados) throws DadosInvalidosException {
        try {
            Produto produto = new Produto();
            produto.setCodigo(Long.parseLong(dados[0].trim()));
            produto.setNome(dados[1]);
            return produto;
        } catch(IndexOutOfBoundsException e) {
            throw new DadosInvalidosException("Dados de produto estão inválidos");
        }
    }
}
