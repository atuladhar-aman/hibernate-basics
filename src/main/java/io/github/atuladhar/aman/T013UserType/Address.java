package io.github.atuladhar.aman.T013UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aman Tuladhar
 * @since 2017-12-17
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
class Address {

    private String city;
    private String country;
}
