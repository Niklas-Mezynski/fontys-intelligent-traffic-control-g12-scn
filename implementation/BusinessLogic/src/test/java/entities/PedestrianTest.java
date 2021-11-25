package entities;

import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import platforms.PedestrianPlatformImpl;

public class PedestrianTest {
    PedestrianPlatform start = new PedestrianPlatformImpl(1,1);
    PedestrianPlatform end = new PedestrianPlatformImpl(1,2);
    Pedestrian pedestrian = new PedestrianImpl("Pedestrian 1", start, end);

    @Test
    public void testGetters(){
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(pedestrian.getStartingPoint()).isEqualTo(start);
            softAssertions.assertThat(pedestrian.getDestination()).isEqualTo(end);
            softAssertions.assertThat(pedestrian.getName()).isEqualTo("Pedestrian 1");
        });
    }
}
