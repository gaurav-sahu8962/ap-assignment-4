import java.util.Scanner;

class Address {
    String city;
    String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}

class Employee implements Cloneable {
    int id;
    String name;
    Address address;

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // Shallow copy
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", City: " + address.city + ", State: " + address.state);
    }
}

public class shallow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter state: ");
        String state = scanner.nextLine();

        Address address = new Address(city, state);
        Employee emp1 = new Employee(id, name, address);

        try {

            Employee emp2 = (Employee) emp1.clone();

            System.out.println("\nBefore modification:");
            emp1.display();
            emp2.display();


            System.out.print("\nEnter new city for cloned employee: ");
            emp2.address.city = scanner.nextLine();

            System.out.println("\nAfter modifying emp2's address:");
            emp1.display();
            emp2.display();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}

