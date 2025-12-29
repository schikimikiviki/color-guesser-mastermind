import com.backend.Guesser;
import com.backend.data.entities.Colorcode;
import com.backend.data.entities.Feedback;
import com.backend.data.enums.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class GuesserTest {

        private Guesser guesser;

        @BeforeEach
        void setUp() {
            guesser = new Guesser();
        }

        @Test
        void checkGuess_ifColorAppearsTwice() {
            List<Color> secretList = new ArrayList<>();
            List<Color> guessedList = new ArrayList<>();
            secretList.add(Color.BLUE);
            secretList.add(Color.BLUE);
            secretList.add(Color.GREEN);
            secretList.add(Color.ORANGE);
            //---------------------------//
            guessedList.add(Color.PINK);
            guessedList.add(Color.RED);
            guessedList.add(Color.BLUE);
            guessedList.add(Color.PINK);

            Colorcode secretCode = new Colorcode(secretList);
            Colorcode guessedCode = new Colorcode(guessedList);

            // this should return:
            // 0 exact matches
            // 1 color match - blue

            Feedback expectedFeedback = new Feedback(0,1);
            Feedback actualFeedback = guesser.checkWhatIsCorrect(secretCode, guessedCode);
            System.out.println("Feedback we got: Exact match is " + actualFeedback.getCorrectPosition() + " and color match is: " + actualFeedback.getCorrectColor());
            assertEquals(actualFeedback, expectedFeedback);
        }


    @Test
    void checkGuess_ifColorAppearsTwice_inGuess() {
        List<Color> secretList = new ArrayList<>();
        List<Color> guessedList = new ArrayList<>();
        secretList.add(Color.BLUE);
        secretList.add(Color.BLUE);
        secretList.add(Color.GREEN);
        secretList.add(Color.ORANGE);
        //---------------------------//
        guessedList.add(Color.PINK);
        guessedList.add(Color.BLUE);
        guessedList.add(Color.BLUE);
        guessedList.add(Color.PINK);

        Colorcode secretCode = new Colorcode(secretList);
        Colorcode guessedCode = new Colorcode(guessedList);

        // this should return:
        // 1 exact matches - blue
        // 1 color match - blue

        Feedback expectedFeedback = new Feedback(1,1);
        Feedback actualFeedback = guesser.checkWhatIsCorrect(secretCode, guessedCode);
        System.out.println("Feedback we got: Exact match is " + actualFeedback.getCorrectPosition() + " and color match is: " + actualFeedback.getCorrectColor());
        assertEquals(actualFeedback, expectedFeedback);
    }







}
