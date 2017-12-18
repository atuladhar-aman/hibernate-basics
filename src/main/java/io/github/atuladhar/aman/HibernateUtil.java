package io.github.atuladhar.aman;

import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.cfg.AvailableSettings.FORMAT_SQL;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.PHYSICAL_NAMING_STRATEGY;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.STORAGE_ENGINE;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Aman Tuladhar
 * @since 2017-12-16
 */
public class HibernateUtil {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static void execute(String packageToScan, Consumer<Session>... consumers) {
        for (final Consumer<Session> consumer : consumers) {
            final Session session = getSessionFactory(packageToScan).openSession();
            session.beginTransaction();

            consumer.accept(session);

            session.getTransaction().commit();
            session.close();
        }
        shutdown();
    }

    public static SessionFactory getSessionFactory(String packageToScan) {
        if (sessionFactory == null) {
            try {

                // Create registry builder
                final StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                final Map<String, String> settings = new HashMap<>();
                settings.put(URL, "jdbc:mysql://localhost:3306/temp_hibernate");
                settings.put(USER, "root");
                settings.put(PASS, "");
                settings.put(DIALECT, "org.hibernate.dialect.MySQL55Dialect");
                settings.put(HBM2DDL_AUTO, "create-drop");
                settings.put(SHOW_SQL, "true");
                settings.put(FORMAT_SQL, "true");
                settings.put(STORAGE_ENGINE, "innodb");

                settings.put(PHYSICAL_NAMING_STRATEGY, "io.github.atuladhar.aman.SnakeCaseNamingStrategy");

                // Apply settings
                registryBuilder.applySettings(settings);

                // Create registry
                registry = registryBuilder.build();

                // Create MetadataSources
                final MetadataSources sources = new MetadataSources(registry);
                // autoscan packages for Entities
                final List<Class<?>> result = EntityScanner.scanPackages(packageToScan).result();
                for (Class<?> aClass : result) {
                    sources.addAnnotatedClass(aClass);
                }

                // Create Metadata
                final Metadata metadata = sources.getMetadataBuilder()
                    .build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}