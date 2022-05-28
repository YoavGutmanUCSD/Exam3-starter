import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.*;
import org.junit.*;

public class MyHashMapTest {
	
	// private FileReader filereader;
	// private DefaultMap<Integer, Student> testMap; // use this for basic tests
        private MaxHeap<String, Integer> testHeap;

	// @Before
	// public void setUp() {
	// 	filereader = new FileReader("src/input.txt");
	// }
        @Before
        public void initialize() {
            Comparator comp = new TestComp();
            testHeap = new MaxHeap<String, Integer>(15, comp);
        }

        @Test
        public void testAddHeap(){
            testHeap.add("a", 5);
            testHeap.add("b", 7);
            testHeap.add("c", 1);
            assertEquals("[c, b, a]", testHeap.toString());
        }

        @Test
        public void testAddHeapOutOfOrder(){
            testHeap.add("b", 7);
            testHeap.add("a", 5);
            testHeap.add("c", 1);
            assertEquals("[c, b, a]", testHeap.toString());
        }

        @Test
        public void testAddHeapMany(){
            testHeap.add("b", 7);
            testHeap.add("a", 5);
            testHeap.add("c", 1);
            testHeap.add("asetd", 5);
            testHeap.add("d", 5);
            testHeap.add("f", 5);
            testHeap.add("e", 5);
            testHeap.add("g", 5);
            assertEquals("[g, f, asetd, e, a, b, c, d]", testHeap.toString());
        }
        @Test
        public void testAddHeapMaximumMiddle(){
            testHeap.add("b", 7);
            testHeap.add("a", 5);
            testHeap.add("c", 1);
            testHeap.add("z", 5);
            testHeap.add("d", 5);
            testHeap.add("f", 5);
            testHeap.add("e", 5);
            testHeap.add("g", 5);
            assertEquals("[z, g, e, f, b, c, d]", testHeap.toString());
        }
        @Test
        public void testRemoveHeapMaximumMiddle(){
            testHeap.add("b", 7);
            testHeap.add("a", 5);
            testHeap.add("c", 1);
            testHeap.add("z", 5);
            testHeap.add("d", 5);
            testHeap.add("f", 5);
            testHeap.add("e", 5);
            testHeap.add("g", 5);
            HeapEntry<String,Integer> removed = testHeap.remove();
            assertTrue(testHeap.sanityCheck());
            assertEquals(removed, "z");
        }
	//Write testcase for checking max score of 2 sections

	
}

class TestComp implements Comparator<String> {
    @Override
    public int compare(String e, String f){
        // String key1 = (String) e.getKey();
        // String key2 = (String) f.getKey();
        System.out.format("Difference between %s and %s is %s\n", e, f, e.compareTo(f));
        return e.compareTo(f);
    }
}
