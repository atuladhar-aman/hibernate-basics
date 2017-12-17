package io.github.atuladhar.aman.T006DynamicInsertUpdate;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(App.class.getPackage().getName(), session ->
            {
                final User user = new User();
                user.setFirstName("fname");
                session.save(user);
            }, session ->
            {
                final User user = session.get(User.class, 1L);
                user.setLastName("lname");
                session.update(user);
            }
        );
    }
}
