package com.maxt28;

public abstract class BinarySearch {

    public static int binarySearch(int[] array, int number) {
        int leftPosition = 0;
        int rightPosition = array.length - 1;
        int midPosition = array.length / 2;
        return findPosition(leftPosition, rightPosition, midPosition, array, number);
    }

    private static int findPosition(int leftPos, int rightPos, int midPos, int[] array, int num){
        while (array[midPos] != num) {
            boolean rightPartIsSorted = rightPartIsSorted(midPos, rightPos, array);
            boolean numInLeftPart = numInLeftPart(midPos, array, num);
            boolean numInRightPart = numInRightPart(midPos, array, num);
            boolean numIsNotInOffset = numIsNotInOffset(rightPos, array, num);
            if (rightPartIsSorted && numInLeftPart) {
                rightPos = midPos - 1;
            } else if (rightPartIsSorted && numInRightPart && numIsNotInOffset) {
                rightPos = midPos - 1;
            } else if (numInLeftPart && numIsNotInOffset) {
                rightPos = midPos - 1;
            } else {
                leftPos = midPos + 1;
            }
            midPos = leftPos + (rightPos - leftPos) / 2;
        }
        return midPos;
    }
    
    private static boolean numInLeftPart(int midPos, int[] array, int num){
        return (num < array[midPos]);
    }
    
    private static boolean numInRightPart(int midPos, int[] array, int num){
        return(num > array[midPos]);
    }
    
    private static boolean rightPartIsSorted(int midPos, int rightPos,int[] array){
        return(array[midPos] < array[rightPos]);
    }
    
    private static boolean numIsNotInOffset(int rightPos, int[] array, int num){
        return (num > array[rightPos]);
    }
}

