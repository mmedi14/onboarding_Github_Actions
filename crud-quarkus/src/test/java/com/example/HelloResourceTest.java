package com.example;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import com.example.HelloResource.User;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
// esto es un cambio de prueba


@QuarkusTest
public class HelloResourceTest {
    @Test
    public void testGetUsers() {
        // Given
        User user1 = new User();
        user1.setId((long) 13579);
        user1.setName("Alice");
        user1.setEmail("alice@example.com");
        HelloResource.users.add(user1);

        User user2 = new User();
        user2.setId((long) 2345678);
        user2.setName("Bob");
        user2.setEmail("bob@example.com");
        HelloResource.users.add(user2);

        // When
        List<User> result = HelloResource.getUsers();

        // Then
        assertThat(result.size(), equalTo(2));
        assertThat(result.get(0).getName(), equalTo("Alice"));
        assertThat(result.get(1).getName(), equalTo("Bob"));
    }
}
