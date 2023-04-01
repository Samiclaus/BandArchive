package at.irsigler.bandarchive.musician;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MusicianController {

    private final MusicianRepository musicianRepository;

    @GetMapping("/musicians")
    public List<Musician> getAll() {
        return musicianRepository.findAll();
    }

    @GetMapping("/musicians/{id}")
    public Musician getOne(@PathVariable Long id) {
        return musicianRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    @PostMapping("/musicians")
    public Musician create(@RequestBody Musician musician) {
        return musicianRepository.save(musician);
    }

    @DeleteMapping("/musicians/{id}")
    public void delete(@PathVariable Long id) {
        musicianRepository.deleteById(id);
    }


}
