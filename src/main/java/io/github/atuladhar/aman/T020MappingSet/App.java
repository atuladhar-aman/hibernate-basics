package io.github.atuladhar.aman.T020MappingSet;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import com.google.common.collect.Sets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(
            App.class.getPackage().getName(), session ->
            {
                final User
                    user = new User();
                user.setName("USER");
                user.setAddress(Sets.newHashSet("a","b"));
                session.save(user);
            }, session -> {
                final User
                    user = session.get(User.class, 1L);
                System.out.println(user);
                session.delete(user);
            }
        );
    }
}
