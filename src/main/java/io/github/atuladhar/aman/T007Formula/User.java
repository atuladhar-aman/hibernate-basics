package io.github.atuladhar.aman.T007Formula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Formula;

/**
 * @author Aman Tuladhar
 * @since 2017-12-16
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long heightInInches;

    @Formula("height_in_inches * 2") // random conversion
    @Setter(AccessLevel.PRIVATE) // user cannot set height on centimeter
    private Long heightInCentimeter;
}
