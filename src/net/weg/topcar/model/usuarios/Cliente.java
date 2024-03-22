package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.Automovel;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente implements ICliente{
    private String nome;
    private Long cpf;
    private String senha;
    private int idade;
    private ArrayList<Automovel> listaAutomoveis = new ArrayList<Automovel>();

    public Cliente(String nome, Long cpf, String senha, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
    }

    public Cliente(Long cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public String menu() {
        return """
                                   
                1 - Ver automóveis;
                2 - Ver automóvel especifico;
                3 - Ver seus automóveis;
                """;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade() {
        return idade;
    }

    public List<Automovel> getListaAutomoveis() {
        return Collections.unmodifiableList(listaAutomoveis);
    }

    public void adicionarProprioAutomovel(Automovel automovel) {
        this.listaAutomoveis.add(automovel);
        automovel.mudarStatus();
    }

    @Override
    public List<Automovel> verAutomoveis(IBanco<Automovel, String> banco) {
        return banco.buscarTodos();
    }

    @Override
    public List<Automovel> verMeusAutomoveis() {
        return null;
    }

    @Override
    public Automovel verAutomovel(String codigo, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException {
        return banco.buscarUm(codigo);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", idade=" + idade +
                '}';
    }
}