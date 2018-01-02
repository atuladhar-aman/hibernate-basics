package io.github.atuladhar.aman.T023MappingCustomCollectionEmbeddable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Parent;

/**
 * @author Aman Tuladhar
 * @since 2017-12-17
 */

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class Address {
    private String type;
    private String city;
    private String country;

    @Parent // if you want to have access to parent
    private User user;
}
