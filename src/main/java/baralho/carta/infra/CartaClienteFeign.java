package baralho.carta.infra;

import baralho.carta.application.service.CartaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cartaClienteFeign", url = "https://deckofcardsapi.com/api")
public interface CartaClienteFeign {

    @GetMapping("/deck/{idDeck}/draw/")
    CartaResponse buscaCartas(@PathVariable("idDeck") String idDeck,
                              @RequestParam("count") Integer quantidadeCartas);
}
