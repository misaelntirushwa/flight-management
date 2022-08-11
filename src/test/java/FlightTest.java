import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

            assertEquals("1", economyFlight.getId());
            assertEquals(true, economyFlight.addPassenger(mike));
            assertEquals(1, economyFlight.getPassengers().size());
            assertEquals("Mike", economyFlight.getPassengers().get(0).getName());
            assertEquals(true, economyFlight.removePassenger(mike));
            assertEquals(0, economyFlight.getPassengers().size());
        }

        @Test
        public void testEconomyFlightVipPassenger() {
            Passenger james = new Passenger("James", true);

            assertEquals("1", economyFlight.getId());
            assertEquals(true, economyFlight.addPassenger(james));
            assertEquals(1, economyFlight.getPassengers().size());
            assertEquals("James", economyFlight.getPassengers().get(0).getName());
            assertEquals(false, economyFlight.removePassenger(james));
            assertEquals(1, economyFlight.getPassengers().size());
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

            assertEquals("2", businessFlight.getId());
            assertEquals(false, businessFlight.addPassenger(mike));
            assertEquals(0, businessFlight.getPassengers().size());

            assertEquals(false, businessFlight.removePassenger(mike));
            assertEquals(0, businessFlight.getPassengers().size());
        }

        @Test
        public void testBusinessFlightVipPassenger() {
            Passenger james = new Passenger("James", true);

            assertEquals("2", businessFlight.getId());
            assertEquals(true, businessFlight.addPassenger(james));
            assertEquals(1, businessFlight.getPassengers().size());
            assertEquals("James", businessFlight.getPassengers().get(0).getName());
            assertEquals(false, businessFlight.removePassenger(james));
            assertEquals(1, businessFlight.getPassengers().size());
        }

    }
}
