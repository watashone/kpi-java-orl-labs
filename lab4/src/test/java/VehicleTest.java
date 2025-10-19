import com.luv2code.Passenger.Fireman;
import com.luv2code.Passenger.OrdinaryPassenger;
import com.luv2code.Passenger.Policeman;
import com.luv2code.Vehicle.Bus;
import com.luv2code.Vehicle.FireCar;
import org.junit.jupiter.api.*;

public class VehicleTest {
    @Test
    void testFireCarThrowsOnOverflow() throws Exception {
        FireCar fc = new FireCar(1);
        fc.boardPassenger(new Fireman()); // first successfully
        Assertions.assertThrows(Exception.class, () -> {
            fc.boardPassenger(new Fireman()); // second limit
        });
    }


    @Test
    void testBusAcceptsAll() throws Exception {
        Bus bus = new Bus(3);
        bus.boardPassenger(new Fireman());
        bus.boardPassenger(new Policeman());
        bus.boardPassenger(new OrdinaryPassenger());
        Assertions.assertEquals(3, bus.getOccupiedSeats());
    }
}
