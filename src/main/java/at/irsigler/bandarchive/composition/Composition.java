package at.irsigler.bandarchive.composition;

import at.irsigler.bandarchive.composer.Composer;
import jakarta.persistence.*;
import lombok.Getter;

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
    private Composer composer;

    @ManyToOne
    @JoinColumn(name = "arranger_id")
    private Composer arranger;


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
