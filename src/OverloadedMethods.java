public class OverloadedMethods {
    //string methods
    //length() - int - number of chars in the string
    //equals(String s) - boolean - check for equality with a different string
    //substring(int a) - string - takes part of a string where a is the starting index
    //substring(int a, int b) - string - takes part of a string including a, excluding b

    //indexOf(String s) - int - returns the index of the first occurrence of the
    //substring s in the original string, returns -1 if s isn't in the string
    public static void main(String [] args) {
        System.out.println("index of a in banana is:" );
        System.out.println("banana".indexOf("a"));

        //when the substring to search for is more than one char, the returned
        //value is just the starting index where the substring is found
        System.out.println("index of na in banana is:" );
        System.out.println("banana".indexOf("na"));

        //indexOf() returns -1 if the substring isn't found in the string
        System.out.println("index of p in banana is:" );
        System.out.println("banana".indexOf("p"));

        System.out.println();

        //compareTo(String s) - returns int
        //used for sequencing strings (alphabetizing or sorting)
        //a.compareTo(b)
        //returns negative if a comes before b alphabetically
        //-positive if a comes AFTER b
        //-zero if a is the same as b

        //tape comes before word - returns positive
        System.out.println("word".compareTo("tape"));

        //word comes after tape - returns negative
        System.out.println("tape".compareTo("word"));

        //both strings are the same - returns 0
        System.out.println("tape".compareTo("tape"));

        //only pay attention to the sign of the number or if it's zero
        //the actual value of the number doesn't matter
        System.out.println("tape".compareTo("tater"));

        //sequentially, all uppercase letters come before all lowercase letters
        //-assume case is consistent when using compareTo
        System.out.println("Z".compareTo("a"));

        //reading left to right for compareTo - if the words are already in order
        //negative is returned, if they are out of order positive is returned


        //there are two versions of the substring method - one takes one int,
        //the other takes two ints as arguments
        //substring() is an overloaded method - multiple versions of the same
        //method name, but with differing parameters
        System.out.println("banana".substring(2));
        System.out.println("banana".substring(0, 2));

        System.out.println();

        //the program knows which version of the method to run based on how many
        //arguments (values) that you pass when you call the method
        System.out.println(max(10, 8));

        System.out.println(max(10, 20, 5));


        print("something");
        print(""+5);
        //call overloaded version with int param
        print(5);
    }

    //return the value of whichever param is bigger
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        else
            return b;
    }


    //overloaded version of max() - this one accepts 3 int params
    public static int max(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > a && b > c)
            return b;
        return c;
    }

    //doesn't work bc the two int params already exist in a different
    //overloaded version
    //when you overload a method, each version needs a different signature
    //a method signature refers to the quanity and seuquence of params

//    public static int max(int c, int d) {
//        if (c > d) {
//            return c;
//        }
//        else
//            return d;
//    }

    //valid bc one of the params is now a double
    public static int max(double a, int b) {
        if (a > b) {
            return (int)a;
        }
        else
            return b;
    }

    //also valid - sequence of param types is different
    public static int max(int a, double b) {
        if (a > b) {
            return (int)a;
        }
        else
            return (int) b;
    }

    public static int max(int a, int b, int c, int d) {
        //you can call other versions of the overloaded method from a different version

        //call the version with 3 params
        int firstMax = max(a, b, c);

        //compare the biggest number of a, b, c to d - call the version with two params
        int finalMax = max(firstMax, d);

        return finalMax;
    }

    public static void print(String s) {
        System.out.println(s);
    }

    //overload so you can pass an int to print()
    public static void print(int i) {
        System.out.println(i);
    }
}
