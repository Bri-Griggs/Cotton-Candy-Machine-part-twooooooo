package SpringProject.Spring.CottonCandy;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CottonCandyService {
    private final CottonCandyRepo candyRepo;

    @Autowired
    public CottonCandyService(CottonCandyRepo cottonCandyRepository) {
        this.candyRepo = cottonCandyRepository;
    }

    public CottonCandy getCottonCandy(Long id) {
        return candyRepo.findById(id).orElseThrow(() -> new IllegalStateException("Cotton candy with id " + id + " does not exist"));
    }

    public List<CottonCandy> getCottonCandies() {
        return candyRepo.findAll();
    }

    public CottonCandy getCottonCandyById(Long id) {
        return candyRepo.findById(id).orElseThrow(() -> new IllegalStateException("Cotton candy with id " + id + " does not exist"));
    }

    public void addCottonCandy(CottonCandy cottonCandy) {
        candyRepo.save(cottonCandy);
    }

    public void deleteCottonCandy(Long id) {
        boolean exists = candyRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Cotton candy with id " + id + " does not exist");
        }
        candyRepo.deleteById(id);
    }

    @Transactional
    public void updateCottonCandy(Long id, String shape) {
        CottonCandy candy = candyRepo.findById(id).orElseThrow(() -> new IllegalStateException("Cotton candy with id " + id + " does not exist"));
        if(shape != null && !shape.isEmpty() && !Objects.equals(candy.getShape(), shape)) {
            candy.setShape(shape);
        }
    }

}