package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan birincil anahtar.
    private Long id;

    @Column(nullable = false, unique = true) // Ad alanı benzersiz ve boş olamaz.
    private String name;

    private String description; // Besin açıklaması.

    @ManyToMany(mappedBy = "foods", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // Disease ile Many-to-Many ilişki. Bu taraf ilişkiyi tersinden tanımlar (mappedBy).
    private Set<Disease> diseases = new HashSet<>(); // İlişkili hastalıklar.
}
