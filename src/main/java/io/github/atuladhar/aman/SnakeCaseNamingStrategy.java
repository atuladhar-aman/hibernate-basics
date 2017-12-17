package io.github.atuladhar.aman;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * @author Aman Tuladhar
 * @since 2017-12-17
 */
public class SnakeCaseNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        final String converteTableName = LOWER_CAMEL.to(LOWER_UNDERSCORE, name.getText());
        return new Identifier(converteTableName, name.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(
        Identifier name, JdbcEnvironment context
    ) {
        final String convertedColumnName = LOWER_CAMEL.to(LOWER_UNDERSCORE, name.getText());
        return new Identifier(convertedColumnName, name.isQuoted());
    }
}