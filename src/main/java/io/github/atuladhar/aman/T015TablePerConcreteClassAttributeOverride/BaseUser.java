package io.github.atuladhar.aman.T015TablePerConcreteClassAttributeOverride;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Aman Tuladhar
 * @since 2017-12-31
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@MappedSuperclass
class BaseUser {
    private Character gender;
    private Integer age;
}
