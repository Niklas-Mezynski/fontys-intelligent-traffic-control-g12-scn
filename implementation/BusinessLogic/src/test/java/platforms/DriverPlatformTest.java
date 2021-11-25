package platforms;

import entities.DriverImpl;
import interfaces.Driver;
import interfaces.DriverPlatform;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DriverPlatformTest {

    DriverPlatform driverPlatform1 = new DriverPlatformImpl(1, 1);
    DriverPlatform driverPlatform2 = new DriverPlatformImpl(1, 2);
    DriverPlatform driverPlatform3 = new DriverPlatformImpl(2, 1);
    DriverPlatform driverPlatform4 = new DriverPlatformImpl(2, 2);
    Driver driver = new DriverImpl("Driver 1", driverPlatform1, driverPlatform2);


    @Test
    public void testGetters() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(driverPlatform1.getX()).isEqualTo(1);
            softAssertions.assertThat(driverPlatform1.getY()).isEqualTo(1);
            softAssertions.assertThat(driverPlatform2.getX()).isEqualTo(1);
            softAssertions.assertThat(driverPlatform2.getY()).isEqualTo(2);
            softAssertions.assertThat(driverPlatform3.getX()).isEqualTo(2);
            softAssertions.assertThat(driverPlatform3.getY()).isEqualTo(1);
            softAssertions.assertThat(driverPlatform4.getX()).isEqualTo(2);
            softAssertions.assertThat(driverPlatform4.getY()).isEqualTo(2);
        });
    }

    @Test
    public void testPartners(){
        driverPlatform1.addHorizontalPartner(driverPlatform2);
        driverPlatform1.addVerticalPartner(driverPlatform3);
        driverPlatform2.addVerticalPartner(driverPlatform4);
        driverPlatform3.addHorizontalPartner(driverPlatform4);

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(driverPlatform1.getHorizontalPartner()).isEqualTo(driverPlatform2);
            softAssertions.assertThat(driverPlatform1.getVerticalPartner()).isEqualTo(driverPlatform3);
            softAssertions.assertThat(driverPlatform2.getVerticalPartner()).isEqualTo(driverPlatform4);
            softAssertions.assertThat(driverPlatform3.getHorizontalPartner()).isEqualTo(driverPlatform4);
        });
    }

    @Test
    public void testQueue(){
        driverPlatform1.attachDriver(driver);
        assertThat(driverPlatform1.getCount()).isEqualTo(1);

    }
}
