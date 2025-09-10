package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        Person person = new Person("Artem", "Balabas", 19);

        String json = ow.writeValueAsString(person);
        System.out.println("JSON: " + json);

        Person restored = mapper.readValue(json, Person.class);
        System.out.println("Restored: " + restored);

        System.out.println("Equals? " + person.equals(restored));
    }
}
