package character.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import java.util.*;

/**
 * Created by Th'MASA of on 1/7/2017.
 */
@Entity

public class User implements Comparable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4681998842214743584L;

    @Id
    @Column(name = "username")
    public String userName;
    @Column (name = "starfish")
    private String password;
    @Column (name = "password")
    private String publickey = UUID.randomUUID().toString();
    @OneToMany
    public List<Player> players;
    @Column
    private boolean hasAuthorities;
    @Column(name = "characterService")
    private String auth;
    @Transient
    private ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    private String passwordConfirm;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        //super(username, password, authorities);
    }

    public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        //super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public User(){
        //super("username", "password", new ArrayList<GrantedAuthority>());
    }
    public Collection<GrantedAuthority> getAuthorities() {return authorities;}
    public boolean isAccountNonExpired() { return false;}
    public boolean isAccountNonLocked() { return false; }
    public boolean isCredentialsNonExpired() {return false; }
    public boolean isEnabled() {
        // We don't have an enabled/active field in our DB, all users are always enabled.
        return false;
    }

    public boolean isHasAuthorities() {
        this.hasAuthorities = !authorities.isEmpty();
        return hasAuthorities;
    }

    public boolean hasAuthorities() {
        return hasAuthorities;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setHasAuthorities(boolean hasAuthorities) {
        this.hasAuthorities = hasAuthorities;
    }

    public void setUserAuthorities(List<String> roles) {
        List<String> listOfAuthorities = new ArrayList< String>();
        for (String role : roles) {
            listOfAuthorities.add(new String(role));
        }
        authorities = new ArrayList(listOfAuthorities);
    }


    public String getUserName() {
        return userName;
    }
    public String getusername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public void setAuthorities(ArrayList<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    @Override
    public int compareTo(Object o) {
        User cast = null;
        try{
            cast = (User)o;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        if(cast != null && this.userName != null && this.passwordConfirm != null){
            if(!cast.getUsername().equals(this.userName)){
                return -1;
            }
            if(!cast.getPasswordConfirm().equals(this.passwordConfirm)){
                return -1;
            }
            return 0;
        }else{
            return 1;
        }
    }
}
