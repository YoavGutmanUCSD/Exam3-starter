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
            assertEquals("[a, b, c]", testHeap.toString());
        }


	//Write testcase for checking max score of 2 sections

	
}

class TestComp implements Comparator<String> {
    @Override
    public int compare(String e, String f){
        // String key1 = (String) e.getKey();
        // String key2 = (String) f.getKey();
        return e.compareTo(f);
    }
}
