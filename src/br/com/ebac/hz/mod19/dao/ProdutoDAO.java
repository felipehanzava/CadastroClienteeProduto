package br.com.ebac.hz.mod19.dao;

import br.com.ebac.hz.mod19.cadastro.SingletonMap;
import br.com.ebac.hz.mod19.dao.generic.GenericDAO;
import br.com.ebac.hz.mod19.domain.Produto;


import java.util.HashMap;
import java.util.Map;


public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {

    public ProdutoDAO() {
        super();
        Map<Long, Produto> mapaInterno =
                (Map<Long, Produto>) SingletonMap.getInstance().getMap().get(getTipoClasse());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno);
        }
    }


    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setCodigo(entity.getCodigo());
    }
}
