public class Main {

    public int maxProduct(int[] nums) {
        int highest, secondHighest;

        if (nums[0] > nums[1]) {
            highest = nums[0];
            secondHighest = nums[1];
        } else {
            highest = nums[1];
            secondHighest = nums[0];
        }

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] >= highest) {
                secondHighest = highest;
                highest = nums[i];
            } else if (nums[i] > secondHighest) {
                secondHighest = nums[i];
            }
        }

        return (highest - 1) * (secondHighest - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Main().maxProduct(new int[]{1, 2, 3,4,5}));
    }
}