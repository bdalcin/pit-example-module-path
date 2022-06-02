package multi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplyTest {

    @Test
    public void shouldDescribeAsMultiplication() {
        var multiply = new Multiply();
        assertEquals("multiplication", multiply.describeOperation());
    }
}