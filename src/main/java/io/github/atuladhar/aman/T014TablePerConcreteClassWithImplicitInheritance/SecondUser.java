package io.github.atuladhar.aman.T014TablePerConcreteClassWithImplicitInheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Aman Tuladhar
 * @since 2017-12-31
 */

@Entity

@EqualsAndHashCode(callSuper = true)
@Data
class SecondUser extends BaseUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String someProperties;
}
