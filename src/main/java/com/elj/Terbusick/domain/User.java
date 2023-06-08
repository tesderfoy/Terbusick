package com.elj.Terbusick.domain;

import com.elj.Terbusick.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Long id;
    @Column(name = "username", unique = true)
    private  String username;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch =  FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name ="user_id" ))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

}

