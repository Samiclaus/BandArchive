package at.irsigler.bandarchive.concert;

import at.irsigler.bandarchive.musician.Musician;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Concert")
@Getter
public class Concert {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    private Band band;

    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConcertPiece> program;

    @ManyToMany
    @JoinTable(name = "concert_conductor")
    private Musician conductor;

}
