package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

class AddressDtoTest {

    ObjectMapper underTest = new ObjectMapper();

    @Test
    void testSerialization() throws JsonProcessingException, JSONException {

        //given
        AddressDto address = new AddressDto();
        address.setAddressLine1("123");
        address.setAddressLine2("Example Road");
        address.setCity("Example City");
        address.setCouncil("Example Council");
        address.setPostcode("123 4567");

        //when
        String actual = underTest.writeValueAsString(address);

        //then
        JSONAssert.assertEquals("{\"addressLine1\":\"123\",\"addressLine2\":\"Example Road\",\"city\":\"Example City\"," +
                "\"council\":\"Example Council\",\"postcode\":\"123 4567\"}", actual, JSONCompareMode.LENIENT);

    }

    @Test
    void testDeserialization() throws JsonProcessingException {

        //given
        AddressDto address = new AddressDto();
        address.setAddressLine1("123");
        address.setAddressLine2("Example Road");
        address.setCity("Example City");
        address.setCouncil("Example Council");
        address.setPostcode("123 4567");

        //when
        AddressDto actual = underTest.readValue(
                "{\"addressLine1\":\"123\",\"addressLine2\":\"Example Road\",\"city\":\"Example City\"," +
                        "\"council\":\"Example Council\",\"postcode\":\"123 4567\"}", AddressDto.class);

        //then
        Assertions.assertEquals(address.getAddressLine1(), actual.getAddressLine1());
        Assertions.assertEquals(address.getAddressLine2(), actual.getAddressLine2());
        Assertions.assertEquals(address.getCity(), actual.getCity());
        Assertions.assertEquals(address.getCouncil(), actual.getCouncil());
        Assertions.assertEquals(address.getPostcode(), actual.getPostcode());

    }

}