import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightTest {

    @DisplayName("Given there is an economy flight")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger mike;
        private Passenger james;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            james = new Passenger("James", true);
        }

        @Nested
        @DisplayName("When we have a regular passenger")
        class RegularPassenger {

            @Test
            @DisplayName("Then you can add and remove him from an economy flight")
            public void testEconomyFlightRegularPassenger() {
                assertAll(
                        "Verify all conditions for a regular passenger and an economy flight",
                        () -> assertThat(economyFlight.getId(), is(equalTo("1"))),
                        () -> assertThat(economyFlight.addPassenger(mike), is(true)),
                        () -> assertThat(economyFlight.getPassengers(), hasSize(1)),
                        () -> assertTrue(economyFlight.getPassengers().contains(mike)),
                        () -> assertThat(economyFlight.removePassenger(mike), is(true)),
                        () -> assertThat(economyFlight.getPassengers(), hasSize(0))
                );
            }

            @DisplayName("Then you cannot add him to an economy flight more than once")
            @RepeatedTest(5)
            public void testEconomyFlightRegularPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {

                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(mike);
                }

                assertAll(
                        "Verify a regular passenger can be added to an economy flight only once",
                        () -> assertThat(economyFlight.getPassengers(), hasSize(1)),
                        () -> assertTrue(economyFlight.getPassengers().contains(mike))
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then you can add him but cannot remove him from an economy flight")
            public void testEconomyFlightVipPassenger() {
                assertAll(
                        "Verify all conditions for a VIP passenger and an economy flight",
                        () -> assertThat(economyFlight.getId(), is(equalTo("1"))),
                        () -> assertThat(economyFlight.addPassenger(james), is(true)),
                        () -> assertThat(economyFlight.getPassengers(), hasSize(1)),
                        () -> assertThat(economyFlight.getPassengers().contains(james), is(true)),
                        () -> assertThat(economyFlight.removePassenger(james), is(false)),
                        () -> assertThat(economyFlight.getPassengers(), hasSize(1))
                );
            }
        }
    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger mike;
        private Passenger james;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            mike = new Passenger("Mike", false);
            james = new Passenger("James", true);
        }

        @Nested
        @DisplayName("When we have a regular passenger")
        class RegularPassenger {

            @DisplayName("Then you can not add or remove him from a business flight")
            @Test
            public void testBusinessFlightRegularPassenger() {

                assertAll(
                        "Verify all conditions for a regular passenger and a business flight",
                        () -> assertThat(businessFlight.getId(), is(equalTo("2"))),
                        () -> assertThat(businessFlight.addPassenger(mike), is(false)),
                        () -> assertThat(businessFlight.getPassengers(), hasSize(0)),
                        () -> assertThat(businessFlight.removePassenger(mike), is(false)),
                        () -> assertThat(businessFlight.getPassengers(), hasSize(0))
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @DisplayName("Then you can add him but cannot remove him from a business flight")
            @Test
            public void testBusinessFlightVipPassenger() {

                assertAll(
                        "Verify all conditions for a VIP passenger and a business flight",
                        () -> assertThat(businessFlight.getId(), is(equalTo("2"))),
                        () -> assertThat(businessFlight.addPassenger(james), is(true)),
                        () -> assertThat(businessFlight.getPassengers(), hasSize(1)),
                        () -> assertThat(businessFlight.getPassengers().contains(james), is(true)),
                        () ->  assertThat(businessFlight.removePassenger(james), is(false)),
                        () ->  assertThat(businessFlight.getPassengers(), hasSize(1))
                );
            }
        }





    }

    @DisplayName("Given there is a premium flight")
    @Nested
    class PremiumFlightTest {
        private Flight premiumFlight;
        private Passenger mike;
        private Passenger james;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("3");
            mike = new Passenger("Mike", false);
            james = new Passenger("James", true);
        }

        @Nested
        @DisplayName("When we have a regular passenger")
        class RegularPassenger {

            @Test
            @DisplayName("Then you cannot add or remove him from a premium flight")

            public void testPremiumFlightRegularPassenger() {
                assertAll(
                        "Verify all conditions for a regular passenger and a premium flight",
                        () -> assertThat(premiumFlight.getId(), is(equalTo("3"))),
                        () -> assertThat(premiumFlight.addPassenger(mike), is(false)),
                        () -> assertThat(premiumFlight.getPassengers(), hasSize(0)),
                        () ->  assertThat(premiumFlight.removePassenger(mike), is(false)),
                        () ->  assertThat(premiumFlight.getPassengers(), hasSize(0))
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then you cannot add and remove him from a premium flight")

            public void testPremiumFlightVipPassenger() {
                assertAll(
                        "Verify all conditions for a VIP passenger and a premium flight",
                        () -> assertThat(premiumFlight.getId(), is(equalTo("3"))),
                        () -> assertThat(premiumFlight.addPassenger(james), is(true)),
                        () -> assertThat(premiumFlight.getPassengers(), hasSize(1)),
                        () ->  assertThat(premiumFlight.removePassenger(james), is(true)),
                        () ->  assertThat(premiumFlight.getPassengers(), hasSize(0))
                        );
            }
        }


    }
}
