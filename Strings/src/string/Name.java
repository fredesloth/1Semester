package string;

public class Name {
    // Attributter Dette er et parameter (altså String firstName etc), kan også
    // kaldes felt variabler
    private String firstName;
    private String middleName;
    private String lastName;

    // Dette er constructoren, giver Name de forskellige navne
    public Name(String firstName, String middleName, String lastName) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;

        // Dette er en metode
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInt() {
        String result = String.valueOf(firstName.charAt(0)) + String.valueOf(middleName.charAt(0))
                + String.valueOf(lastName.charAt(0));
        return result;
    }

    public String getUserName() {
        // Dette er et lokal variabel
        String userFirstName = firstName.toUpperCase();
        String userLastName = lastName.toLowerCase();
        String userName = String.valueOf(userFirstName.substring(0, 2)) + String.valueOf(middleName.length())
                + String.valueOf(userLastName.charAt(userLastName.length() - 2))
                + String.valueOf(userLastName.charAt(userLastName.length() - 1));
        return userName;
    }

    public void printName() {
        System.out.println("**************************");
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
        System.out.println("Initialer: " + getInt());
        System.out.println("UserName " + getUserName());
    }

}
