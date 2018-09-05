package student;

/**
 * Class describing a student
 *
 */
public class Student {
    private String name;
    private boolean active;
    private int age;
    private int CPR;

    /**
     * Create an inactive student.
     */
    public Student(String name, int age, int CPR) {
        this.name = name;
        this.age = age;
        this.CPR = CPR;
        this.active = false;
    }

    /**
     * Create a student where 'active' is given as a parameter
     */
    public Student(String name, int age, int CPR, boolean active) {
        this.name = name;
        this.age = age;
        this.CPR = CPR;
        this.active = active;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public int getCPR() {
        return CPR;
    }

    public void setCPR(int CPR) {
        this.CPR = CPR;
    }

    /**
     * Increase the age of the student by 1 year.
     */
    public void increaseAge() {
        age++;
    }

    @Override
    public String toString() {
        return "Name: \t" + name + "\n Age: \t" + age + "\n + Active: \t " + active + "\n CPR-Nummer: " + CPR;
    }
}
