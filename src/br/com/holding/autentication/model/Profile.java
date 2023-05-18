package br.com.holding.autentication.model;

import br.com.holding.pessoa.model.PessoaFisica;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class Profile {

    private Long id;
    private String nome;

    private Collection<Role> roles = new Vector<>();

    public Profile addRole(Role role){
        this.roles.add(role);
        return this;
    }

    public Profile removeRole(Role role){
        this.roles.remove(role);
        return this;
    }

    public Collection<Role> getRoles(){
        return Collections.unmodifiableCollection(this.roles);
    }

    public Profile() {
    }

    public Profile(Long id, String nome, Collection<Role> roles) {
        this.id = id;
        this.nome = nome;
        this.roles = roles;
    }

    public long getId() {
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


    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", roles=" + roles +
                '}';
    }
}
