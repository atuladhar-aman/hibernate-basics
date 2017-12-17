package io.github.atuladhar.aman.T013UserType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

/**
 * @author Aman Tuladhar
 * @since 2017-12-16
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs({
    @TypeDef(name = "address_type", typeClass = AddressUserType.class)
})
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Type(type = "address_type")
    private Address homeAddress;
}
