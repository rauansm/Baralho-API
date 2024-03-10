package baralho.carta.application.service;

import baralho.carta.infra.CartaClienteFeign;
import baralho.handler.APIException;
import baralho.jogador.domain.Carta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Log4j2
public class CartaApplicaitonService implements CartaService {
    private final CartaClienteFeign cartaClienteFeign;
    @Override
    public List<Carta> buscaCartas(String idDeck, Integer quantidadeCartas) {
        log.debug("[inicia] CartaApplicaitonService - buscaCartas");
        CartaResponse cartasFeign = cartaClienteFeign.buscaCartas(idDeck,quantidadeCartas);
        List<Carta> cartas = Carta.converte(cartasFeign.getCards());
        validaQuantidadeCartas(cartas,quantidadeCartas);
        log.debug("[finaliza] CartaApplicaitonService - buscaCartas");
        return cartas;
    }

    private void validaQuantidadeCartas(List<Carta> cartas, Integer quantidadeCartas) {
        if (cartas.size() != quantidadeCartas) {
            throw APIException.negocio("Deck não possui cartas sucifientes.");
        }
    }
}
