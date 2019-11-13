import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TwelveTest {

    Twelve twelve = new Twelve();

    @Test
    public void add() {
        for (int i = 0; i < 10; i ++){
            twelve.add(Integer.toString(i));
        }
        assertEquals(10, twelve.size(), "Size must be equal");
        assertEquals("0", twelve.get(0), "Elements must be the same");
        String controlString = "10";
        twelve.add(controlString);
        assertEquals(16, twelve.array.length, "Verifying increasing a size of array");
        //negative scenario
        assertEquals(10, twelve.size(), "Actual size bigger than expected");
        assertEquals("2", twelve.get(0), "Elements must be the same");
        assertEquals(15, twelve.array.length, "Verifying increasing a size of array");

    }

    @Test
    public void addAllArray() {
        String[] testArray =  {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        twelve.addAll(testArray);
        assertEquals(10, twelve.size(), "Size must be equal");
        assertEquals("5", twelve.get(5), "Elements must be the same");
        twelve.addAll(testArray);
        assertEquals(20, twelve.size(), "Size must be equal");
        assertEquals("0", twelve.get(10), "Elements must be the same");
        assertEquals(26, twelve.array.length, "Verifying increasing a size of array");
        //negative scenario
        assertEquals(26, twelve.size(), "Size must be equal");
        assertEquals("2", twelve.get(10), "Elements must be the same");
        assertEquals(20, twelve.array.length, "Verifying increasing a size of array");
    }

    @Test
    public void addAllCollection() {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        twelve.addAll(list);
        assertEquals(10, twelve.size(), "Size must be equal");
        assertEquals("5", twelve.get(5), "Elements must be the same");
        twelve.addAll(list);
        assertEquals(20, twelve.size(), "Size must be equal");
        assertEquals("0", twelve.get(10), "Elements must be the same");
        assertEquals(26, twelve.array.length, "Verifying increasing a size of array");
        //negative scenario
        assertEquals(26, twelve.size(), "Size must be equal");
        assertEquals("2", twelve.get(10), "Elements must be the same");
        assertEquals(20, twelve.array.length, "Verifying increasing a size of array");
    }

    @Test
    public void deleteByIndex() {
        twelve.addAll(new String[]{"0", "1", "2", "3", "4"});
        twelve.delete(2);
        assertEquals("3", twelve.get(2), "Elements after delete");
        assertEquals(4, twelve.size(), "Size must be -1 after deleting an element");
        assertEquals(null, twelve.get(4), "Elements must be the same");
        //negative scenario
        assertTrue(twelve.delete(16), " Not valid index ");
        assertEquals("2", twelve.get(2), "Elements after delete");
        assertEquals(5, twelve.size(), "Size must be -1 after deleting an element");
        assertEquals("4", twelve.get(4), "Elements must be the same");
    }

    @Test
    void deleteByValue() {
        twelve.addAll(new String[]{"0", "1", "2", "3", "4"});
        twelve.delete("2");
        assertEquals("3", twelve.get(2), "Elements after delete");
        assertEquals(4, twelve.size(), "Size must be -1 after deleting an element");
        assertEquals(null, twelve.get(4), "Elements must be the same");
        //negative scenario
        assertTrue(twelve.delete("77"), "There is not such element");
    }

    @Test
    public void get() {
        twelve.add("0");
        assertEquals("0", twelve.get(0), "Elements must be the same");
        assertEquals(null, twelve.get(10), "Elements must be the same");
    }

    @Test
    public void contains() {
        twelve.addAll(new String[]{"0", "1", "2", "3"});
        assertTrue(twelve.contains("2"), "Contains");
        //negative
        assertTrue(twelve.contains("5"), "Contains");
    }

    @Test
    public void clear() {
        twelve.addAll(new String[]{"0", "1", "2", "3"});
        twelve.clear();
        assertEquals(0, twelve.size(), "Size has to be the same");
        assertEquals(10, twelve.array.length, "Array length must be the same");
        // negative scenario
        assertEquals(1, twelve.size(), "Size has to be the same");
        assertEquals(0, twelve.array.length, "Array length must be the same");
    }

    @Test
    public void size() {
        assertEquals(0, twelve.count, "Size must be the same");
        twelve.add("0");
        assertEquals(1, twelve.count, "Elements must be the same");
        //negative
        assertEquals(10, twelve.count, "Elements must be the same");
    }

    @Test
    public void trim() {
        twelve.addAll(new String[]{"0", "1", "2" ,"3", "4", "5", "6", "7", "8", "9"});
        twelve.add("10");
        assertEquals(16, twelve.array.length, "Length of array before trim operation");
        twelve.trim();
        assertEquals(11, twelve.array.length, "Length of array after trim operation");
        //negative scenario
        assertEquals(6, twelve.array.length, "Length of array after trim operation");
    }

    @Test
    public void compare() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        twelve.addAll(new String[]{"c", "a", "d", "b"});
        assertTrue(twelve.compare(list), "Equals");
        List<String> stringList = new ArrayList<>();
        stringList.add("e");
        stringList.add("f");
        stringList.add("g");
        stringList.add("h");
        stringList.add("j");
        assertFalse(twelve.compare(stringList),"Not equals");
        //negative scenario
        assertTrue(twelve.compare(stringList),"Not equals");
        assertFalse(twelve.compare(list),"Not equals");
    }
}
