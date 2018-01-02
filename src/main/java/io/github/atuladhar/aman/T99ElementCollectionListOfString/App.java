package io.github.atuladhar.aman.T99ElementCollectionListOfString;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import java.util.Arrays;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(
            App.class.getPackage().getName(), session ->
            {
                final User user = new User();
                user.setName("USER");
                user.setAddress(Arrays.asList("a1", "a2"));
                session.save(user);
            }, session -> {
                final User user = session.get(User.class, 1L);
                System.out.println(user);
                session.delete(user);
            }
        );
    }
}
