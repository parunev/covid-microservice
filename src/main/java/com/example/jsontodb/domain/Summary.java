package com.example.jsontodb.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Summary {
    @Id
    private String id;
    private String message;
    @Embedded
    private Global global;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Country> countries;
}
