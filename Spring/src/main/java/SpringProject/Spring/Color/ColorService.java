package SpringProject.Spring.Color;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ColorService {
    private final ColorRepo colorRepo;

    @Autowired
    public ColorService(ColorRepo ColorRepo){
        this.colorRepo = ColorRepo;
    }

    public List<ColorName> readAllColors(){
        return colorRepo.findAll();
    }

    public ColorName getSingleColor(Long id){
        return colorRepo.findById(id).orElseThrow(() -> new IllegalStateException("Color not found"));
    }

    public void addColorName(ColorName ColorName){
        colorRepo.save(ColorName);
    }
    public void deleteColorName(Long id){
        boolean exists = colorRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Color not found!");
        }
        colorRepo.deleteById(id);
    }

    @Transactional
    public void updateColorName(String ColorName, Long id){
        ColorName ColorInstance = colorRepo.findById(id).orElseThrow(() -> new IllegalStateException("Color not found"));
        if(ColorName!=null && !ColorName.isEmpty() && !Objects.equals(ColorInstance.getColorName(),ColorName)){
            ColorInstance.setColorName(ColorName);
        }
    }

    public ColorName getColorName(Long id){
        return colorRepo.findById(id).orElseThrow(() -> new IllegalStateException("Color not found"));
    }

}

