package invertedindex;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvertedIndexTest {

    @Test
    void searchs1NOTs2Test1() {
        InvertedIndex index = new InvertedIndex();

        File f = new File("textfiles");
        List<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));

        index.buildIndex(files);

        List<File> expected = index.search("Ireland");

        List<File> actual = index.searchs1NOTs2("oak", "wisteria");

        //The actual list should contain File 1, but not File 2. File 1 contains the word ash, but not wisteria.
        assertEquals(expected, actual);
    }

    @Test
    void searchs1NOTs2Test2() {
        InvertedIndex index = new InvertedIndex();

        File f = new File("textfiles");
        List<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));

        index.buildIndex(files);

        List<File> expected = new LinkedList<File>();

        List<File> actual = index.searchs1NOTs2("eucalyptus", "cedar");

        //Both expected and actual should be null as no file contains the word Eucalyptus without the word Cedar
        assertEquals(expected, actual);
    }


}