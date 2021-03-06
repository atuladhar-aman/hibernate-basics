package io.github.atuladhar.aman.T027OneToOne;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(
            App.class.getPackage().getName(), session ->
            {
                User user = new User();
                Address address = new Address();
                user.setAddress(address);

                session.save(address);
                session.save(user);
            }
        );
    }
}
