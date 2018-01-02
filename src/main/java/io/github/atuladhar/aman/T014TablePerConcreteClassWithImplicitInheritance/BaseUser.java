package io.github.atuladhar.aman.T014TablePerConcreteClassWithImplicitInheritance;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aman Tuladhar
 * @since 2017-12-31
 */

@MappedSuperclass

@NoArgsConstructor
@AllArgsConstructor
@Data
class BaseUser {
    private Character gender;
    private Integer age;
}
