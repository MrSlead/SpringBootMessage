package com.almod.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Scanner;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstname;

    @Column
    private String secondname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserLogin author;

    public User(String firstname, String secondname, UserLogin userLogin) {
        this.firstname = firstname;
        this.secondname = secondname;
        author = userLogin;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }
}
