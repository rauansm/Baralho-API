package baralho.mao.application.repository;

import baralho.jogo.domain.Mao;

import java.util.List;

public interface MaoRepository {
    void salva(List<Mao> maos);
}
