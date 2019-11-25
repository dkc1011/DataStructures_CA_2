package invertedindex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeMapTest {

    @Test
    void printIterativeTest1() {
        BinarySearchTreeMap<String, String> testMap = new BinarySearchTreeMap();

        // insert some key-value pairs e.g. name, mobile number
        testMap.put("Alpha", "Fred");
        testMap.put("Bravo", "Wilhelm");
        testMap.put("Charlie", "Kyle");
        testMap.put("Delta", "Julie");

        ArrayList<String> expected = new ArrayList<>();

        expected.add("Alpha");
        expected.add("Bravo");
        expected.add("Charlie");
        expected.add("Delta");

        ArrayList<String> actual = testMap.printIterative();

        //Both lists should contain all of the added keys
        assertEquals(expected, actual);
    }

    @Test
    void printIterativeTest2() {
        BinarySearchTreeMap<String, String> testMap = new BinarySearchTreeMap();


        ArrayList<String> expected = new ArrayList<>();

        ArrayList<String> actual = testMap.printIterative();

        //Both lists should be null.
        assertEquals(expected, actual);
    }
}