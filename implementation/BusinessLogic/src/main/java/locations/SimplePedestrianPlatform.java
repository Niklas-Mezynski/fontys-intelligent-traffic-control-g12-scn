package locations;

import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;

import java.util.List;
import java.util.Objects;

/** Implementation base of PairPedestrianPlatform
 *
 * @author Daniel Sevov {@code z.sevov@student.fontys.nl}
 */
public abstract class SimplePedestrianPlatform implements PedestrianPlatform {
    private final String name;
    private final int xCoordinate;
    private final int yCoordinate;

    public SimplePedestrianPlatform(String name, int x, int y){
        this.name = name;
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract void addPedestrian(Pedestrian p);

    @Override
    public void addPedestrians(List<Pedestrian> p) {
        p.forEach(this::addPedestrian);
    }

    @Override
    public int getXCoordinate() {
        return xCoordinate;
    }

    @Override
    public int getYCoordinate() {
        return yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimplePedestrianPlatform that = (SimplePedestrianPlatform) o;
        return name.equals(that.name) && xCoordinate == that.getXCoordinate() && yCoordinate == that.getYCoordinate();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, xCoordinate, yCoordinate);
    }

    @Override
    public abstract void update(boolean isPassAllowed, int length, String name);
}
