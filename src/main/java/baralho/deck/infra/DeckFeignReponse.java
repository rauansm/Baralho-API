package baralho.deck.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DeckFeignReponse {
    @JsonProperty("sucess")
    private boolean success;
    @JsonProperty("deck_id")
    private String deck_id;
    @JsonProperty("remaining")
    private Integer remaining;
    @JsonProperty("shuffled")
    private boolean shuffled;

}
