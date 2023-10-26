package com.justin.springbootmall.utils;
/*
    For a completely stateless utility class in Java:
    1. class be declared public and final, and have a private constructor to prevent instantiation.
    2. The final keyword prevents sub-classing and can improve efficiency at runtime.
    3. The class should contain all static methods
    4. Methods only used by the class itself should be private.
    5. The class should not have any non-final/non-static class fields.

    I would make the class final and every method would be static.
    So the class cannot be extended and the methods can be called by Classname.methodName.

    public final class ExampleUtilities {
        public static final String NAME = "utils' name";
        public static int add(int i, int j) {}
    }
 */
public final class ExampleUtilities {

    public static final String NAME = "utils' name";

    // Example Utility method
    public static int add(int i, int j) {
        int val;
        //Do stuff
        val = i+j;
        return val;
    }

    // Example Utility method overloaded
    public static float add(float i, float j) {
        float val;
        //Do stuff
        val = i+j;
        return val;
    }

    // Example Utility method calling private method
    public static long bar(int p) {
        return hid(p) * hid(p);
    }

    // Example private method
    private static long hid(int i) {
        return i * 2 + 1;
    }
}
