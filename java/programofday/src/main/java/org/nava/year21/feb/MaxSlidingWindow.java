package org.nava.year21.feb;

/**
 * Given a large array of integers and a window of size
 w
 w, find the current maximum value in the window as the window slides through the entire array.
 */
class MaxSlidingWindow{
    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        int maxIndex=0;

        for(int i=0; i<=arr.length-windowSize; i++){
            int max = arr[i];
            int j=i+1;
            maxIndex = i+windowSize;
            maxIndex = maxIndex;
            while(j < maxIndex){
                int currentValue = arr[j];
                if(currentValue > max){
                    max = currentValue;
                }
                j++;
            }
            result.add(max);
        }

        return result;
    }

    public static void main(String[] args){

        ArrayDeque<Integer> result = findMaxSlidingWindow([1, 2, 3, 4, 3, 2, 1, 2, 5],4);

        for(int r : result){
            System.out.println("Result : "+r);
        }
    }

}
