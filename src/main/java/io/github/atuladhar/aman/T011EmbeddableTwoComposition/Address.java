package io.github.atuladhar.aman.T011EmbeddableTwoComposition;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aman Tuladhar
 * @since 2017-12-17
 */

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class Address {
    private String city;
    private String country;
}
