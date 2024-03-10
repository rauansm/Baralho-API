package baralho.mao.infra;

import baralho.jogo.domain.Mao;
import baralho.mao.application.repository.MaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
@Log4j2
public class MaoInfraRepository implements MaoRepository {
    private final MaoSpringDataJPA maoSpringDataJPA;

    @Override
    public void salva(List<Mao> maos) {
        log.info("[inicia] MaoInfraRepository - salva");
        maoSpringDataJPA.saveAll(maos);
        log.info("[finaliza] MaoInfraRepository - salva");
    }
}
