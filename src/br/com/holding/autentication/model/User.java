package br.com.holding.autentication.model;

import br.com.holding.pessoa.model.Pessoa;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

public class User{

    private Long id;
    private String email;
    private String password;
    private Pessoa pessoa;


    private Collection<Profile> profiles = new Vector<>();

    public User addProfile(Profile profile){
        this.profiles.add(profile);
        return this;
    }

    public User removeProfile(Profile profile){
        this.profiles.remove(profile);
        return this;
    }

    public Collection<Profile>getProfile(){
        return Collections.unmodifiableCollection(this.profiles);
    }

    public User() {
    }

    public User(Long id, String email, String password, Pessoa pessoa, Collection<Profile> profiles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.pessoa = pessoa;
        this.profiles = profiles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", pessoa=" + pessoa +
                ", profiles=" + profiles +
                '}';
    }
}
