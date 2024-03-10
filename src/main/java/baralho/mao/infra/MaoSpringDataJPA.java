package baralho.mao.infra;

import baralho.jogo.domain.Mao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaoSpringDataJPA extends JpaRepository<Mao,Long> {
}
