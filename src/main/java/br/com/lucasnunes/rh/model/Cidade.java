package br.com.lucasnunes.rh.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidade")
    private List<Bairro> bairros = new ArrayList<>();

    public Cidade(){}

    public Cidade(Integer id, String nome, Estado estado){
        super();
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {return estado;}

    public void setEstado(Estado estado) {this.estado = estado;}

    public List<Bairro> getBairros() {return bairros;}

    public void setBairros(ArrayList<Bairro> bairros) {this.bairros = bairros;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id) && Objects.equals(nome, cidade.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}