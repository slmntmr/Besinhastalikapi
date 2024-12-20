package com.example.initializer;

import com.example.entity.Disease;
import com.example.entity.Food;
import com.example.repository.DiseaseRepository;
import com.example.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final FoodRepository foodRepository; // Food veri erişim katmanı.
    private final DiseaseRepository diseaseRepository; // Disease veri erişim katmanı.

    @Override
    public void run(String... args) {
        // Yeni bir hastalık (Disease) nesnesi oluşturuluyor.
        Disease cold = new Disease();
        cold.setName("Soğuk Algınlığı");
        cold.setDescription("Grip benzeri bir hastalık.");
        cold.setFoods(new HashSet<>()); // foods seti başlatılıyor.

        // Yeni bir başka hastalık (Disease) nesnesi oluşturuluyor.
        Disease migraine = new Disease();
        migraine.setName("Migren");
        migraine.setDescription("Şiddetli baş ağrısı.");
        migraine.setFoods(new HashSet<>()); // foods seti başlatılıyor.

        // Yeni bir besin (Food) nesnesi oluşturuluyor.
        Food ginger = new Food();
        ginger.setName("Zencefil");
        ginger.setDescription("Soğuk algınlığına iyi gelir.");
        ginger.setDiseases(new HashSet<>()); // diseases seti başlatılıyor.

        // Yeni bir başka besin (Food) nesnesi oluşturuluyor.
        Food fishOil = new Food();
        fishOil.setName("Balık Yağı");
        fishOil.setDescription("Migrene iyi gelir.");
        fishOil.setDiseases(new HashSet<>()); // diseases seti başlatılıyor.

        // İlişkiler kuruluyor.
        ginger.getDiseases().add(cold); // Zencefil -> Soğuk Algınlığı
        fishOil.getDiseases().add(migraine); // Balık Yağı -> Migren

        cold.getFoods().add(ginger); // Soğuk Algınlığı -> Zencefil
        migraine.getFoods().add(fishOil); // Migren -> Balık Yağı

        // Veritabanına kaydediliyor.
        // İlk önce hastalıkları kaydet (Cascade ile ilişkili besinler otomatik kaydedilecek).
        diseaseRepository.save(cold);
        diseaseRepository.save(migraine);

        // Daha sonra besinleri kaydet.
        foodRepository.save(ginger);
        foodRepository.save(fishOil);
    }
}
