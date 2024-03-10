package baralho.jogo.infra;

import baralho.jogo.application.repository.JogoRepository;
import baralho.jogo.domain.Jogo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class JogoInfraRepository implements JogoRepository {
    private final JogoSpringDataJPA jogoSpringDataJPA;
    @Override
    public Jogo salva(Jogo jogo) {
        log.info("[inicia] JogoInfraRepository - salva");
        jogoSpringDataJPA.save(jogo);
        log.info("[finaliza] JogoInfraRepository - salva");
        return jogo;
    }
}
