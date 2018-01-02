package io.github.atuladhar.aman.T017TablePerHirarchy;

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
            }
        );
    }
}
