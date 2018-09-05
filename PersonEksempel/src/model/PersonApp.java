package model;

public class PersonApp {

    public static void main(String[] args) {

        Person Frederik = new Person("Frederik", "Tordenskjoldsgade", 5300);
        Frederik.getYearlySalery();
        Frederik.printPerson();

        Person Julie = new Person("Julie", "Søndre Ringgade", 10000);
        Julie.printPerson();

        Person test = new Person(null, null, 0);
        test.setAdress("Danmarks Gade");
        test.setMonthlySalery(1235);
        test.setName("Peter Lund Madsen");
        test.printPerson();

    }

}
