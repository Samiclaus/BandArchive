package at.irsigler.bandarchive.composer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Composer")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Composer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    public Composer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Composer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
