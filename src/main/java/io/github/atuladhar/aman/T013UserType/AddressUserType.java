package io.github.atuladhar.aman.T013UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

/**
 * @author Aman Tuladhar
 * @since 2017-12-17
 */
class AddressUserType implements UserType {

    @Override
    public int[] sqlTypes() {
        return new int[]{StandardBasicTypes.STRING.sqlType()};
    }

    @Override
    public Class returnedClass() {
        return Address.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(
        ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner
    ) throws HibernateException, SQLException {
        if (rs.wasNull()) {
            return null;
        }
        final String dbValue = rs.getString(names[0]);
        return convertToEntityAttribute(dbValue);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
        throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, StandardBasicTypes.STRING.sqlType());
        } else {
            st.setString(index, convertToDatabaseColumn((Address) value));
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return convertToDatabaseColumn((Address) value);
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        final String dbData = (String) cached;
        return convertToEntityAttribute(dbData);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    private Address convertToEntityAttribute(String dbData) {
        final String[] split = dbData.split(",");
        Address address = new Address();
        address.setCity(split[0]);
        address.setCountry(split[1]);
        return address;
    }

    private String convertToDatabaseColumn(Address attribute) {
        String dbValue = attribute.getCity() + "," + attribute.getCountry();
        return dbValue;
    }
}


