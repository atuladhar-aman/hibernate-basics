package io.github.atuladhar.aman.T011EmbeddableTwoComposition;

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
                addr.setCountry("NEPAL");

                Address addr2 = new Address();
                addr.setCity("Pokhara");
                addr.setCountry("NPL");

                user.setHomeAddress(addr);
                user.setWorkAddress(addr2);

                session.save(user);
            }
        );
    }
}
