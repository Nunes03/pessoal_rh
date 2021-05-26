package br.com.lucasnunes.rh.resource;

import br.com.lucasnunes.rh.model.Pais;
import br.com.lucasnunes.rh.repository.PaisRepository;
import br.com.lucasnunes.rh.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PaisResource {

	@Autowired
    private PaisService paisService;

    @GetMapping("/pais")
    public ArrayList<Pais> find(){
        return paisService.buscarTodosOsPais();
    }

    @GetMapping("/pais/{id}")
    public Pais find(@PathVariable Integer id){
        Pais pais = paisService.buscarPorId(id);
        return pais;
    }

    @PostMapping("/pais")
    public boolean inserirPais(@RequestBody Pais pais){
        if(paisService.inserirPais(pais)){
            return true;
        }
        return false;
    }
    
    @PutMapping("/pais/{id}")
    public String atualizarPaisPorId(@PathVariable Integer id, @RequestBody Pais pais) {
    	try {
    		if(paisService.atualizarPais(id,pais)) {
    			return "Pais atualizado com sucesso.";
    		}
    		return "Pais não encontrado.";
    	} catch(Exception e) {
    		return "Erro ao atualizar pais.";
    	}
    }
}
