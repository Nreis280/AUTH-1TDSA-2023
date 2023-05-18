import br.com.holding.autentication.model.Profile;
import br.com.holding.autentication.model.Role;
import br.com.holding.autentication.model.User;
import br.com.holding.pessoa.model.Pessoa;
import br.com.holding.pessoa.model.PessoaFisica;
import br.com.holding.pessoa.model.PessoaJuridica;
import br.com.holding.sistema.model.Sistema;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Objects;

public class Main {


    public static PessoaFisica novaPessoa(Long id, String nome, LocalDate nascimento, String cpf){
        PessoaFisica pf = new PessoaFisica();
        pf.setId(id);
        pf.setNome(nome);
        pf.setNascimento(nascimento);
        pf.setCpf(cpf);

        return pf;
    }

    public static PessoaJuridica novaPessoaJuridica(Long id, String nome, LocalDate fundacao, String CNPJ){
        PessoaJuridica pj = new PessoaJuridica();
        pj.setId(id);
        pj.setNome(nome);
        pj.setNascimento(fundacao);
        pj.setCNPJ(CNPJ);

        return pj;
    }

    public static User novoUsuario(Long id, String email, String password, Pessoa pessoa){
        User lg = new User();
        lg.setId(id);
        lg.setEmail(email);
        lg.setPassword(password);
        lg.setPessoa(pessoa);

        return lg;
    }

    public static Profile novoProfile(Long id, String nome){
        Profile pr = new Profile();
        pr.setId(id);
        pr.setNome(nome);

        return pr;
    }

    public static Role novoRole(Long id, String nome, String descricao, Sistema sistema){
        Role  rl = new Role();
        rl.setId(id);
        rl.setNome(nome);
        rl.setDescricao(descricao);
        rl.setSistema(sistema);

        return rl;
    }

    public static Sistema novoSistema(Long id, String nome, String sigla){
        Sistema st = new Sistema();
        st.setId(id);
        st.setNome(nome);
        st.setSigla(sigla);

        return st;
    }


    public static void main(String[] args) {

        PessoaFisica nicolas = novaPessoa
                        (12345L,"Nicolas Reis",
                            LocalDate.of(2004,1,26),"123.345.678-91");
        PessoaFisica nicolasJn = novaPessoa
                (12345L,"Nicolas Junior",
                        LocalDate.of(2034,9,12),"154.323.612-01");

        PessoaJuridica barni = novaPessoaJuridica
                        (9876L, "Bar & Restaurante Barni",
                             LocalDate.of(2010,6,16), "12.123.123/0001-03");

        User nicolas13 = novoUsuario
                        (123456L, "nicolazin@gmail.com",
                            "nicolas123",nicolas);
        Profile barmen = novoProfile(99191L,"Barmen do Barni");

        Sistema bar = novoSistema(1234L,"Barni","BN");

        Role fechaCaixaBar = novoRole(1234L,"Open-Caixa","Abre e fecha o caixa",bar);

        //Fazer coleção Filho
        nicolas.addFilho(nicolasJn);

        //Fazer coleção sócios
        barni.addSocio(nicolas).addSocio(nicolasJn);

        //Fazer coleção Profiles
        nicolas13.addProfile(barmen);

        //Fazer coleção Roles
        barmen.addRole(fechaCaixaBar);

        //Fazer coleção Responsaveis
        bar.addResponsavel(nicolas);


        var login = JOptionPane.showInputDialog("Digite seu email: ");
        var senha = JOptionPane.showInputDialog("Digite sua senha: ");

        if(Objects.equals(login, nicolas13.getEmail()) && Objects.equals(senha, nicolas13.getPassword())){
            System.out.println("login valido");
        }else{
            System.out.println("Login invalido Email ou senha Invalido! ");
        }

    }
}