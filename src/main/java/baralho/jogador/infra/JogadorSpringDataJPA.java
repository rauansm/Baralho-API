package baralho.jogador.infra;

import baralho.jogador.domain.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorSpringDataJPA extends JpaRepository<Jogador, Long> {
}
