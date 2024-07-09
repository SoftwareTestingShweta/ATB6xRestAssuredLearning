package RSL.ex_27062024.jackson.deser;

import RSL.ex_27062024.gson.serlization.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class Lab296 {

    @Test
    public void deSer() throws JsonProcessingException {

        String jsonString = "{\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        ObjectMapper om = new ObjectMapper();
        Booking booking = om.readValue(jsonString, Booking.class);
        System.out.println(booking);
        System.out.println(booking.getFirstname());
    }

}
