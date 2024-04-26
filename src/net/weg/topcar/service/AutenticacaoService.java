package net.weg.topcar.service;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;
import net.weg.topcar.model.usuarios.Cliente;
import net.weg.topcar.model.usuarios.UsuarioAutenticadoBack;

public class AutenticacaoService {
    private IBanco<Cliente, Long> usuarioBanco;
    private UsuarioService usuarioService;
    public Cliente login(Long cpf, String senha) throws ObjetoNaoEncontradoException {
        Cliente cliente = usuarioBanco.buscarUm(cpf);

        if (cliente.getSenha().equals(senha)) {
            UsuarioAutenticadoBack.setUsuario(cliente);
            return cliente;
        }

        throw new RuntimeException("Usuário e/ou senha incorretos!");
    }

    public void logout() {
        UsuarioAutenticadoBack.setUsuario(null);
    }
}
