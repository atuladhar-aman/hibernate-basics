package io.github.atuladhar.aman.T019TablePerSubclassWithJoin;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(
            App.class.getPackage().getName(), session ->
            {
                session.save(new User());
                session.save(new SecondUser());
            }, session -> {
                final BaseUser baseUser = session.get(BaseUser.class, 1L);
            }, session -> {
                final BaseUser baseUser = session.get(User.class, 1L);
            }, session -> {
                final BaseUser baseUser = session.get(SecondUser.class, 1L);
            }
        );
    }
}
