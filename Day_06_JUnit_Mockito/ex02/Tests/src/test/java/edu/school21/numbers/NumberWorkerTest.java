package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker numberWorker;

    @BeforeEach
    void befoeEachMethod ( ) {
        numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {317, 125119, 2237})
    void isPrimeForPrimes ( int number ) {
        Assertions.assertTrue(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {2140, 5660, 2222222})
    void isPrimeForNotPrimes ( int number ) {
        Assertions.assertFalse(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {- 1, 0, 1, - 555})
    void isPrimeForIncorrectNumbers ( int number ) {
        {
            Assertions.assertThrows(IllegalNumberException.class, ( ) -> numberWorker.isPrime(number));
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void checkDigitsSum ( int input, int expected ) {
        Assertions.assertEquals(numberWorker.digitsSum(input), expected);
    }
}

