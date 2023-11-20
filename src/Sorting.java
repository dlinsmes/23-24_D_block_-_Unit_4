public class Sorting {

    public static void main(String [] args) {
        int [] nums = {9, 3, 2, -4, 0, 3, 21, 7};
        insertionSort(nums);
        for (int n: nums)
            System.out.print(n + " ");
        System.out.println();

        int a = -9;
        double b = 3.9;
        String c = "something";
        boolean d = true;

        System.out.println(a + " " + b + " " + c + " " + d);
        doSomething(a, b, c, d);

        System.out.println(a + " " + b + " " + c + " " + d);

        //primitive data types: int, double, boolean
        //And Strings (aren't primitive but act like primitives)
        //-when you pass primitive data to a method, a copy is used in the method
        //and the original values don't get changed

        //Arrays and other objects (next semester) CAN be changed by methods,
        //and the original data will change if the other method changes any values

        doSomethingElse(nums);
        for (int n: nums)
            System.out.print(n + " ");
        System.out.println();
    }

    public static void doSomethingElse(int [] list) {
        for (int i = 0; i < list.length; i++)
            list[i] = 0;
    }


    public static void doSomething(int a, double b, String c, boolean d) {
        a = 7;
        b = -2.6;
        c = "elephant";
        d = false;

        System.out.println("inside doSomething: " + a + " " + b + " " + c + " " + d);

    }

    //selection sort - find next smallest unsorted value and swap
    //into correct position
    public static void selectionSort(int [] list) {
        for (int i = 0; i < list.length; i++) {
            int smallestI = i;
            for (int j = i+1; j < list.length; j++)
                if (list[j] < list[smallestI])
                    smallestI = j;

            int temp = list[smallestI];
            list[smallestI] = list[i];
            list[i] = temp;
        }
    }

    //insertion sort - probably like what you do when you're holding
    //cards in your hand to sort
    //-moving from left to right, pick up a card (current) and assume
    //the cards to the left of current are already in sorted order.
    //-to the LEFT, move any cards that are greater than current
    //up by one position
    //-When you find a value that is less than current, DON'T move that
    //value, and insert current in front of that smaller value
    public static void insertionSort(int [] list) {
        for (int i = 1; i < list.length; i++) {
            //use a current like temp so that position i can be used
            //to move other values into
            int current = list[i];

            //j represents the position whose value potentially moves
            //up by one
            int j = i - 1;

            //keep looking behind position i (current position) as long
            //as there's a valid index and the value stored at j is
            //bigger than current
            while (j >= 0 && list[j] > current) {

                //move card j up by one position
                list[j+1] = list[j];

                j--;
            }

            //after this loop, all the numbers that need to change position
            //have been moved, and current can be inserted into the position
            //j+1;
            list[j+1] = current;

            for (int n: list)
                System.out.print(n + " ");
            System.out.println();
        }
    }
}
