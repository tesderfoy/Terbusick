package com.elj.Terbusick.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

import lombok.NoArgsConstructor;



@Entity
@Table(name = "mes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String text;

    private String tag;
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_id")
private User author;

    public Message(String text, String tag, User user){
        this.text= text;
        this.tag= tag;
        author = user;
    }
    public String getAuthorName(){
        return author!= null ? author.getUsername() :"<none>";
    }
}
