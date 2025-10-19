import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.example.Person;
import org.junit.jupiter.api.Test;

public class PersonEqualsTest {
    @Test
    void equalsAndHashCodeContract() {
        EqualsVerifier.forClass(Person.class)
                .usingGetClass()
                .withNonnullFields("firstName", "lastName")
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }

}

