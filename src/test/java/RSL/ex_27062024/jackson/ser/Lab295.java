package RSL.ex_27062024.jackson.ser;

import RSL.ex_27062024.gson.serlization.gen.BookingDates;
import RSL.ex_27062024.gson.serlization.gen.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class Lab295 {

    @Test
    public void serJackson() throws JsonProcessingException{

        Booking booking =new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(100);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking.toString());

        ObjectMapper om = new ObjectMapper();
        String jsonString = om.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        System.out.println(jsonString);

    }

}
