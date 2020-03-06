package Design.ParkLot;
import Design.ParkLot.Vehicle;
public class ParkingLot {
    private final Level[] levels; // why don't use list?
    public ParkingLot(int numLevels, int numSpotsPerLevel) {
        levels = new Level[numLevels];
        for (int i = 0; i < numLevels; i++) {
            levels[i] = new Level(numSpotsPerLevel);
        }
    }

    public boolean hasSpots(Vehicle v) {
        for (Level l : levels) {
            if (l.hasSpot(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean park(Vehicle v) {
        for (Level l : levels) {
            if (l.park(v)) {
                return true;
            }
        }
        return false;
    }

    public boolean leave(Vehicle v) {
        for (Level l : levels) {
            if (l.leave(v)) {
                return true;
            }
        }
        return false;
    }
}
