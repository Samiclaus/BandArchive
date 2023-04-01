package at.irsigler.bandarchive.composition;

import at.irsigler.bandarchive.concert.ConcertPiece;
import at.irsigler.bandarchive.musician.Musician;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "Composition")
@Getter
public class Composition {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String subtitle;

    @ManyToOne
    @JoinColumn(name = "composer_id")
    private Musician composer;

    @ManyToOne
    @JoinColumn(name = "arranger_id")
    private Musician arranger;

    @OneToMany(mappedBy = "composition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConcertPiece> programs;


    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", composer=" + ((composer != null) ? composer.toString() : "none") +
                ", arranger=" + ((arranger != null) ? arranger.toString() : "none") +
                '}';
    }
}
