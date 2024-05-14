package com.samsung.srok.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authority")
public class Authority implements GrantedAuthority {

    @Id
    @Column(name = "id", nullable = false)
    private String id = generateRandomId();

    @Column(name = "authority")
    private String authority;

    private String generateRandomId() {
        int length = 12;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            sb.append(randomChar);
        }
        return sb.toString();
    }
}