package RSL.ex_27062024.gson.serlization.gen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class BookingDates {

        @SerializedName("checkin")
        @Expose
        private String checkin;
        @SerializedName("checkout")
        @Expose
        private String checkout;

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

    }


