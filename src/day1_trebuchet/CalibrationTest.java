package day1_trebuchet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class CalibrationTest {

    // more than one parameter of the same type, ints in this case, is needed for the unit test
    private static Stream<Arguments> inputsAndResults() {
        return Stream.of(
                Arguments.of("5fxhhkghvm3nineshpcxhtwo6fourhrktpbq", 56, 54),
                Arguments.of("qklhmhmdlgeighttwoonetwo52five", 52, 85),
                Arguments.of("86threemmpchhzdvsvxfzrj", 86, 83),
                Arguments.of("9clvchpgrslnkhdmfkjmlrvgnf", 99, 99),
                Arguments.of("8ncpdtspfivethree", 88, 83));
    }

    @ParameterizedTest
    @MethodSource("inputsAndResults")
    void testToString(String strings) {

        Calibration calibration1 = new Calibration(strings);
        assertEquals("Calibration value from " + strings + " was found: 0", calibration1.toString());

    }

    @ParameterizedTest
    @MethodSource("inputsAndResults")
    void getCalibrationValue_outcome_validation(String strings, int method1, int method2) {

        Calibration calibration2 = new Calibration(strings);

        assertInstanceOf(Integer.class, calibration2.getCalibrationValue(1));
        assert calibration2.getCalibrationValue(1) > 0;
        assertEquals(method1, calibration2.getCalibrationValue(1));

        assertInstanceOf(Integer.class, calibration2.getCalibrationValue(2));
        assert calibration2.getCalibrationValue(2) > 0;
        assertEquals(method2, calibration2.getCalibrationValue(2));

    }

}