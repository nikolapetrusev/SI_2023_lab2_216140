import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void test1() {//Every branch test 1
        assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
    }

    @Test
    void test2() {//Every branch test 2
        User user = new User (null, "password", "nikola at mail com");
        assertFalse(SILab2.function(user, null));
    }

    @Test
    void test3() {//Every branch test 3
        User user = new User("nikola", "pas##", "nikola@mail.com");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("nikola", "neSeSovpagja", "mailNeEIsti@mail.com"));
        allUsers.add(new User("nikola", "pas##", "nikola@mail.com"));
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void test4() {//Every branch test 4
        User user = new User("nikola", "pass word##", "nikola@mail.com");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("nikola", "password##", "nikola@mail.com"));
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void test5() {//Multiple conditions test 1
        test1();
    }

    @Test
    void test6() {//Multiple conditions test 2
        assertThrows(RuntimeException.class, () -> SILab2.function(
                new User("charshav", null, "nikola@mail.com"), null
        ));
    }

    @Test
    void test7() {//Multiple conditions test 3
        assertThrows(RuntimeException.class, () -> SILab2.function(
                new User("charshav", "password##", null), null
        ));
    }

    @Test
    void test8() {//Multiple conditions test 4
        assertDoesNotThrow(() -> SILab2.function(
                new User("charshav", "password##", "nikola mail.com"), null //email bez "@" za da izbegne nullPointerException
        ));

    }
}