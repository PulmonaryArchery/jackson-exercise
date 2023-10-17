package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;


class PersonDTOTest {

    ObjectMapper underTest = new ObjectMapper();

    @Test
    void testSerialization() throws JsonProcessingException, JSONException {

        //given
        PersonDTO person = new PersonDTO();
        person.setName("John Doe");
        person.setAge(30);
        person.setEmail("john.doe@test.com");

        //when
        String actual = underTest.writeValueAsString(person);

        //then
        JSONAssert.assertEquals("{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@test.com\"}",
                actual, JSONCompareMode.LENIENT);

    }

    @Test
    void testDeserialization() throws JsonProcessingException {

        //given
        PersonDTO person = new PersonDTO();
        person.setName("John Doe");
        person.setAge(30);
        person.setEmail("john.doe@test.com");

        //when
        PersonDTO actual = underTest.readValue(
                "{\"name\":\"John Doe\",\"age\":30,\"email\":\"john.doe@test.com\"}", PersonDTO.class);

        //then
        Assertions.assertEquals(actual.getName(), person.getName());
        Assertions.assertEquals(actual.getAge(), person.getAge());
        Assertions.assertEquals(actual.getEmail(), person.getEmail());

    }

}