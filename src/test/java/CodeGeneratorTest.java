
import static org.junit.jupiter.api.Assertions.*;

import com.backend.CodeGenerator;
import com.backend.data.enums.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CodeGeneratorTest {

    private CodeGenerator generator;

    @BeforeEach
    void setUp() {
        generator = new CodeGenerator();
    }

    @Test
    void generateCodes() {
        int numberOfCombinations = 1296; // 6^4, the number of codes we need to have
        List<List<Color>> allColorCodes = generator.generateAllCodes();
        System.out.println(Arrays.toString(allColorCodes.toArray()));

        assertEquals(numberOfCombinations, allColorCodes.size());
    }


    }

