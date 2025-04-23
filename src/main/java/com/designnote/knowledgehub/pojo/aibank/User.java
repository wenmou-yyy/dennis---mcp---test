package com.designnote.knowledgehub.pojo.aibank;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name="tb_user")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer userID;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="country")
    private String country;

}
