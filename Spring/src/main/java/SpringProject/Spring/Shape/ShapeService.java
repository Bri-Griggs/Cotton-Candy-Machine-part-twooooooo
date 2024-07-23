package SpringProject.Spring.Shape;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShapeService {
    private final ShapeRepo shapeRepo;

    @Autowired
    public ShapeService(ShapeRepo shapeRepo){
        this.shapeRepo = shapeRepo;
    }

    public List<ShapeName> readAllShapes(){
        return shapeRepo.findAll();
    }

    public void addShapeName(ShapeName shapeName){
        shapeRepo.save(shapeName);
    }
    public void deleteShapeName(Long id){
        boolean exists = shapeRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Shape not found!");
        }
        shapeRepo.deleteById(id);
    }
    public void updateShapeName(String shapeName, Long id){
        ShapeName shapeInstance = shapeRepo.findById(id).orElseThrow(() -> new IllegalStateException("Shape not found"));
        if(shapeName!=null && !shapeName.isEmpty() && !Objects.equals(shapeInstance.getShapeName(),shapeName)){
            shapeInstance.setShapeName(shapeName);
        }
    }
}

