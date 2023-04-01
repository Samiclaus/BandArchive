package at.irsigler.bandarchive.concert;

import at.irsigler.bandarchive.composition.Composition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class ConcertPiece {

    @EmbeddedId
    private ConcertPieceId id;

    @ManyToOne
    @MapsId("compositionId")
    private Composition composition;

    @ManyToOne
    @MapsId("concertId")
    private Concert concert;

    private Integer position;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class ConcertPieceId implements Serializable {

        @Column(name = "composition_id")
        private Long compositionId;

        @Column(name = "concert_id")
        private Long concertId;
    }
}
