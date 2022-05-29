import static org.junit.Assert.*;

import org.junit.*;
public class CircularArrayListTest {


    @Test
    public void test_baseCase() throws Exception {

        // ArrayListADT<Integer> cal = new CircularArrayList<Integer> (10);
        CircularArrayList<Integer> cal = new CircularArrayList<Integer> (10);
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
        int diff = cal.getRear() + cal.getSize() - cal.getFront();
        System.out.format("front:%s\nrear:%s\ndiff:%s\n", cal.getFront(), cal.getRear(), cal.getFront());
        System.out.println(cal.asString());
        assertEquals(cal.get(cal.getRear()), (Integer) 77);

    }
}
