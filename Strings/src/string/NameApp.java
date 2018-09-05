package string;

public class NameApp {

    public static void main(String[] args) {
        Name Frederik = new Name("Frederik", "Sloth", "Stræde");
        Frederik.printName();
        Name Julie = new Name("Julie", "Høgh", "Poulsen");
        Julie.printName();
        Name test = new Name("Lars", "Løkke", "Rasmussen");
        test.printName();
    }

}
