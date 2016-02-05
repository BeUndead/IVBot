package com.com.ivbot.compute;

import com.com.nfor.NFor;

public class ComputationUtilities {

    public static NFor<Integer> getNForFromIvRanges(int[][] ivRanges) {

        Integer[] lowerBounds = new Integer[6];
        Integer[] upperBoundsPlusOne = new Integer[6];
        for (int i = 0; i < 6; i++) {
            lowerBounds[i] = ivRanges[i][0];
            upperBoundsPlusOne[i] = ivRanges[i][1] + 1;
        }

        return NFor.of(Integer.class).from(lowerBounds).to(upperBoundsPlusOne);
    }

    public static int[] convertToPrimitive(Integer[] array) {
        int[] output = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            output[i] = array[i];
        }
        return output;
    }

}
