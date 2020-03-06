package Design.ParkLot;

import java.util.ArrayList;
import java.util.List;

public class Trigger {
    public static void main (String[] args) {
        System.out.println("test start");
        ParkingLot lot = new ParkingLot(4, 10);
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            final Vehicle v = i % 2 == 0 ? new Car(): new Truck();
            list.add(v);
            boolean hasSpot = lot.hasSpots(v);
            if ( i < 40) {
                assert hasSpot;
                assert lot.park(v);
            } else {
                assert !hasSpot;
                assert !lot.park(v);
            }
        }
        assert list.size() == 50;
        int i = 0;
        for (Vehicle v : list) {
            assert i >= 40 || lot.leave(v);
            i++;
        }
    }
}
