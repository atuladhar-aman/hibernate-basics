package io.github.atuladhar.aman.T026Cascading;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Aman Tuladhar
 * @since 2018-01-06
 */

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    @Setter(AccessLevel.PRIVATE)
    private List<User> users = new ArrayList<>();
}
