package br.com.lucasnunes.rh.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    public Estado(){}

    public Estado(Integer id, String nome, Pais pais){
        super();
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais(){return this.pais;}

    public void setPais(Pais pais){this.pais = pais;}

    public List<Cidade> getCidades() {return cidades;}

    public void setCidades(ArrayList<Cidade> cidades) {this.cidades = cidades;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id) && Objects.equals(nome, estado.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}