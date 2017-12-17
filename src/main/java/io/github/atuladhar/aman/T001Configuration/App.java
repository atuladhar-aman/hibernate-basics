package io.github.atuladhar.aman.T001Configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import io.github.atuladhar.aman.HibernateUtil;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory(App.class.getPackage().getName()).openSession();
        session.beginTransaction();

        final User user = new User();
        user.setName("hello");
        session.save(user);


        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
