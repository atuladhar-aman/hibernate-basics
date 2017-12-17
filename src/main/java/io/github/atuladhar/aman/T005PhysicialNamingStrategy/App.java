package io.github.atuladhar.aman.T005PhysicialNamingStrategy;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(App.class.getPackage().getName(), session ->
            {
                final UserTable userTable = new UserTable();
                userTable.setFirstName("hello");
                session.save(userTable);
            }
        );
    }
}
