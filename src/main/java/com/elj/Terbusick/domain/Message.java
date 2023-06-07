package com.elj.Terbusick.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

import lombok.NoArgsConstructor;



@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String text;

    private String tag;

    public Message(String text, String tag){
        this.text= text;
        this.tag= tag;
    }
}
