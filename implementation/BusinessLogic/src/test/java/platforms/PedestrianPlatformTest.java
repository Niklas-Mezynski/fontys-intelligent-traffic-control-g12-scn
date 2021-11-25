package platforms;

import entities.PedestrianImpl;
import interfaces.Pedestrian;
import interfaces.PedestrianPlatform;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class PedestrianPlatformTest {
    PedestrianPlatform platform1 = new PedestrianPlatformImpl(1,1);
    PedestrianPlatform platform2 = new PedestrianPlatformImpl(1,2);
    PedestrianPlatform platform3 = new PedestrianPlatformImpl(2,1);
    PedestrianPlatform platform4 = new PedestrianPlatformImpl(2,2);

    Pedestrian pedestrian = new PedestrianImpl("Pedestrian 1", platform1, platform2);

    @Test
    public void testGetters() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(platform1.getX()).isEqualTo(1);
            softAssertions.assertThat(platform1.getY()).isEqualTo(1);
            softAssertions.assertThat(platform2.getX()).isEqualTo(1);
            softAssertions.assertThat(platform2.getY()).isEqualTo(2);
            softAssertions.assertThat(platform3.getX()).isEqualTo(2);
            softAssertions.assertThat(platform3.getY()).isEqualTo(1);
            softAssertions.assertThat(platform4.getX()).isEqualTo(2);
            softAssertions.assertThat(platform4.getY()).isEqualTo(2);
        });
    }

    @Test
    public void testPartners(){
        platform1.addHorizontalPartner(platform2);
        platform1.addVerticalPartner(platform3);
        platform2.addVerticalPartner(platform4);
        platform3.addHorizontalPartner(platform4);

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(platform1.getHorizontalPartner()).isEqualTo(platform2);
            softAssertions.assertThat(platform1.getVerticalPartner()).isEqualTo(platform3);
            softAssertions.assertThat(platform2.getVerticalPartner()).isEqualTo(platform4);
            softAssertions.assertThat(platform3.getHorizontalPartner()).isEqualTo(platform4);
        });
    }

//    @Test
//    public void testQueue(){
//        platform1.attachPedestrian(pedestrian);
//        // TODO
//    }
}
