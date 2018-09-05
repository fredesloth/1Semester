package personmany_group1;

public class Person {
    private String name;
    // association: --> 1 Group
    private Group group;

    public Person(String name, Group group) {
        this.name = name;
        this.setGroup(group);
    }

    @Override
    public String toString() {
        return name;
    }

    // -------------------------------------------------------------------------

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
