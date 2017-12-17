package io.github.atuladhar.aman.T003CustomTableName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "custom_table_name")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
