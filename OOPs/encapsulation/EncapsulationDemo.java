/*
==================================================
ENCAPSULATION
==================================================

Definition:
Encapsulation is the process of binding data and
methods into a single unit (class) and restricting
direct access to data using access modifiers.

In Simple Words:
Hide data and provide controlled access through
methods.

Why?
1. Data Security
2. Data Validation
3. Better Maintainability
4. Better Control over Data

Interview One-Liner:
"Encapsulation is achieved by making variables
private and providing controlled access through
public methods such as getters and setters."
==================================================


private variables
↓
Data is hidden

getters
↓
Read data

setters
↓
Modify data with validation

Result:
Data security + controlled access

*/

package encapsulation;
class Student {
    
    /*
     * Private variables
     * Direct access from outside the class is not allowed
         */
        private String name;
        private int age;

        /*
     * Constructor
     * Used to initialize object data
         */
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /*
     * Getter Method
     * Used to READ private data
         */
        public String getName() {
            return name;
        }

        /*
     * Setter Method
     * Used to MODIFY private data
         */
        public void setName(String name) {

            // Validation before updating data
            if (name != null && !name.isEmpty()) {
                this.name = name;
            } else {
                System.out.println("Invalid Name");
            }
        }

        /*
     * Getter for age
         */
        public int getAge() {
            return age;
        }

        /*
     * Setter for age
         */
        public void setAge(int age) {

            // Validation
            if (age > 0) {
                this.age = age;
            } else {
                System.out.println("Age cannot be negative");
            }
        }

        /*
     * Display Method
         */
        public void display() {
            System.out.println("Name : " + name);
            System.out.println("Age  : " + age);
        }
    }

    public class EncapsulationDemo {

        public static void main(String[] args) {

            /*
         * Creating Object
             */
            Student student = new Student("Arpit", 20);

            System.out.println("Initial Data");
            student.display();

            System.out.println();

            /*
         * Updating through Setter Methods
             */
            student.setName("Arpit Shukla");
            student.setAge(21);

            System.out.println("Updated Data");
            student.display();

            System.out.println();

            /*
         * Reading through Getter Methods
             */
            System.out.println(
                    "Name using Getter : "
                    + student.getName());

            System.out.println(
                    "Age using Getter  : "
                    + student.getAge());

            /*
         * Direct access is NOT allowed
             */
            // student.name = "XYZ"; // ERROR
            // student.age = 100;    // ERROR
        }
    }
