import static org.junit.Assert.*;

import org.junit.*;
public class CircularArrayListTest {


    @Test
    public void test_baseCase() throws Exception {

        ArrayListADT<Integer> cal = new CircularArrayList<Integer> (10);
        //Complete testcase to check elements at few positions
        cal.addFront(7);
        cal.addFront(7);
        cal.addFront(7);
        cal.addFront(70);
        cal.addRear(7);
        cal.addRear(7);
        cal.addRear(7);
        cal.addRear(77);
        assertEquals(cal.get(0), (Integer) 70);
        int diff = cal.getSize() - cal.getFront() - 1 + cal.getRear();
        assertEquals(cal.get(cal.getRear()), (Integer) 77);

    }
}
