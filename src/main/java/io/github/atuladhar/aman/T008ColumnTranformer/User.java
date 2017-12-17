package io.github.atuladhar.aman.T008ColumnTranformer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.ColumnTransformer;

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


    @ColumnTransformer(
        read = "height_in_inches / 2", // convert db values to object value
        write = "? * 2" // convert object value to db value
    )
    private Long heightInInches;
}
