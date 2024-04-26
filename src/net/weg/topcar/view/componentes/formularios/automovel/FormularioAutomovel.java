package net.weg.topcar.view.componentes.formularios.automovel;

import net.weg.topcar.view.componentes.formularios.Formulario;

public class FormularioAutomovel extends Formulario {
    protected Long selecionaTipoDeAutomovel() {
        Long entrada;
        do {
            entrada = entradaInteiro.leiaComSaidaEValidacao("""
                    Qual o tipo de automóvel?
                    1 - Carro;
                    2 - Moto;
                    3 - Quadriciclo
                    """, saida);
        } while (entrada > 3);
        return entrada;
    }

    protected Double entradaPreco(Double precoAntigo) {
        Double novoPreco = entradaDecimal.leiaComSaida("Preço: ", saida);
        if (novoPreco <= 0.0) {
            return precoAntigo;
        }

        return novoPreco;
    }

    protected String entradaMarca() {
        return entradaTexto.leiaComSaidaEValidacao("Marca: ", saida);
    }

    protected String entradaMarca(String marca) {
        String novaMarca = entradaTexto.leiaComSaida("Marca: ", saida);
        if (novaMarca.isEmpty()) {
            return marca;
        }
        return novaMarca;
    }

    protected String entradaMarcha() {
        return entradaTexto.leiaComSaidaEValidacao("Marcha: ", saida);
    }

    protected String entradaMarcha(String marcha) {
        String novaMarcha = entradaTexto.leiaComSaida("Marcha: ", saida);
        if (novaMarcha.isEmpty()) {
            return marcha;
        }
        return novaMarcha;
    }

    protected String entradaCarroceria() {
        return entradaTexto.leiaComSaidaEValidacao("Carroceria: ", saida);
    }

    protected String entradaCarroceria(String carroceria) {
        String novaCarroceria = entradaTexto.leiaComSaida("Carroceria: ", saida);
        if (novaCarroceria.isEmpty()) {
            return carroceria;
        }
        return novaCarroceria;
    }

    protected String entradaPartida() {
        return entradaTexto.leiaComSaidaEValidacao("Partida: ", saida);
    }

    protected String entradaPartida(String partida) {
        String novaPartida = entradaTexto.leiaComSaida("Partida: ", saida);
        if (novaPartida.isEmpty()) {
            return partida;
        }
        return novaPartida;
    }

    protected String entradaModelo() {
        return entradaTexto.leiaComSaidaEValidacao("Modelo: ", saida);
    }

    protected String entradaModelo(String modelo) {
        String novoModelo = entradaTexto.leiaComSaida("Modelo: ", saida);
        if (novoModelo.isEmpty()) {
            return modelo;
        }
        return novoModelo;
    }

    protected String entradaPlaca() {
        return entradaTexto.leiaComSaidaEValidacao("Placa: ", saida);
    }

    protected String entradaPlaca(String placa) {
        String novaPlaca = entradaTexto.leiaComSaida("Placa: ", saida);
        if (novaPlaca.isEmpty()) {
            return placa;
        }
        return novaPlaca;
    }

    protected String entradaCor() {
        return entradaTexto.leiaComSaidaEValidacao("Cor: ", saida);
    }

    protected String entradaCor(String cor) {
        String novaCor = entradaTexto.leiaComSaida("Cor: ", saida);
        if (novaCor.isEmpty()) {
            return cor;
        }
        return novaCor;
    }

    protected String entradaCombustivel() {
        return entradaTexto.leiaComSaidaEValidacao("Combustível: ", saida);
    }

    protected String entradaCombustivel(String combustivel) {
        String novaCombustivel = entradaTexto.leiaComSaida("Combustível: ", saida);
        if (novaCombustivel.isEmpty()) {
            return combustivel;
        }
        return novaCombustivel;
    }

    protected Double entradaQuilometragem() {
        return entradaDecimal.leiaComSaidaEValidacao("Quilometragem: ", saida);
    }

    protected Double entradaQuilometragem(Double quilometragem) {
        Double novaQuilometragem = entradaDecimal.leiaComSaida("Quilometragem: ", saida);
        if (novaQuilometragem <= 0) {
            return quilometragem;
        }
        return novaQuilometragem;
    }

    protected Long entradaAno() {
        return entradaInteiro.leiaComSaidaEValidacao("Ano: ", saida);
    }

    protected Long entradaAno(Long ano) {
        Long novoAno = entradaInteiro.leiaComSaida("Ano: ", saida);
        if (novoAno <= 0) {
            return ano;
        }
        return novoAno;
    }

    protected Long entradaCilindradas() {
        return entradaInteiro.leiaComSaidaEValidacao("Cilindradas: ", saida);
    }

    protected Long entradaCilindradas(Long cilindradas) {
        Long novaCilindradas = entradaInteiro.leiaComSaida("Cilindradas: ", saida);
        if (novaCilindradas <= 0) {
            return cilindradas;
        }
        return novaCilindradas;
    }

    protected Boolean entradaNovo() {
        Long entrada;

        do {
            entrada = entradaInteiro.leiaComSaidaEValidacao("""
                    Automóvel 0km?
                    1 - Sim;
                    2 - Não.
                    """, saida);
        } while (entrada > 2);

        return entrada == 1;
    }

    protected Double entradaPreco() {
        return entradaDecimal.leiaComSaidaEValidacao("Preço: ", saida);
    }

    protected String entradaCodigo() {
        return entradaTexto.leiaComSaidaEValidacao("Código: ", saida);
    }
}
