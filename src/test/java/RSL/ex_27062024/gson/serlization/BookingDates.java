package RSL.ex_27062024.gson.serlization;

public class BookingDates {

    String checkin;
    String checkout;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDates{" +
                "checkin='" + checkin + '\'' +
                ",checkout='" + checkout + '\'' +
                '}';
    }
}
