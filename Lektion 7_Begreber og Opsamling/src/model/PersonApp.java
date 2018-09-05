package model;

public class PersonApp {

    public static void main(String[] args) {
        Person p = new Person("Bent", "Janus", "Christensen", 27, 12, 1990);
        p.printPerson();
        System.out.println("Initialer: " + p.getInit());
        System.out.println("Username: " + p.getUserName());

        System.out.println("Age: " + p.age(12, 9, 2014));
        // int year = 2014;
        // System.out.println("Er " + year + " skudår: " + p.leapYear(year));
        Person test = new Person("Frederik", "Sloth", "Stræde", 27, 05, 1993);
        test.printPerson();
        System.out.println("Age: " + test.age(19, 02, 2018));
        System.out.println(test.leapYear(2000));

    }
}
