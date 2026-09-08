package LujanBarberShop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fix")
public class FixJefesController {

    private final BarberoRepository barberoRepository;

    public FixJefesController(BarberoRepository barberoRepository) {
        this.barberoRepository = barberoRepository;
    }

    @GetMapping("/jefes")
    public Map<String, Object> fixJefes() {
        Map<String, Object> r = new HashMap<>();
        List<Barbero> barberos = barberoRepository.findAll();
        int actualizados = 0;
        
        for (Barbero b : barberos) {
            if (b.getNombre().equalsIgnoreCase("Gabi")) {
                b.setEsJefe(true);
                b.setPorcentajeComision(1.00);
                barberoRepository.save(b);
                actualizados++;
            } else if (b.getNombre().equalsIgnoreCase("Diego")) {
                b.setEsJefe(true);
                b.setPorcentajeComision(1.00);
                barberoRepository.save(b);
                actualizados++;
            } else if (b.getNombre().equalsIgnoreCase("Luciano")) {
                b.setEsJefe(false);
                b.setPorcentajeComision(0.50);
                barberoRepository.save(b);
                actualizados++;
            }
        }
        
        r.put("actualizados", actualizados);
        r.put("total", barberos.size());
        return r;
    }
}
