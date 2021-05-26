package br.com.lucasnunes.rh.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bairro")
    private List<Endereco> enderecos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    public Bairro(){}

    public Bairro(Integer id, String nome, Cidade cidade){
        super();
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {return enderecos;}

    public void setEnderecos(ArrayList<Endereco> enderecos) {this.enderecos = enderecos;}

    public Cidade getCidade() {return cidade;}

    public void setCidade(Cidade cidade) {this.cidade = cidade;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bairro bairro = (Bairro) o;
        return Objects.equals(id, bairro.id) && Objects.equals(nome, bairro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}