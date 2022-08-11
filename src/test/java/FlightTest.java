import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class FlightTest {

    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;

        @BeforeEach
        void setUp() {
            economyFlight = new Flight("1", "Economy");
        }

        @Test
        public void testEconomyFlightRegularPassenger() {
            Passenger mike = new Passenger("Mike", false);

            assertThat(economyFlight.getId(), is(equalTo("1")));
            assertThat(economyFlight.addPassenger(mike), is(true));
            assertThat(economyFlight.getPassengers(), hasSize(1));
            assertThat(economyFlight.getPassengers().get(0).getName(), is(equalTo("Mike")));
            assertThat(economyFlight.removePassenger(mike), is(true));
            assertThat(economyFlight.getPassengers(), hasSize(0));
        }

        @Test
        public void testEconomyFlightVipPassenger() {
            Passenger james = new Passenger("James", true);

            assertThat(economyFlight.getId(), is(equalTo("1")));
            assertThat(economyFlight.addPassenger(james), is(true));
            assertThat(economyFlight.getPassengers(), hasSize(1));
            assertThat(economyFlight.getPassengers().get(0).getName(), is(equalTo("James")));
            assertThat(economyFlight.removePassenger(james), is(false));
            assertThat(economyFlight.getPassengers(), hasSize(1));
        }
    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;

        @BeforeEach
        void setUp() {
            businessFlight = new Flight("2", "Business");
        }

        @Test
        public void testBusinessFlightRegularPassenger() {
            Passenger mike = new Passenger("Mike", false);

            assertThat(businessFlight.getId(), is(equalTo("2")));
            assertThat(businessFlight.addPassenger(mike), is(false));
            assertThat(businessFlight.getPassengers(), hasSize(0));
            assertThat(businessFlight.removePassenger(mike), is(false));
            assertThat(businessFlight.getPassengers(), hasSize(0));
        }

        @Test
        public void testBusinessFlightVipPassenger() {
            Passenger james = new Passenger("James", true);

            assertThat(businessFlight.getId(), is(equalTo("2")));
            assertThat(businessFlight.addPassenger(james), is(true));
            assertThat(businessFlight.getPassengers(), hasSize(1));
            assertThat(businessFlight.getPassengers().get(0).getName(), is(equalTo("James")));
            assertThat(businessFlight.removePassenger(james), is(false));
            assertThat(businessFlight.getPassengers(), hasSize(1));
        }

    }
}
