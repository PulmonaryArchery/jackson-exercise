package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonDTOTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testSerialization() throws JsonProcessingException {

        PersonDTO person = new PersonDTO();
        person.setName("John Doe");
        person.setAge(30);
        person.setEmail("john.doe@test.com");

        String result = objectMapper.writeValueAsString(person);

        JSONAssert.assertEquals("{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@test.com\"}",
                result);

        

    }

    @Test
    void testDeserialization() throws JsonProcessingException {

        PersonDTO person = new PersonDTO();
        person.setName("John Doe");
        person.setAge(30);
        person.setEmail("john.doe@test.com");

        PersonDTO result = objectMapper.readValue(
                "{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@test.com\"}", PersonDTO.class);

        Assertions.assertEquals(person.getClass(), result.getClass());

    }

}