package io.github.atuladhar.aman.T025BiDirectionalMapping;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(
            App.class.getPackage().getName(), session ->
            {
                final College nccs = new College();
                nccs.setName("NCCS");

                final User user = new User();
                user.setName("GOGO");
                user.setCollege(nccs);

                nccs.getUsers().add(user);

                session.save(nccs);
                session.save(user);
            }, session -> {
                final User user = session.get(User.class, 1L);
            }, session -> {
                final College user = session.get(College.class, 1L);
            }
        );
    }
}
