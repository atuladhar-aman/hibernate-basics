package io.github.atuladhar.aman.T022MappingMap;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(
            App.class.getPackage().getName(), session ->
            {
                final User
                    user = new User();
                user.setName("USER");
                user.getSampleMap()
                    .put("k1", "v1");
                session.save(user);
            }
        );
    }
}
