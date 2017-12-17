package io.github.atuladhar.aman.T012AttributeConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Aman Tuladhar
 * @since 2017-12-17
 */
@Converter(autoApply = true)
class AddressConverter implements AttributeConverter<Address, String> {

    @Override
    public String convertToDatabaseColumn(Address attribute) {
        String dbValue = attribute.getCity() + "," + attribute.getCountry();
        return dbValue;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public Address convertToEntityAttribute(String dbData) {
        final String[] split = dbData.split(",");
        Address address = new Address();
        address.setCity(split[0]);
        address.setCountry(split[1]);
        return address;
    }
}