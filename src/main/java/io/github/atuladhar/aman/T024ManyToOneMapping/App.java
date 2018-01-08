package io.github.atuladhar.aman.T024ManyToOneMapping;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(
            App.class.getPackage().getName(), session ->
            {
                final College nccs = College.builder()
                    .name("NCCS")
                    .build();
                session.save(nccs);

                final User user = User.builder()
                    .college(nccs)
                    .name("BOB")
                    .build();

                session.save(user);
            }, session -> {
                final User user = session.get(User.class, 1L);
            }
        );
    }
}
