package SpringProject.Spring.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ColorService {
    private final ColorRepo colorRepo;

    @Autowired
    public ColorService(ColorRepo colorRepo){
        this.colorRepo = colorRepo;
    }

    public List<ColorName> readAllColors(){
        return colorRepo.findAll();
    }

    public void addColorName(ColorName colorName){
        colorRepo.save(colorName);
    }
    public void deleteColorName(Long id){
        boolean exists = colorRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Color not found!");
        }
        colorRepo.deleteById(id);
    }
    public void updateColorName(String colorName, Long id){
        ColorName colorInstance = colorRepo.findById(id).orElseThrow(() -> new IllegalStateException("Color not found"));
        if(colorName!=null && !colorName.isEmpty() && !Objects.equals(colorInstance.getColorName(), colorName)){
            colorInstance.setColorName(colorName);
        }
    }
}
