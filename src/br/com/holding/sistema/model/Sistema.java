package br.com.holding.sistema.model;

import br.com.holding.autentication.model.Profile;
import br.com.holding.autentication.model.Role;
import br.com.holding.pessoa.model.Pessoa;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class Sistema {

    private Long id;
    private String nome;
    private String sigla;



    private Collection<Pessoa> responsaveis = new Vector<>();

    public Sistema addResponsavel(Pessoa responsavel){
        this.responsaveis.add(responsavel);
        return this;
    }

    public Sistema removeResponsavel(Pessoa responsavel){
        this.responsaveis.remove(responsavel);
        return this;
    }


    public Collection<Pessoa> getResponsaveis(){
        return Collections.unmodifiableCollection(this.responsaveis);
    }

    public Sistema() {
    }

    public Sistema(Long id, String nome, String sigla, Collection<Pessoa> responsaveis) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.responsaveis = responsaveis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Sistema{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", responsaveis=" + responsaveis +
                '}';
    }
}
