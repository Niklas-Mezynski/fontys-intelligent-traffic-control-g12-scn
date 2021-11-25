package entities;

import interfaces.Driver;
import interfaces.DriverPlatform;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import platforms.DriverPlatformImpl;

public class DriverTest {
    DriverPlatform start = new DriverPlatformImpl(1,1);
    DriverPlatform end = new DriverPlatformImpl(1,2);
    Driver driver = new DriverImpl("Driver 1", start, end);

    @Test
    public void testGetters(){
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(driver.getStartingPoint()).isEqualTo(start);
            softAssertions.assertThat(driver.getDestination()).isEqualTo(end);
            softAssertions.assertThat(driver.getName()).isEqualTo("Driver 1");
        });
    }
}
