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
        int diff = cal.getRear() + cal.getCapacity() - cal.getFront();
        // System.out.format("front:%s\nrear:%s\ndiff:%s\n", cal.getFront(), cal.getRear(), cal.getFront());
        // System.out.println(cal.asString());
        assertEquals(cal.get(diff), (Integer) 77);
    }
    @Test
    public void test_Remove() throws Exception {
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
        assertEquals(cal.remove(), (Integer) 70);
        assertEquals(cal.get(0), (Integer) 7);
    }
    @Test
    public void test_expandCapacity() throws Exception {
        ArrayListADT<Integer> cal = new CircularArrayList<Integer> (10);
        //Complete testcase to check elements at few positions
        cal.addFront(7);
        cal.addFront(7);
        cal.addFront(7);
        cal.addFront(70);
        cal.addRear(8);
        cal.addRear(8);
        cal.addRear(8);
        cal.addRear(78);
        cal.addRear(8);
        cal.addRear(8);
        cal.addRear(9);

        // assertEquals("[70, 7, 7, 7, 8, 8, 8, 78, 8, 8, 9]", cal.asString());
        assertEquals("[70, 7, 7, 7, 8, 8, 8, 78, 8, 8, 9]", asString(cal));
    }
    private String asString(ArrayListADT calminte) throws Exception {
        String toReturn = "[";
        for(int i = 0; i < calminte.getSize()-1; i++){
            toReturn += String.format("%s, ", calminte.get(i));
        }
        toReturn += String.format("%s]", calminte.get(calminte.getSize()-1));
        return toReturn;
    }
}
