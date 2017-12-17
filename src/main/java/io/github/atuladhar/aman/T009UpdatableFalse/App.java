package io.github.atuladhar.aman.T009UpdatableFalse;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(App.class.getPackage().getName(), session ->
            {
                final User user = new User();
                user.setName("USER");
                user.setCreationDate(LocalDate.now());
                session.save(user);
            }, session ->
            {
                final User user = session.get(User.class, 1L);
                user.setName("Updated User");
                user.setCreationDate(LocalDate.now().minus(10, ChronoUnit.DAYS));
                System.out.println("After Setting: " + user);
                session.update(user);

                session.refresh(user); // sync db values and object values
                System.out.println("After Refresh: " + user);
            }, session ->
            {
                // checking again on new session
                final User user = session.get(User.class, 1L);
                System.out.println("Fetching " + user);
            }
        );
    }
}
