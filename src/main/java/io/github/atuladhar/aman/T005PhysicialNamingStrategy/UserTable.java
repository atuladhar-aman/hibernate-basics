package io.github.atuladhar.aman.T005PhysicialNamingStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aman Tuladhar
 * @since 2017-12-16
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;
}
