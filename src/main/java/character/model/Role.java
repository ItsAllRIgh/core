package character.model;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "role")
public class Role {
    private Long id;
    private String name;

    public Role() {
    }

    private Set<User> users = new TreeSet<>();

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    public Role(String name, User user) {
        this.name = name;
        this.users.add(user);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}