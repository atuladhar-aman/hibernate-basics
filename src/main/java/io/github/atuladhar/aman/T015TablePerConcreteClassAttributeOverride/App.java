package io.github.atuladhar.aman.T015TablePerConcreteClassAttributeOverride;

import static io.github.atuladhar.aman.HibernateUtil.execute;

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

                session.save(user);
            }
        );
    }
}
