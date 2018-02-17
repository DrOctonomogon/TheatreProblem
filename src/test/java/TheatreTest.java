import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TheatreTest {

    String testInput1;
    Theatre theatre;

    @Before
    public void setup() {

        theatre = new Theatre();

        testInput1 = "6 6\n" +
                "3 5 5 3\n" +
                "4 6 6 4\n" +
                "2 8 8 2\n" +
                "6 6\n"+
                "\n" +
                "Smith 2\n" +
                "Jones 5\n" +
                "Davis 6\n" +
                "Wilson 100\n" +
                "Johnson 3\n" +
                "Williams 4\n" +
                "Brown 8\n" +
                "Miller 12";
    }

    @Test
    public void splitInputIntoRowsTest_1() {

        String[] expected = {"6 6", "3 5 5 3", "4 6 6 4", "2 8 8 2", "6 6",
                "",
                "Smith 2", "Jones 5", "Davis 6", "Wilson 100", "Johnson 3", "Williams 4", "Brown 8", "Miller 12"};

        String[] actual = Theatre.splitInputIntoRows(testInput1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfRowsInTheatreTest_1() {

        String[] splitInput = Theatre.splitInputIntoRows(testInput1);

        Integer expected = 5;

        Integer actual = Theatre.getNumberOfRowsInTheatre(splitInput);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getNumberOfTicketRequests_1() {

        String[] splitInput = Theatre.splitInputIntoRows(testInput1);

        Integer expected = 8;

        Integer actual = Theatre.getNumberOfTicketRequests(splitInput);

        Assert.assertEquals(expected, actual);

    }


    @Test
    public void generateTicketRequestList_1() {

        String[] splitInput = Theatre.splitInputIntoRows(testInput1);

        Map<String, Integer> expected = new LinkedHashMap<String, Integer>();
        expected.put("Smith", 2);
        expected.put("Jones", 5);
        expected.put("Davis", 6);
        expected.put("Wilson", 100);
        expected.put("Johnson", 3);
        expected.put("Williams", 4);
        expected.put("Brown" , 8);
        expected.put("Miller", 12);

        theatre.generateTicketRequestList(splitInput);

        Map<String, Integer> actual = theatre.getTicketRequests();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void generateTheatreLayout_1() {

        String[] input = {"6 6", "3 5 5 3", "4 6 6 4", "2 8 8 2", "6 6"};

        Integer[][] expected = new Integer[5][];
        Integer[] arr1 = {6, 6},
                arr2 = {3, 5, 5, 3},
                arr3 = {4, 6, 6, 4},
                arr4 = {2, 8, 8, 2},
                arr5 = {6, 6};
        expected[0] = arr1;
        expected[1] = arr2;
        expected[2] = arr3;
        expected[3] = arr4;
        expected[4] = arr5;

        theatre.generateTheatreLayout(input);

        Integer[][] actual = theatre.theatreLayout;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void generateTheatreLayout_1_AvailableSeatsRemaining() {

        String[] input = {"6 6", "3 5 5 3", "4 6 6 4", "2 8 8 2", "6 6"};

        Integer expected = 70;

        theatre.generateTheatreLayout(input);

        Integer actual = theatre.getAvailableSeatsRemaining();
    }
}
