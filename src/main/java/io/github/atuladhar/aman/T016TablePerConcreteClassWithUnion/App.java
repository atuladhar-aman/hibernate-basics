package io.github.atuladhar.aman.T016TablePerConcreteClassWithUnion;

import static io.github.atuladhar.aman.HibernateUtil.execute;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {

    public static void main(String[] args) {
        execute(
            App.class.getPackage().getName(), session ->
            {
                final BaseUser baseUser = session.get(BaseUser.class, 1L);
            }
        );
    }
}
