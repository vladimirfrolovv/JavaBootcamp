package edu.school21.numbers;

public class NumberWorker {
    public boolean isPrime ( int number ) {
        if (number < 2) {
            throw new IllegalNumberException("number < 2");
        }
        for (int i = 2; i * i < number; ++ i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int digitsSum ( int number ) {
        int res = 0;
        while ( number > 0 ) {
            res += number % 10;
            number /= 10;
        }
        return res;
    }
}

class IllegalNumberException extends RuntimeException {
    IllegalNumberException ( String message ) {
        super(message);
    }
}