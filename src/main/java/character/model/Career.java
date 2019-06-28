package character.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Th'MASA of on 1/2/2017.
 */
@Entity
@Table(name = "career", schema = "", catalog = "legends")
public class Career implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "Career_Title")
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Career{" +
                "name='" + name + '\'' +
                '}';
    }
}
