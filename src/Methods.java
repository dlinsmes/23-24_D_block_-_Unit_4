public class Methods {
    public static void main(String [] args) {

        //write code what will calculate the sum of values
        //between 2 provided numbers:
        //ex: 4 and 8 --> 4 + 5 + 6 + 7 + 8
        int small = 4;
        int big = 8;
        int sum = 0;
        for (int i = small; i <= big; i++) {
            sum += i;
        }
        System.out.println("sum between 4 and 8 is " + sum);

        //to repeat this same functionality later in the program
        //the code would need to be copied with new values for small
        //and big

        //methods (aka functions) let you define reusable code

        //when you call (use) a method that returns data, you should
        //either save the return value to a variable or print it out
        //-ALSO, if there are parameters defined for the method,
        //pass (provide) values to the method call that match the
        //quantity and data types defined
        int sum4_8 = sumBetween(4, 8);
        System.out.println("sumBetween(4, 8) is " + sum4_8);

        //none of these method calls work bc the type/quantity
        //of values passed don't match the method definition
        //int sum = sumBetween(4);
        //int sum = sumBetween(2, 3, 4);
        //int sum = sumBetween(3.4, 8.9);

        //method calls that return can be placed directly in a
        //print statement
        System.out.println("sumBetween(5, 10) is " + sumBetween(5, 10));


        //if you don't save the returned value or print it out,
        //it gets lost (but the method DOES run)
        sumBetween(1, 10);

        System.out.println("5! is " + factorial(5));

        int x = 10;
        //variables that match the parameter data type can be passed
        //as arguments (value) to a method call
        System.out.println(factorial(x));

        //if a method returns data, it can be treated like a variable
        System.out.println(sumBetween(1, factorial(3)));

        //methods can be passed to other methods if the return type
        //of the passed method matches the data type of the param
        //for the other method
        //-factorial() returns an int, which is what sumBetween() needs

        print("jackson");

        //void methods can't be saved to variables bc there's no data produced
        //String fadsfadsg = print("something");

        //same - no return data from print()
        //System.out.println(print("something"));

        //the argument (value passed) doesn't match the parameter
        //type - defined as string
        //print(5);

        //concatenate an int to a string so the argument is a string
        print("" + 5);

        //same as
        String s = "" + 8;
        print(s);

        duckduckGoose();

        print("");

        System.out.println(coinFlipIsHeads());

        //methods that return a boolean can be plugged in directly
        //for if/while conditions
        //-(treated like a variable)
        if (coinFlipIsHeads() == true) {
            print("heads");
        }
        else {
            print("tails");
        }

    }


    //-for now, all methods start with public static
    //int is the return type - the method mst produce a value of the
    //defined type
    //-void is a valid return type, which means the method doesn't
    //return/produce any output data (like main())
    //-sumBetween is the method name
    //-small and big are parameters - like variables that get used
    //in the method that modify what the method does
    public static int sumBetween(int small, int big) {

        int sum = 0;
        //treat parameters like variables that already have values
        for (int i = small; i <= big; i++) {
            sum += i;
        }

        //the method must return an int value, as defined by the
        //return type in the method header
        return sum;
    }

    //factorial(n) is n * (n-1) * (n-2) * ... * 1;
    public static int factorial(int n) {
        int product = 1;
        for (int i = n; i > 0; i--) {
            product = i * product;
        }
        return product;
    }

    //void return means no data is returned/produced
    public static void print(String s) {

        //void methods shouldn't return any values
        //return -1;
        System.out.println(s);
    }

    //methods don't NEED to have parameters
    public static void duckduckGoose() {
        //print some random number of "duck", then print "goose"
        int rand = (int)(Math.random() * 10);
        for (int i = 0; i < rand; i++) {
            //methods can be called from other methods
            print("duck");
        }
        print("goose");
    }

    //simulate flipping a coin and return true if heads, false if tails
    public static boolean coinFlipIsHeads() {
        double r = Math.random();

        //-a method can only return one value
        //-when the first return statement is reached, no
        //following code will run

        if (r < 0.5) {
            return true;
        }

        //don't need an else statement for a coin flip bc there are
        //only two possible outcomes
        //-when the condition is false, that code gets skipped and
        //false (tails) gets returned
        return false;

    }

}
