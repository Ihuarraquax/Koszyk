import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FamilyTest {


    private Family family;
    private User user;

    @Before
    public void setUp() throws Exception {

        family = new Family("Zabłoccy");
        user = new User();
    }

    @Test
    public void shouldContainMembers() {

        family.addMember(user);

        Assert.assertTrue(family.getMembers().contains(user));
    }

    @Test
    public void shouldNotDuplicateMembers() {

        family.addMember(user);
        family.addMember(user);

        Assert.assertEquals(1, family.getMembers().size());
    }


}