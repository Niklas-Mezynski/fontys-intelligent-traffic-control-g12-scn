package shapes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShapeBaseTest {
    ShapeBase base = new ShapeBase("Star"){};

    @Test
    void getName() {
        assertThat(base.getName()).isEqualTo("Star");
    }

    @Test
    void testToString() {
        assertThat(base.toString()).isEqualTo("Star Shape");
    }
}