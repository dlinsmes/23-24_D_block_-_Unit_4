public class Recursion {
    public static void main(String [] args) {
        System.out.println("2^5 is " + exponent(2, 5));
        System.out.println("2^0 is " + exponent(2, 0));


        System.out.println("2^5 is " + expRecursive(2, 5));

        countDownFrom(7);

        countUpTo(10);

        System.out.println();
        System.out.println(fibLoop(8));
        System.out.println(fib(8));

    }

    public static int exponent(int base, int pow) {
        int ans = 1;
        for (int i = 0; i < pow; i++) {
            ans = ans * base;
        }
        return ans;
    }

    //a recursive method is a method that contains a call to itself
    //-recursive methods are used when you can take a large problem
    //and solve it one piece at a time


    //2^6 = 2 * 2 * 2 * 2 * 2 * 2
    //    = 2 * 2^5
    //2^5 = 2 * 2^4
    //...
    //2^2 = 2 * 2^1
    //2^1 = 2 * 2^0
    //2^0 = 1

    //b^p = b * b^(p-1)

    public static int expRecursive(int base, int pow) {
        //in recursion, the base case is the smallest version of the problem
        //where the solution is easily defined
        //-the base case should NOT make a recursive method call
        if (pow == 0) {
            return 1;
        }
        else {

            //when you make the recursive call to the method, make sure
            //the argument (value for param) is slowly working toward
            //the base case condition
            return base * expRecursive(base, pow-1);
        }


    }

    //if n is 5, print 5 4 3 2 1 0
    public static void countDownFrom(int n) {
        //base case - when the method stops calling itself
        if (n == 0)
            System.out.print("0\n");
        else {
            System.out.print(n + " ");
            countDownFrom(n-1);
        }
    }

    //start at 0, count up to n
    public static void countUpTo(int n) {

        if (n == 0)
            System.out.print("0 ");
        else {
            countUpTo(n-1);
            //any lines of code AFTER the recursive method call won't
            //run until the recursive call finishes
            System.out.print(n + " ");
        }

    }

    //any recursive method CAN be written iteratively (with a loop instead)

    //fibonacci numbers
    // 1 1 2 3 5 8 13 21
    //after 1 and 1, every following number is the sum of the previous 2
    //f(1) = 1
    //f(2) = 1
    //f(3) = f(2) + f(1)
    //f(n) = f(n-1) + f(n-2)

    //return the nth fibonacci number in the sequence
    public static int fib(int n) {
        //base case - the first two numbers in the sequence are 1
        if (n == 1 || n == 2)
            return 1;
        //recursive case - the next number is the sum of the previous 2 numbers
        else
            return fib(n-1) + fib(n-2);
    }

    //write an equivalent method using loops
    public static int fibLoop(int n) {
        int prev2 = 0;
        int prev1 = 0;
        int current = 1;
        for (int i = 2; i <=n; i++ ) {
            prev2 = prev1;
            prev1 = current;
            current = prev2 + prev1;
        }
        return current;
    }


}
