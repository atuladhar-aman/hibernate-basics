package io.github.atuladhar.aman.T018TablePerHirarchyChangeDiscriminatorValues;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Aman Tuladhar
 * @since 2017-12-31
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@DiscriminatorValue("second_user")
class SecondUser extends BaseUser {
    private String someProperties;
}
