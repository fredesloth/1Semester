package personmany_group1;

public class TestP0mG1 {

    public static void main(String[] args) {
        Group g1 = new Group("G1");
        Group g2 = new Group("G2");

        // Before: No connections
        // After: g1 <-- p1, g2 <-- g2
        Person p1 = new Person("P1", g1);
        Person p2 = new Person("P2", g2);

        System.out.println("Test 1:");
        System.out.println(p1.getGroup() == g1);
        System.out.println(p2.getGroup() == g2);

        // Before: g1 <-- p1, g2 <-- p2
        // After: g2 <-- p1, g2 <-- p2
        p1.setGroup(null); // can be omitted
        p1.setGroup(g2);

        System.out.println("Test 2:");
        System.out.println(p1.getGroup() == g2);
        System.out.println(p2.getGroup() == g2);

        // Before: g2 <-- p1, g2 <-- p2
        // After: g2 <-- p1, g1 <-- p2
        p2.setGroup(null); // can be omitted
        p2.setGroup(g1);

        System.out.println("Test 3:");
        System.out.println(p1.getGroup() == g2);
        System.out.println(p2.getGroup() == g1);

        // Before: g2 <-- p1, g1 <-- p2
        // After: g2 <-- p1 and p2
        p2.setGroup(null); // can be omitted
        p2.setGroup(g2);

        System.out.println("Test 4:");
        System.out.println(p1.getGroup() == g2);
        System.out.println(p2.getGroup() == g2);
    }

}
