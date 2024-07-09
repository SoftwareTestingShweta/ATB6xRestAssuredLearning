package RSL.ex_27062024.jackson.ser;

import RSL.ex_27062024.gson.serlization.Booking;
import RSL.ex_27062024.gson.serlization.BookingDates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class LabTry {

    @Test
    public void SeraJackson() throws JsonProcessingException, JsonProcessingException {


        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(-1);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(jsonString);

        System.out.println(booking);


    }
}
