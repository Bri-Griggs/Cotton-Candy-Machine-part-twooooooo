package SpringProject.Spring.CottonCandy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class CottonCandyController {
    private final CottonCandyService candyService;

    @Autowired
    public CottonCandyController(CottonCandyService candyService) {
        this.candyService = candyService;
    }

    @GetMapping(path="alldatcottoncandies")
    public List<CottonCandy> getCottonCandy() {
        return candyService.getCottonCandies();
    }

    @GetMapping(path="alldatcottoncandies/{id}")
    public CottonCandy getCSingularCottonCandy(@PathVariable("id") Long id) {
        return candyService.getCottonCandy(id);
    }

    @PostMapping(path = "/newCandyColor")
    public void postColor(@RequestBody CottonCandy cottonCandy) {
        candyService.addCottonCandy(cottonCandy);
    }

    @DeleteMapping(path="delCandyColor/{id}")
    public void delColor(@PathVariable("id") Long id){
        candyService.deleteCottonCandy(id);
    }

    @PutMapping(path= "putCandyColor/{id}")
    public void putColor(@PathVariable("id") Long id,
                         @RequestParam(required = false) String color) {
        candyService.updateCottonCandy(id, color);
    }
}