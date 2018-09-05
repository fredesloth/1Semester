package model;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hans Jensen", 53, "Hans", "Jensen");
        e1.printEmployee();
        e1.setName("Viggo");
        e1.printEmployee();
        e1.setAge(32);
        e1.printEmployee();
        e1.birthday();
        e1.getLastName();
        e1.getFirstName();
        System.out.println("Tidligere alder: " + e1.getAge());
        Employee e2 = new Employee("Frederik Stræde", 24, "Stræde", "Frederik");
        e2.printEmployee();
        e2.getAge();
        e2.getLastName();
        e2.getFirstName();
        e2.birthday();
        e2.getAge();
        e2.printEmployee();
        e2.getAge();
    }

}
