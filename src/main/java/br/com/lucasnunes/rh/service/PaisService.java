package br.com.lucasnunes.rh.service;

import br.com.lucasnunes.rh.model.Pais;
import br.com.lucasnunes.rh.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * <h1>Classe responsável pela implementação
 * do DAO</h1>
 *
 * <p>Implementa o DAO do {@link Pais} com base no
 * {@link PaisRepository}</p>
 *
 * @author Lucas Nunes lucasnunes.ln365@gmail.com
 *
 * @see Pais
 * @see PaisRepository
 */
@Service
public class PaisService{

	@Autowired
    PaisRepository paisRepository;
    
    /***
     * <h1>Busca um pais pelo Id.</h1>
     *
     * <p>Busca um {@link Pais} do banco pelo seu
     * Id. Solicita um id e retorna o {@link Pais}
     * com o id respectivo.</p>
     *
     * @param id Integer - Referente ao id informado
     *
     * @return {@link Pais} - Referente ao {@link Pais} encontrado
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     *
     * @see Pais
     */
    public Pais buscarPorId(Integer id) {
        Pais pais = paisRepository.findById(id).get();
        return pais;
    }

    /***
     * <h1>Busca todos os {@link Pais}es.</h1>
     *
     * <p>Busca todos os {@link Pais}es do banco.</p>
     *
     * @return ArrayList<Pais> - Referente aos {@link Pais}es encontrados
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     *
     * @see Pais
     */
    public ArrayList<Pais> buscarTodosOsPais() {
        ArrayList<Pais> listaPais = (ArrayList<Pais>) paisRepository.findAll();
        return listaPais;
    }

    /**
     * <h1>Insere um {@link Pais} no banco.</h1>
     *
     * <p>Insere um {@link Pais} no banco de dados.
     * Recebe um {@link Pais} e usa repository para
     * salvar no banco. Retorna true caso de tudo
     * certo.</p>
     *
     * @param pais {@link Pais} - Referente ao {@link Pais informado}
     *
     * @return boolean - True caso de certo, false caso contrário
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     *
     * @see Pais
     */
    public boolean inserirPais(Pais pais){
        try {
            paisRepository.save(pais);
            return true;
        } catch (Exception e){
            e.printStackTrace();;
            return false;
        }
    }
    
    /**
     * <h1>Atualiza um {@link Pais}</h1>
     * 
     * <p>Recebe um {@link Pais} e atualiza
     * ele pelo seu Id. Retorna true caso
     * tudo tenhadado certo.</p>
     * 
     * @param pais {@link Pais} - Referente ao {@link Pais} informado
     * 
     * @return boolean - true caso de certo e false caso contrário
     * 
     * @author Lucas Nunes
     * 
     * @see Pais
     */
    public boolean atualizarPais(Integer id, Pais pais) {
    	try {
    		pais.setId(id);
    		paisRepository.save(pais);
    		return true;
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		return false;
    	}
    }
}