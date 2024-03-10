package baralho.carta.application.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@ToString
@Getter
public class CartaResponse {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("deck_id")
    private String deckId;

    @JsonProperty("cards")
    private List<Card> cards;
    @ToString
    @Getter
    public static class Card {
        private String code;
        private String image;
        private String value;
        private String suit;
    }
}
