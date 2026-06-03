package aggreg;
/*
 * Wrapper Classes in Java


In Java, wrapper classes allow primitive data types to be represented as objects. This enables primitives to be used in object-oriented features such as collections, generics, and APIs that require objects.

    Each wrapper class encapsulates a corresponding primitive value inside an object (e.g., Integer for int, Double for double).
    Java provides wrapper classes for all eight primitive data types to support object-based operations.
 
 *Why Wrapper Classes Are Needed

Wrapper classes are required in Java for the following reasons:

    Java collections (ArrayList, HashMap, etc.) store only objects, not primitives.
    Wrapper objects allow primitives to be used in object-oriented features like 
    methods, synchronization, and serialization.
    Objects support null values, while primitives do not.
    Wrapper classes provide utility methods such as 
    compareTo(), equals(), and toString()
    Autoboxing and Unboxing
1. Autoboxing

The automatic conversion of primitive types to the object of 
their corresponding wrapper classes is known as autoboxing.
 *2. Unboxing

Unboxing is the automatic conversion of a wrapper class object 
back into its corresponding primitive type.
 */
class Wrapper {
    public static void main(String[] args) {

        byte b = 1;
        Byte byteObj = Byte.valueOf(b);

        int i = 10;
        Integer intObj = Integer.valueOf(i);

        float f = 18.6f;
        Float floatObj = Float.valueOf(f);

        double d = 250.5;
        Double doubleObj = Double.valueOf(d);

        char c = 'a';
        Character charObj = c; // autoboxing

        System.out.println("Wrapper Objects:");
        System.out.println(byteObj);
        System.out.println(intObj);
        System.out.println(floatObj);
        System.out.println(doubleObj);
        System.out.println(charObj);

        // Unboxing
        byte bv = byteObj;
        int iv = intObj;
        float fv = floatObj;
        double dv = doubleObj;
        char cv = charObj;

        System.out.println("\nUnwrapped values:");
        System.out.println(bv);
        System.out.println(iv);
        System.out.println(fv);
        System.out.println(dv);
        System.out.println(cv);
    }
}
