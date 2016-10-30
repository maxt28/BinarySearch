package com.maxt28;

public abstract class BinarySearch {

    public static int binarySearch(int[] array, int number) {
        int position;
        int step;
        int offset = findOffset(array);
        if (number < array[0]) {
            position = array.length - 1 - offset / 2;
            step = offset / 4;
        } else {
            position = (array.length - offset) / 2;
            step = position / 2;
        }
        if (step == 0) {
            step = 1;
        }
        for (; array[position] != number; step /= 2) {
            if (array[position] > number) {
                position -= step++;
            } else if (array[position] < number) {
                position += step++;
            }
        }
        return position;
    }

    private static int findOffset(int[] array) {
        if (array[array.length - 1] < array[0]) {
            int offset = 1;
            for (int i = array.length - 1; array[i] > array[i - 1]; i--, offset++) {
            }
            return offset;
        } else {
            return 0;
        }
    }
}