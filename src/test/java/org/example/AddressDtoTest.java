package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressDtoTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testSerialization() throws JsonProcessingException {

        AddressDto address = new AddressDto();
        address.setAddressLine1("123");
        address.setAddressLine2("Example Road");
        address.setCity("Example City");
        address.setCouncil("Example Council");
        address.setPostcode("123 4567");

        String result = objectMapper.writeValueAsString(address);

        Assertions.assertEquals("{\"addressLine1\":\"123\",\"addressLine2\":\"Example Road\",\"city\":\"Example City\"," +
                "\"council\":\"Example Council\",\"postcode\":\"123 4567\"}", result);

    }

    @Test
    void testDeserialization() throws JsonProcessingException {

        AddressDto address = new AddressDto();
        address.setAddressLine1("123");
        address.setAddressLine2("Example Road");
        address.setCity("Example City");
        address.setCouncil("Example Council");
        address.setPostcode("123 4567");

        AddressDto result = objectMapper.readValue(
                "{\"addressLine1\":\"123\",\"addressLine2\":\"Example Road\",\"city\":\"Example City\"," +
                        "\"council\":\"Example Council\",\"postcode\":\"123 4567\"}", AddressDto.class);

        Assertions.assertEquals(address.getClass(), result.getClass());

    }

}