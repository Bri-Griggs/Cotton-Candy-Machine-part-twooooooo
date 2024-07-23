package SpringProject.Spring.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorController {
    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/cottoncandies")
    public List<ColorName> getColors() {
        return colorService.readAllColors();
    }

    @PostMapping("/newcolor")
    public void postColor(@RequestBody ColorName colorName) {
        colorService.addColorName(colorName);
    }

    @DeleteMapping("/delcolor/{colorId}")
    public void deleteColor(@PathVariable("colorId") Long colorId) {
        colorService.deleteColorName(colorId);
    }

    @PutMapping("/putcolor/{colorId}")
    public void updateColor(@PathVariable("colorId") Long colorId,
                            @RequestParam(required = false) String colorName) {
        colorService.updateColorName(colorName, colorId);
    }
}
