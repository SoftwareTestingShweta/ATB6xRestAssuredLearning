package RSL.ex_25062024;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class Lab286 {

    @Test
    public void testDemo1() {

        // Randomd User or Password

        Faker faker = new Faker();
        String username = faker.name().username();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String password = faker.internet().password();

        System.out.println(username);
        System.out.println(phoneNumber);
        System.out.println(password);

    }
}
