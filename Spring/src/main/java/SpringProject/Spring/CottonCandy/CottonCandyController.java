package SpringProject.Spring.CottonCandy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CottonCandyController {
    private final CottonCandyService cottonCandyService;

    @Autowired
    public CottonCandyController(CottonCandyService cottonCandyService){
        this.cottonCandyService = cottonCandyService;
    }

    @GetMapping(path =" alldacottoncandies")
    public List<CottonCandy> getColor(){
        return cottonCandyService.getAllCottonCandy();
    }

    @PostMapping(path= "newCandycolor")
    public void postColor(@RequestBody CottonCandy newCottonCandy){
        cottonCandyService.addCottonCandy(newCottonCandy);
    }

    @DeleteMapping(path = "delCandyColor")
    public void delColor(@PathVariable("id") Long id){
        cottonCandyService.deleteCottonCandy(id);
    }

    @PutMapping(path = "putCandyColor")
    public void putColor(@PathVariable("id") Long id,
                         @RequestParam(required = false) String newColor){
        cottonCandyService.updateCottonCandyColor(id, newColor);
    }
}
