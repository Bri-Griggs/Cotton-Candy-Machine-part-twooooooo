package SpringProject.Spring.CottonCandy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CottonCandyService {
    private final CottonCandyRepo candyRepo;

    @Autowired
    public CottonCandyService(CottonCandyRepo candyRepo) {
        this.candyRepo = candyRepo;
    }

    public List<CottonCandy> getAllCottonCandy(){
        return candyRepo.findAll();
    }
    public void addCottonCandy(CottonCandy cottonCandy){
        candyRepo.save(cottonCandy);
    }
    public void deleteCottonCandy(Long id){
        boolean exists = candyRepo.existsById(id);
        if (!exists){
            throw new IllegalStateException("Cotton candy not found");
        }
        candyRepo.deleteById(id);
    }
    public void updateCottonCandyColor(Long id, String color){
       CottonCandy candyInstance = candyRepo.findById(id).orElseThrow(()->new IllegalStateException("Cotton Candy not found!"));
       if(color!=null && !color.isEmpty() && !Objects.equals(candyInstance.getColor(), color)){
           candyInstance.setColor(color);
        }

    }
}
