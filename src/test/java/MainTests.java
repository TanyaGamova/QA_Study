import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTests {
    @Test // #1
    public void SimpleTest() {
        int[] input = { 4, 3, 2, 5, 1 };
        int[] trueRes = { 1, 2, 3, 4, 5 };

        int[] result = Main.thanosSort( input );
        assertArrayEquals( result, trueRes );
    }

    @Test // #2
    public void ZeroTest() {
        int[] input = { 1, 0, 3, 2, 10 };
        int[] trueRes = { 0, 1, 2, 3, 10 };

        int[] result = Main.thanosSort( input );
        assertArrayEquals( result, trueRes );
    }

    @Test // #3
    public void DupleTest() {
        int[] input = { 3, 1, 2, 1, 6, 1 };
        int[] trueRes = { 1, 1, 1, 2, 3, 6 };

        int[] result = Main.thanosSort( input );
        assertArrayEquals( result, trueRes );
    }

    @Test // #4
    public void SingleTest() {
        int[] input = { 15 };
        int[] trueRes = { 15 };

        int[] result = Main.thanosSort( input );
        assertArrayEquals( result, trueRes );
    }

    @Test // #5
    public void InverseTest() {
        int[] input = { 66, 45, 23, 17 };
        int[] trueRes = { 17, 23, 45, 66 };

        int[] result = Main.thanosSort( input );
        assertArrayEquals( result, trueRes );
    }
}
