package SpringProject.Spring.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ColorController {
    private final ColorService ColorService;

    @Autowired
    public ColorController(ColorService ColorService) {
        this.ColorService = ColorService;
    }

    @GetMapping("/cottoncandies")
    public List<ColorName> getColors() {
        return ColorService.readAllColors();
    }

    @GetMapping("/cottoncandies/{ColorId}")
    public ColorName getSingleColor(@PathVariable("ColorId") Long ColorId) {
        return ColorService.getSingleColor(ColorId);
    }

    @PostMapping("/newColor")
    public void postColor(@RequestBody ColorName ColorName) {
        ColorService.addColorName(ColorName);
    }

    @DeleteMapping("/delColor/{ColorId}")
    public void deleteColor(@PathVariable("ColorId") Long ColorId) {
        ColorService.deleteColorName(ColorId);
    }

    @PutMapping("/putColor/{ColorId}")
    public void updateColor(@PathVariable("ColorId") Long ColorId,
                            @RequestParam(required = false) String ColorName) {
        ColorService.updateColorName(ColorName, ColorId);
    }
}
