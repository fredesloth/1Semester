package model;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
    /*
     * Attributter der beskriver den ansattes tilstand
     */
    private String name;
    private boolean trainee;
    private int age;
    private String lastName;
    private String firstName;

    /*
     * Constructor, når den ansatte oprettes, skal den have et navn. Ved oprettelse
     * er den ansatte en trainee
     */
    public Employee(String inputName, int inputAge, String inputLastName, String inputFirstName) {
        name = inputName;
        trainee = true;
        age = inputAge;
        lastName = inputLastName;
        firstName = inputFirstName;

    }

    /*
     * Den ansattes navn kan ændres ved kald af setName metoden
     */
    public void setName(String inputName) {
        name = inputName;
    }

    /*
     * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
     */
    public String getName() {
        return name;
    }

    /*
     * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
     */
    public void setTrainee(boolean isTrainee) {
        trainee = isTrainee;
    }

    /*
     * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
     * isTrainee
     */
    public boolean isTrainee() {
        return trainee;
    }

    // Denne giver dig alderen på den ansatte
    public int getAge() {
        return age;
    }

    public void setAge(int inputAge) {
        age = inputAge;
    }

    public void birthday() {
        age = age + 1;
    }

    public void setLastname(String inputLastName) {
        lastName = inputLastName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String inputFirstName) {
        firstName = inputFirstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("Name: " + name);
        System.out.println("Trainee: " + trainee);
        System.out.println(age);
        System.out.println("Last name: " + lastName);
        System.out.println("First name: " + firstName);
        System.out.println();
    }
}
