package io.github.atuladhar.aman.T023MappingCustomCollectionEmbeddable;

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
                addr.setType("home");
                addr.setCity("KTM");
                addr.setCountry("NEPAL");
                Address addr2 = new Address();
                addr2.setType("home2");
                addr2.setCity("KTM2");
                addr2.setCountry("NEPAL2");

                user.getAddresses().add(addr);
                user.getAddresses().add(addr2);

                session.save(user);
            }
        );
    }
}
