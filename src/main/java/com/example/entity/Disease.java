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
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan birincil anahtar.
    private Long id;

    @Column(nullable = false, unique = true) // Ad alanı benzersiz ve boş olamaz.
    private String name;

    private String description; // Hastalık açıklaması.

    @ManyToMany(cascade = CascadeType.PERSIST) // Cascade ile otomatik olarak ilişkili nesneleri kaydetme.
    @JoinTable( // Ara tablo oluşturuluyor.
            name = "food_disease", // Ara tablonun adı.
            joinColumns = @JoinColumn(name = "disease_id"), // Bu tablodaki hastalık sütunu.
            inverseJoinColumns = @JoinColumn(name = "food_id") // İlişkili besin sütunu.
    )
    private Set<Food> foods = new HashSet<>(); // İlişkili besinler.
}
