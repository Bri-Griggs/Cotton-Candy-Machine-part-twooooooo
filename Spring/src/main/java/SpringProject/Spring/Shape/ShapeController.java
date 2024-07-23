package SpringProject.Spring.Shape;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ShapeController {
    private final ShapeService shapeService;

    @Autowired
    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping("/cottoncandies")
    public List<ShapeName> getShapes() {
        return shapeService.readAllShapes();
    }

    @PostMapping("/newshape")
    public void postShape(@RequestBody ShapeName shapeName) {
        shapeService.addShapeName(shapeName);
    }

    @DeleteMapping("/delshape/{shapeId}")
    public void deleteShape(@PathVariable("shapeId") Long shapeId) {
        shapeService.deleteShapeName(shapeId);
    }

    @PutMapping("/putshape/{shapeId}")
    public void updateShape(@PathVariable("shapeId") Long shapeId,
                            @RequestParam(required = false) String shapeName) {
        shapeService.updateShapeName(shapeName, shapeId);
    }
}
