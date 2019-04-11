package br.com.galaxyware.dream.DAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.galaxyware.dream.model.Pacote;

public class PacoteDAO {
    public List<Pacote> lista() {
        List<Pacote> pacotes = new ArrayList<>(Arrays.asList(
                new Pacote("São Paulo", "sp", 2, new BigDecimal(243.99)),
                new Pacote("Belo Horizonte", "bh", 3, new BigDecimal(421.50)),
                new Pacote("Recife", "ba", 4, new BigDecimal(754.20)),
                new Pacote("Rio de Janeiro", "rj", 6, new BigDecimal(532.55)),
                new Pacote("Florianopolis", "fl", 5, new BigDecimal(899.99))));
        return pacotes;
    }

}
