package io.github.atuladhar.aman.T013UserType;

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

                Address addr = new Address();
                addr.setCity("KTM");
                addr.setCountry("NPL");

                user.setHomeAddress(addr);

                session.save(user);
            }, session -> {
                final User user = session.get(User.class, 1L);
                System.out.println(user);
            }
        );
    }
}
