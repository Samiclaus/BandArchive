package at.irsigler.bandarchive.musician;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicianRepository extends JpaRepository<Musician, Long> {

    List<Musician> findByLastName(String lastName);
}
