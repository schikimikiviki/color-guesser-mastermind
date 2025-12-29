import com.backend.CodeGenerator;
import com.backend.Guesser;
import com.backend.Solver;
import com.backend.data.enums.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SolverTests {

    private Solver solver;
    private Guesser guesser;
    private CodeGenerator codeGenerator;
    private List<List<Color>> allColors;

    @BeforeEach
    void setUp() {
        solver = new Solver(guesser, codeGenerator);
        allColors = new CodeGenerator().generateAllCodes();
    }

    @Test
    void splitListIntoSublists() {
        int number_of_sublists = 4;
        List<List<List<Color>>> colorSubLists = solver.splitListIntoSubLists(allColors, number_of_sublists);
        // print the first list to check
        System.out.println("the first list is: ");
        System.out.println(Arrays.toString(colorSubLists.get(0).toArray()));
        System.out.println("its length is: " + colorSubLists.get(0).size());

        assertEquals(number_of_sublists, colorSubLists.size());
    }

    @Test
    void checkLengthOfSublists() {
        int number_of_sublists = 4;
        List<List<List<Color>>> colorSubLists = solver.splitListIntoSubLists(allColors, number_of_sublists);

        int lengthOriginalList = allColors.size();
        int lengthFirstList = colorSubLists.get(0).size();
        int lengthSecondList = colorSubLists.get(0).size();
        int lengthThirdList = colorSubLists.get(0).size();
        int lengthFourthList = colorSubLists.get(0).size();

        System.out.println("The sublists have lengths: " + lengthFirstList + " ," + lengthSecondList  + " ," + lengthThirdList  + " ," + lengthFourthList);

        assertNotEquals(lengthFirstList, lengthOriginalList);
        assertNotEquals(lengthSecondList, lengthOriginalList);
        assertNotEquals(lengthThirdList, lengthOriginalList);
        assertNotEquals(lengthFourthList, lengthOriginalList);

        // also check if the sum equals the original length
        int sumOfLengths = lengthFirstList + lengthSecondList + lengthThirdList + lengthFourthList;
        assertEquals(lengthOriginalList, sumOfLengths);
    }


}
