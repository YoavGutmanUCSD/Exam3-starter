import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.*;
import org.junit.*;

public class MyHashMapTest {

    private FileReader filereader;
    private DefaultMap<Integer, Student> testMap; // use this for basic tests
    // private MaxHeap<String, Integer> testHeap;

    @Before
    public void setUp() {
        Comparator comp = new TestComp();
        // this.testHeap = new MaxHeap<String, Integer>(15, comp);
        this.filereader = new FileReader("src/input.txt");
    }

    // @Test
    // public void testAddHeap(){
    //     testHeap.add("a", 5);
    //     testHeap.add("b", 7);
    //     testHeap.add("c", 1);
    //     assertEquals("b", testHeap.remove().getKey());
    //     // testHeap.sanityCheck();
    //     // assertEquals("[c, b, a]", testHeap.toString());
    // }

    // @Test
    // public void testAddHeapOutOfOrder(){
    //     testHeap.add("b", 7);
    //     testHeap.add("a", 5);
    //     testHeap.add("c", 1);
    //     // assertEquals("[c, b, a]", testHeap.toString());
    //     assertEquals("b", testHeap.remove().getKey());
    //     // testHeap.sanityCheck();
    // }

    // @Test
    // public void testAddHeapMany(){
    //     testHeap.add("b", 7);
    //     testHeap.add("a", 5);
    //     testHeap.add("c", 1);
    //     testHeap.add("asetd", 5);
    //     testHeap.add("d", 5);
    //     testHeap.add("f", 5);
    //     testHeap.add("e", 5);
    //     testHeap.add("g", 5);
    //     assertEquals("b", testHeap.remove().getKey());
    //     // testHeap.sanityCheck();
    //     // assertEquals("[g, f, asetd, e, a, b, c, d]", testHeap.toString());
    // }
    // @Test
    // public void testAddHeapMaximumMiddle(){
    //     testHeap.add("b", 7);
    //     testHeap.add("a", 5);
    //     testHeap.add("c", 1);
    //     testHeap.add("z", 5);
    //     testHeap.add("d", 5);
    //     testHeap.add("f", 5);
    //     testHeap.add("e", 5);
    //     testHeap.add("g", 5);
    //     assertEquals("b", testHeap.remove().getKey());
    //     // assertTrue(testHeap.sanityCheck());
    //     // assertEquals("[z, g, e, f, b, c, d]", testHeap.toString());
    // }
    // @Test
    // public void testRemoveHeapMaximumMiddle(){
    //     testHeap.add("b", 7);
    //     testHeap.add("a", 5);
    //     testHeap.add("c", 1);
    //     testHeap.add("z", 5);
    //     testHeap.add("d", 5);
    //     testHeap.add("f", 5);
    //     testHeap.add("e", 5);
    //     testHeap.add("g", 5);
    //     HeapEntry<String,Integer> removed = testHeap.remove();
    //     System.out.println(testHeap.toString());
    //     // assertTrue(testHeap.sanityCheck());
    //     assertEquals(removed.getKey(), "b");
    // }
    //Write testcase for checking max score of 2 sections
    @Test
    public void testMaxInTwoSections() throws FileNotFoundException{
        filereader.createHeap();
        Student maxInSectionA = new Student("James", 'A', 94);
        Student maxInSectionB = new Student("Ria", 'B', 88);
        Student grepMaxA = filereader.getMaxOfSection('A');
        Student grepMaxB = filereader.getMaxOfSection('B');
        assertEquals(toString(maxInSectionA), toString(grepMaxA));
        assertEquals(toString(maxInSectionB), toString(grepMaxB));
    }
    public String toString(Student a){
        return String.format("Student %s from section %s recieved %s marks", a.name, a.section, a.marks);
    }

}

class TestComp implements Comparator<Integer> {
    @Override
    public int compare(Integer e, Integer f){
        // Integer key1 = (Integer) e.getKey();
        // Integer key2 = (Integer) f.getKey();
        // System.out.format("Difference between %s and %s is %s\n", e, f, e.compareTo(f));
        return e.compareTo(f);
    }
}
