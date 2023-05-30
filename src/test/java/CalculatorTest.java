import Calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {

    private Calculator calculatorUnderTest;

    private static Instant startedAt;

    @BeforeEach
    public void initCalculator(){
        System.out.println("Appel avant chaque test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void undefCalculator(){
        System.out.println("Appel après chaque test");
        calculatorUnderTest = null;
    }

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }

    @AfterAll
    static public void showTestDuration(){
        System.out.println("Appel après tout les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des tests : {0} ms", duration));
    }
    @Test
    public void testAddTwoPositiveNumbers(){
        //ARRANGE
        int a = 2;
        int b = 3;

        //ACT
        int somme = calculatorUnderTest.add(a, b);

        //ASSERT
        //assertEquals(5, somme);
        assertThat(somme).isEqualTo(5);
    }

    @Test
    public void multiply_shouldReturnTheProduct_ofTwoInteger(){
        //ARRANGE
        int a = 42;
        int b = 11;

        //ACT
        int produit  = calculatorUnderTest.multiply(a, b);

        //ASSERT
        //assertEquals(462, produit);
        assertThat(produit).isEqualTo(462);
    }

    @ParameterizedTest(name = "{0} * 0 doit être égal à 0")
    @ValueSource(ints = {1,2,3,4,5,6})
    public void multiply_shouldReturnZero_ofZeroWithIntegers(int arg){
        //ARRANGE

        //ACT
        int produit  = calculatorUnderTest.multiply(arg, 0);

        //ASSERT
        //assertEquals(0, produit);
        assertThat(produit).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0} + {1} doit être égale à {2}")
    @CsvSource({"1,2,3", "4,5,9", "7,8,15"})
    public void addition_shouldReturnTheSum_ofMultipleInteger(int a, int b, int expectResult){
        //ARRANGE

        //ACT
        int actualResult = calculatorUnderTest.add(a, b);

        //ASSERT
        //Methode JUnit: assertEquals(actualResult, expectResult);
        assertThat(actualResult).isEqualTo(expectResult); //AssertJ
    }

    @Timeout(3)
    @Test
    public void longCalcul_shouldComputeInLessThan1Second() {
        // Arrange

        // Act
        calculatorUnderTest.longCalculation();

        // Assert
        // ...
    }

    @Test
    public void digitsSet_shouldReturnsTheSetOfDigits_ofPositiveInteger() {
        // GIVEN
        int number = 95897;

        // WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

        // THEN
        //Set<Integer> expectedDigits = Stream.of(5, 7, 8, 9).collect(Collectors.toSet());
        //assertEquals(expectedDigits, actualDigits);
        assertThat(actualDigits).containsExactly(5, 7, 8, 9);
    }
}
