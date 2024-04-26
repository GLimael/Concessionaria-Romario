package net.weg.topcar;

public class Main {
//    static Scanner sc = new Scanner(System.in);
//    static Cliente usuarioLogado;

    public static void main(String[] args) {
//        Cliente novoUsuario = new net.weg.topcar.model.usuarios.Cliente("Winter", "108.414.879-01", "Chettus", 18);
//        novoUsuario.adicionarUsuario();
//        novoUsuario = new Vendedor("Vendedor", "111.111.111-11", "vendedor", 37, 30000);
//        novoUsuario.adicionarUsuario();
//        novoUsuario = new Gerente("Gerente", "222.222.222-22", "gerente", 24, 50000);
//        novoUsuario.adicionarUsuario();
//
//            int escolha = Integer.parseInt(sc.nextLine());
//
//
//        } while (true);
//    }

//    public static String inputString(String text) {
//        String input;
//        do {
//
//            System.out.print(text);
//            input = sc.nextLine();
//        } while (input.equals(""));
//        return input;
//    }
//
//    public static int inputInt(String text) {
//        int input;
//        do {
//            System.out.print(text);
//            input = Integer.parseInt(sc.nextLine());
//        } while (input == 0);
//        return input;
//    }
//
//    public static double inputDouble(String text) {
//        double input;
//        do {
//            System.out.print(text);
//            input = Double.parseDouble(sc.nextLine());
//        } while (input == 0);
//        return input;
//    }
//
//    public static void cadastrarUsuario() {
//        String nome, cpf, senha;
//        int idade;
//        nome = inputString("Nome: ");
//        do {
//            cpf = inputString("CPF: ");
//            try {
//                Cliente.procurarUsuario(cpf);
//                throw new UsuarioExistenteException();
//            } catch (UsuarioNaoEncontradoException exception) {
//                break;
//            } catch (UsuarioExistenteException exception) {
//                System.out.println(exception.getMessage());
//            }
//        } while (true);
//        senha = inputString("Senha: ");
//        idade = inputInt("Idade: ");
//        Cliente novoUsuario = new net.weg.topcar.model.usuarios.Cliente(nome, cpf, senha, idade);
//        novoUsuario.adicionarUsuario();
//        System.out.println("Usuário cadastrado!");
//    }
//
//    public static void verAutomoveis() {
//        System.out.println("Nossos automóveis:");
//        ArrayList<Automovel> automoveisComprar = new ArrayList<Automovel>();
//
//        for (Automovel automovel : Automovel.getListaAutomoveis()) {
//            if (!automovel.isComprado()) {
//                automoveisComprar.add(automovel);
//            }
//        }
//        System.out.println(automoveisComprar);
//    }
//
//    public static void verAutomovelEspecifico() {
//        String codigo = inputString("Código: ");
//        try {
//            System.out.println(Automovel.procurarAutomovel(codigo));
//        } catch (VeiculoNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//        }
//    }
//
//    public static void verMeusAutomoveis() {
//        System.out.println("Seus automóveis:");
//        System.out.println(usuarioLogado.getListaAutomoveis());
//    }
//
//    public static void login() {
//        String cpf = inputString("CPF: ");
//        String senha = inputString("Senha: ");
//
//        try {
//            usuarioLogado = Cliente.login(cpf, senha);
//            System.out.println("Login realizado!");
//            menuPrincipal();
//        } catch (UsuarioNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//            System.out.println("""
//                    Deseja realizar o cadastro?
//                    1 - Sim;
//                    Outro - não.
//                    """);
//
//            int escolha = Integer.parseInt(sc.nextLine());
//
//            if (escolha == 1) {
//                cadastrarUsuario();
//            }
//        } catch (SenhaIncorretaException exception) {
//            System.out.println(exception.getMessage());
//        }
//    }
//
//    public static void venderAutomovel(Funcionario funcionario) {
//        String cpf = inputString("CPF do usuário: ");
//        String codigo = inputString("Código do carro: ");
//
//        try {
//            System.out.println(funcionario.venderAutomovel(codigo, cpf));
//            System.out.println("Compra realizada!");
//        } catch (VeiculoNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//        } catch (UsuarioNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//        }
//    }
//
//    public static void procurarUsuario() {
//        String cpf = inputString("CPF do usuário: ");
//        try {
//            System.out.println(Cliente.procurarUsuario(cpf));
//        } catch (UsuarioNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//        }
//    }
//
//    public static void verPagamento() {
//        if (usuarioLogado instanceof Funcionario funcionario) {
//            System.out.println("Seu pagamento:");
//            System.out.println(funcionario.verPagamento());
//        }
//    }
//
//    public static void registrarAutomovel() {
//        String codigo, modelo, marca, tipoCombustivel, placa, cor, estado;
//        int ano, quilometragem;
//        double preco;
//
//        Automovel automovelTeste;
//        Automovel automovelCadastrado;
//
//        System.out.println("A informação 'placa' é opcional!");
//
//        do {
//            System.out.print("Código do automóvel: ");
//            codigo = sc.nextLine();
//            try {
//                automovelTeste = Automovel.procurarAutomovel(codigo);
//                throw new VeiculoExistenteException();
//            } catch (VeiculoNaoEncontradoException exception) {
//                if (!codigo.equals("")) {
//                    break;
//                }
//            } catch (VeiculoExistenteException exception) {
//                System.out.println(exception.getMessage());
//            }
//        } while (true);
//
//        do {
//            System.out.print("Modelo: ");
//            modelo = sc.nextLine();
//        } while (modelo.equals(""));
//
//        do {
//            System.out.print("Marca: ");
//            marca = sc.nextLine();
//        } while (marca.equals(""));
//
//        do {
//            System.out.print("Tipo de combustível: ");
//            tipoCombustivel = sc.nextLine();
//        } while (tipoCombustivel.equals(""));
//
//        System.out.print("Placa: ");
//        placa = sc.nextLine();
//
//        do {
//            System.out.print("Cor: ");
//            cor = sc.nextLine();
//        } while (cor.equals(""));
//
//        do {
//            System.out.print("Estado ('novo' ou 'seminovo'): ");
//            estado = sc.nextLine();
//        } while (!estado.equals("novo") && !estado.equals("seminovo"));
//
//        do {
//            System.out.print("Ano: ");
//            ano = Integer.parseInt(sc.nextLine());
//        } while (ano == 0);
//
//        System.out.print("Quilometragem: ");
//        quilometragem = Integer.parseInt(sc.nextLine());
//
//        do {
//            try {
//                System.out.print("Preço: ");
//                preco = Double.parseDouble(sc.nextLine());
//                verificarPreco(preco);
//            } catch (PrecoInvalidoException exception) {
//                System.out.println(exception.getMessage());
//                continue;
//            }
//
//            break;
//        } while (true);
//
//        int escolha;
//
//        do {
//            System.out.println("""
//                    1 - Carro;
//                    2 - Moto;
//                    3 - Quadriciclo.
//                    """);
//
//            System.out.print("> ");
//            escolha = Integer.parseInt(sc.nextLine());
//        } while (escolha < 1 || escolha > 3);
//
//        if (usuarioLogado instanceof Gerente gerente) {
//            switch (escolha) {
//                case 1 -> {
//                    String marcha, tipoCarroceria;
//
//                    do {
//                        System.out.print("Marcha: ");
//                        marcha = sc.nextLine();
//                    } while (marcha.equals(""));
//
//                    do {
//                        System.out.print("Tipo de carroceria: ");
//                        tipoCarroceria = sc.nextLine();
//                    } while (tipoCarroceria.equals(""));
//
//                    automovelCadastrado = new Carro(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, estado, marcha, tipoCarroceria);
//                    gerente.registrarAutomovel(automovelCadastrado);
//                }
//                case 2 -> {
//                    String partida;
//                    int cilindradas;
//
//                    do {
//                        System.out.print("Partida: ");
//                        partida = sc.nextLine();
//                    } while (partida.equals(""));
//
//                    do {
//                        System.out.print("Cilindradas: ");
//                        cilindradas = Integer.parseInt(sc.nextLine());
//                    } while (cilindradas == 0);
//
//                    automovelCadastrado = new Moto(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, estado, partida, cilindradas);
//                    gerente.registrarAutomovel(automovelCadastrado);
//                }
//                case 3 -> {
//                    automovelCadastrado = new Quadriciclo(codigo, modelo, ano, marca, tipoCombustivel, preco, quilometragem, placa, cor, estado);
//                    gerente.registrarAutomovel(automovelCadastrado);
//                }
//            }
//            System.out.println("Automóvel registrado!");
//        } else {
//            System.out.println("Você não possui as permissões necessárias!");
//        }
//    }
//
//    public static void verificarPreco(double preco) throws PrecoInvalidoException {
//        if (preco <= 0) {
//            throw new PrecoInvalidoException();
//        }
//    }
//
//    public static void removerAutomovel() {
//        System.out.print("Código do automóvel: ");
//        String codigo = sc.nextLine();
//        try {
//
//            Automovel automovelRemover = Automovel.procurarAutomovel(codigo);
//            if (automovelRemover.isComprado()) {
//                System.out.println("O carro já foi comprado! Impossível realizar a remoção!");
//            } else {
//                if (usuarioLogado instanceof Gerente gerente) {
//                    gerente.removerAutomovel(automovelRemover);
//                    System.out.println("Automóvel removido!");
//                } else {
//                    System.out.println("Você não possui as permissões necessárias!");
//                }
//            }
//        } catch (VeiculoNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//    }
//
//    public static void editarAutomovel() {
//        System.out.println("Código do automóvel que deseja editar: ");
//        String codigo = sc.nextLine();
//
//        try {
//            Automovel automovel = Automovel.procurarAutomovel(codigo);
//            if (automovel.isComprado()) {
//                System.out.println("O automóvel já foi comprado! Impossível realizar a edição!");
//            } else {
//                String modelo, marca, tipoCombustivel, placa, cor, estado;
//                int ano, quilometragem;
//
//                System.out.println("Caso não deseje mudar um valor, apenas passe sem digitar nada (em números, digite 0)!");
//
//                System.out.print("Modelo: ");
//                modelo = sc.nextLine();
//
//                if (modelo.equals("")) {
//                    modelo = automovel.getModelo();
//                }
//
//                System.out.print("Marca: ");
//                marca = sc.nextLine();
//
//                if (marca.equals("")) {
//                    marca = automovel.getMarca();
//                }
//
//                System.out.print("Tipo de combustível: ");
//                tipoCombustivel = sc.nextLine();
//
//                if (tipoCombustivel.equals("")) {
//                    tipoCombustivel = automovel.getTipoCombustivel();
//                }
//
//                System.out.print("Placa (digite '0' para deixar a placa vazia): ");
//                placa = sc.nextLine();
//
//                if (placa.equals("")) {
//                    placa = automovel.getPlaca();
//                } else if (placa.equals("0")) {
//                    placa = "";
//                }
//
//                System.out.print("Cor: ");
//                cor = sc.nextLine();
//
//                if (cor.equals("")) {
//                    cor = automovel.getCor();
//                }
//
//                do {
//                    System.out.print("Estado ('novo' ou 'seminovo'): ");
//                    estado = sc.nextLine();
//                } while (!estado.equals("novo") && !estado.equals("seminovo"));
//
//                System.out.print("Ano: ");
//                ano = Integer.parseInt(sc.nextLine());
//
//                if (ano == 0) {
//                    ano = automovel.getAno();
//                }
//
//                System.out.print("Quilometragem: ");
//                quilometragem = Integer.parseInt(sc.nextLine());
//
//                if (quilometragem == 0) {
//                    quilometragem = automovel.getQuilometragem();
//                }
//
//                if (usuarioLogado instanceof Gerente gerente) {
//                    Automovel novoAutomovel;
//                    if (automovel instanceof Carro carro) {
//                        String marcha, tipoCarroceria;
//
//                        System.out.print("Marcha: ");
//                        marcha = sc.nextLine();
//
//                        if (marcha.equals("")) {
//                            marcha = carro.getMarcha();
//                        }
//
//                        System.out.print("Tipo da carroceria: ");
//                        tipoCarroceria = sc.nextLine();
//
//                        if (tipoCarroceria.equals("")) {
//                            tipoCarroceria = carro.getTipoCarroceria();
//                        }
//                        novoAutomovel = new Carro(automovel.getCODIGO(), modelo, ano, marca, tipoCombustivel, automovel.getPreco(), quilometragem, placa, cor, estado, marcha, tipoCarroceria);
//                        gerente.editarAutomovel(automovel, novoAutomovel);
//                    } else if (automovel instanceof Moto moto) {
//                        String partida;
//                        int cilindradas;
//
//                        System.out.print("Partida: ");
//                        partida = sc.nextLine();
//
//                        if (partida.equals("")) {
//                            partida = moto.getPartida();
//                        }
//
//                        System.out.print("Cilindradas: ");
//                        cilindradas = Integer.parseInt(sc.nextLine());
//
//                        if (cilindradas == 0) {
//                            cilindradas = moto.getCilindradas();
//                        }
//
//                        novoAutomovel = new Moto(automovel.getCODIGO(), modelo, ano, marca, tipoCombustivel, automovel.getPreco(), quilometragem, placa, cor, estado, partida, cilindradas);
//                        gerente.editarAutomovel(automovel, novoAutomovel);
//                    } else if (automovel instanceof Quadriciclo) {
//                        novoAutomovel = new Quadriciclo(automovel.getCODIGO(), modelo, ano, marca, tipoCombustivel, automovel.getPreco(), quilometragem, placa, cor, estado);
//                        gerente.editarAutomovel(automovel, novoAutomovel);
//                    }
//                    System.out.println("Automóvel editado!");
//                } else {
//                    System.out.println("Você não possui as permissões necessárias!");
//                }
//            }
//        } catch (VeiculoNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//
//    }
//
//    public static void editarPreco() {
//        System.out.println("Código do automóvel que deseja editar: ");
//        String codigo = sc.nextLine();
//
//        try {
//
//            Automovel automovel = Automovel.procurarAutomovel(codigo);
//            if (automovel.isComprado()) {
//                System.out.println("Automóvel já está comprado! impossível realizar a edição!");
//            } else {
//                double preco;
//                System.out.println("Novo preço: ");
//                preco = Double.parseDouble(sc.nextLine());
//
//                if (usuarioLogado instanceof Gerente gerente) {
//                    try {
//                        gerente.editarPreco(automovel, preco);
//                        System.out.println("Preço editado!");
//                    } catch (PrecoInvalidoException exception) {
//                        System.out.println(exception.getMessage());
//                    }
//                } else {
//                    System.out.println("Você não possui as permissões necessárias!");
//                }
//            }
//        } catch (VeiculoNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//    }
//
//    public static void registrarUsuario() {
//        String nome, cpf, senha;
//        int idade;
//
//        do {
//            System.out.print("Nome: ");
//            nome = sc.nextLine();
//        } while (nome.equals(""));
//
//        do {
//            System.out.print("CPF: ");
//            cpf = sc.nextLine();
//
//            try {
//                Cliente.procurarUsuario(cpf);
//                throw new UsuarioExistenteException();
//            } catch (UsuarioNaoEncontradoException exception) {
//                if (!cpf.equals("")) {
//                    break;
//                }
//            } catch (UsuarioExistenteException exception) {
//                System.out.println(exception.getMessage());
//            }
//        } while (true);
//
//        do {
//            System.out.print("Senha: ");
//            senha = sc.nextLine();
//        } while (senha.equals(""));
//
//        do {
//            System.out.print("Idade: ");
//            idade = Integer.parseInt(sc.nextLine());
//        } while (idade == 0);
//
//        int escolha;
//
//        do {
//            System.out.println("""
//                    1 - Cliente;
//                    2 - Vendedor.
//                    """);
//
//            System.out.print("> ");
//            escolha = Integer.parseInt(sc.nextLine());
//        } while (escolha < 1 || escolha > 2);
//
//        if (usuarioLogado instanceof Gerente gerente) {
//
//            if (escolha == 2) {
//                double salario;
//                do {
//                    System.out.print("Salário: ");
//                    salario = Double.parseDouble(sc.nextLine());
//                } while (salario == 0);
//
//                gerente.registrarUsuario(new Vendedor(nome, cpf, senha, idade, salario));
//            } else {
//                gerente.registrarUsuario(new net.weg.topcar.model.usuarios.Cliente(nome, cpf, senha, idade));
//            }
//            System.out.println("Usuário adicionado!");
//        } else {
//            System.out.println("Você não possui as permissões necessárias!");
//        }
//
//
//    }
//
//    public static void removerUsuario() {
//        System.out.print("CPF do usuário: ");
//        String cpf = sc.nextLine();
//
//        if (usuarioLogado instanceof Gerente gerente) {
//            try {
//                gerente.removerUsuario(cpf);
//                System.out.println("Usuário removido!");
//            } catch (UsuarioNaoEncontradoException exception) {
//                System.out.println(exception.getMessage());
//            } catch (PermissaoRemocaoNegadaException exception) {
//                System.out.println(exception.getMessage());
//            }
//        } else {
//            System.out.println("Você não possui as permissões necessárias!");
//        }
//    }
//
//    public static void editarUsuario() {
//        String nome, senha;
//
//
//        System.out.println("CPF do usuário que deseja editar: ");
//        String cpf = sc.nextLine();
//
//        try {
//            Cliente usuario = Cliente.procurarUsuario(cpf);
//            if (usuario instanceof Gerente) {
//                System.out.println("O usuário pesquisado é um gerente! Impossível fazer a edição!");
//            } else {
//                System.out.println("Caso não deseje mudar um valor, apenas passe sem digitar nada!");
//
//                System.out.print("Nome: ");
//                nome = sc.nextLine();
//
//                if (nome.equals("")) {
//                    nome = usuario.getNome();
//                }
//
//                System.out.print("Senha: ");
//                senha = sc.nextLine();
//
//                if (senha.equals("")) {
//                    senha = usuario.getSenha();
//                }
//
//                if (usuarioLogado instanceof Gerente gerente) {
//                    Cliente novoUsuario;
//                    if (usuario instanceof Vendedor vendedor) {
//                        double salario;
//
//                        System.out.print("Salário: ");
//                        salario = Double.parseDouble(sc.nextLine());
//
//                        if (salario == 0) {
//                            salario = vendedor.getSalario();
//                        }
//
//                        novoUsuario = new Vendedor(nome, usuario.getCpf(), senha, usuario.getIdade(), salario);
//                    } else {
//                        novoUsuario = new net.weg.topcar.model.usuarios.Cliente(nome, usuario.getCpf(), senha, usuario.getIdade());
//                    }
//                    gerente.editarUsuario(usuario, novoUsuario);
//                }
//            }
//        } catch (UsuarioNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//    }
//
//    public static void verVendedores() {
//        if (usuarioLogado instanceof Gerente gerente) {
//            System.out.println(gerente.verVendedores());
//        }
//    }
//
//    public static void verClientes() {
//        if (usuarioLogado instanceof Gerente gerente) {
//            System.out.println(gerente.verClientes());
//        }
//    }
//
//    public static void verPagamentoVendedores() {
//        if (usuarioLogado instanceof Gerente gerente) {
//            System.out.println(gerente.verPagamentoVendedores());
//        }
//    }
//
//    public static void verPagamentoVendedor() {
//        System.out.print("CPF do vendedor: ");
//        String cpf = sc.nextLine();
//
//        try {
//
//            Cliente usuario = Cliente.procurarUsuario(cpf);
//            if (usuario == null) {
//                System.out.println("Usuário não encontrado!");
//            } else if (!(usuario instanceof Vendedor vendedor)) {
//                System.out.println("O usuário encontrado não é um vendedor!");
//            } else {
//                if (usuarioLogado instanceof Gerente gerente) {
//                    System.out.println(gerente.verPagamentoVendedor(vendedor));
//                } else {
//                    System.out.println("Você não possui as permissões necessárias!");
//                }
//            }
//        } catch (UsuarioNaoEncontradoException exception) {
//            System.out.println(exception.getMessage());
//        }
//    }
//
//
//    public static void menuPrincipal() {
//        do {
//            System.out.println(usuarioLogado.menu());
//            System.out.print("""
//                    0 - Deslogar.
//
//                    >\s""");
//            try {
//                escolherOpcaoMenuPrincipal();
//            } catch (AcessoNegadoException exception) {
//                System.out.println(exception.getMessage());
//            } catch (OpcaoInvalidaException exception) {
//                System.out.println(exception.getMessage());
//            }
//        } while (usuarioLogado != null);
//    }
//
//    public static void escolherOpcaoMenuPrincipal() throws OpcaoInvalidaException, AcessoNegadoException {
//        int escolha;
//        escolha = Integer.parseInt(sc.nextLine());
//
//        verificarEscolhaMenuPrincipal(escolha);
//
//        switch (escolha) {
//            case 0 -> usuarioLogado = null;
//            case 1 -> verAutomoveis();
//            case 2 -> verAutomovelEspecifico();
//            case 3 -> verMeusAutomoveis();
//            default -> {
//                if (usuarioLogado instanceof Funcionario funcionario) {
//                    switch (escolha) {
//                        case 4 -> venderAutomovel(funcionario);
//                        case 5 -> procurarUsuario();
//                        case 6 -> verPagamento();
//                        default -> {
//                            if (usuarioLogado instanceof Gerente) {
//                                switch (escolha) {
//                                    case 7 -> registrarAutomovel();
//                                    case 8 -> removerAutomovel();
//                                    case 9 -> editarAutomovel();
//                                    case 10 -> editarPreco();
//                                    case 11 -> registrarUsuario();
//                                    case 12 -> removerUsuario();
//                                    case 13 -> editarUsuario();
//                                    case 14 -> verVendedores();
//                                    case 15 -> verClientes();
//                                    case 16 -> verPagamentoVendedores();
//                                    case 17 -> verPagamentoVendedor();
//                                    default -> System.out.println("Opção inválida!");
//                                }
//                            } else {
//                                System.out.println("Opção inválida!");
//                            }
//                        }
//                    }
//                } else {
//                    System.out.println("Opção inválida!");
//                }
//            }
//        }
//    }
//
//    public static void verificarEscolhaMenuPrincipal(int escolha) throws OpcaoInvalidaException, AcessoNegadoException {
//        if (escolha < 0 || escolha > 17) {
//            throw new OpcaoInvalidaException();
//        }
//
//        if (usuarioLogado instanceof net.weg.topcar.model.usuarios.Cliente && escolha > 3) {
//            throw new AcessoNegadoException();
//        }
//
//        if (usuarioLogado instanceof Vendedor && escolha > 6) {
//            throw new AcessoNegadoException();
//        }
    }
}