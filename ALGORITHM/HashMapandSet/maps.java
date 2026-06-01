package ALGORITHM.HashMapandSet;
import java.util.HashMap; 

// HashMap -> A HashMap is a data structure that stores key-value pairs. 
// It allows for fast retrieval of values based on their corresponding keys.
// The keys in a HashMap are unique, and each key maps to a single value. 
// HashMaps provide constant-time performance for basic operations like get and put, making them efficient for storing and retrieving data.

// ---- SKELTON CODE FOR HASHMAP DEMO ----
// HashMap<String (key), Integer (value)> map = new HashMap<>();
// map.put("key1", value1);
// map.put("key2", value2);
// System.out.println(map.get("key1")); // Output: value1

public class maps {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);
        System.out.println("Alice's age: " + map.get("Alice")); // Output: 30
        System.out.println("Bob's age: " + map.get("Bob")); // Output: 25
        System.out.println("Charlie's age: " + map.get("Charlie")); // Output:

        System.out.println("=======================AB ITERATION KI BAARI=======================================");
        // IMPORTANT -> HashMap me order maintain nhi hota isliye jab hum iterate krenge to order random hoga
        // NOrmal for loop se iterate krne ke liye hume keySet() method ka use krna padega jo hume keys ki set provide karega aur fir hum get() method ka use krke us key ki value ko access kr sakte hai
        // skelton code for iterating over HashMap

        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
}
