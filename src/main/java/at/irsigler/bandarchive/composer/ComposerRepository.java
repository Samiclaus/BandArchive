package at.irsigler.bandarchive.composer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComposerRepository extends CrudRepository<Composer, Long> {

    List<Composer> findByLastName(String lastName);
}
