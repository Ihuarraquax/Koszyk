import java.util.*;

public class Family {
    private String name;
    private Set<User> members;

    public Family(String name) {
        this.name = name;
        members = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMember(User user) {
        members.add(user);
    }

    public Collection<User> getMembers() {
        return members;
    }
}
