package com.maxt28;

public abstract class BinarySearch {

    public static int binarySearch(int[] array, int number) {
        int leftPosition = 0;
        int rightPosition = array.length - 1;
        int midPosition = array.length / 2;
        while (array[midPosition] != number) {
            if ((array[midPosition] < array[rightPosition] &&
                    ((number < array[midPosition]) ||
                            (number > array[midPosition] && number > array[rightPosition]))) ||
                    (number < array[midPosition] && number >= array[leftPosition])) {
                rightPosition = midPosition - 1;
            } else {
                leftPosition = midPosition + 1;
            }
            midPosition = leftPosition + (rightPosition - leftPosition) / 2;
        }
        return midPosition;
    }
}

