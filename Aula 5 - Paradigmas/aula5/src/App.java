import java.util.ArrayList;
import java.util.Scanner;

class Paciente {
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;

    public Paciente(String nome, String cpf, int idade, String telefone, String dataEnvio) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void exibirInformacoes() {
        System.out.println("Paciente: " + nome + " | CPF: " + cpf + " | Idade: " + idade + " | Telefone: " + telefone);
    }
}

class Consulta {
    private Paciente paciente;
    private String data;
    private String horario;
    private String especialidade;
    private String medico;
    private String resposta;
    private String dataEnvio;
    private String cpf;

    public Consulta(String cpf, String data, String horario, String especialidade, String medico, String resposta, String dataEnvio) {
        this.cpf = cpf;
        this.data = data;
        this.horario = horario;
        this.especialidade = especialidade;
        this.medico = medico;
        this.resposta = resposta;
        this.dataEnvio = dataEnvio;
    }


    public String getCpfPaciente() {
        return paciente.getCpf();
    }

    public void exibirDetalhes() {
        System.out.println("Consulta com " + medico + " | Especialidade: " + especialidade +
                " | Data: " + data + " | Horário: " + horario);
        paciente.exibirInformacoes();
    }

    public void exibirResultadoConsulta() {
        System.out.println("Consulta com " + medico + " | Resultado: " + resposta +
                " | Data de Postagem: " + dataEnvio + " | " + horario);
        paciente.exibirInformacoes();
    }
}

class SistemaHospital {
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();

    public void cadastrarPaciente(String nome, String cpf, int idade, String telefone) {
        pacientes.add(new Paciente(nome, cpf, idade, telefone, telefone));
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void cadastrarResposta(String nome, String cpf, String dataEnvio, String resposta) {
        consultas.add(new Consulta(cpf, dataEnvio, resposta, resposta, resposta, resposta, resposta));
        System.out.println("Resultado da consulta enviado!");
    }

    public void agendarConsulta(String cpf, String data, String horario, String especialidade, String medico) {
        Paciente pacienteEncontrado = null;
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                pacienteEncontrado = p;
                break;
            }
        }
        if (pacienteEncontrado != null) {
            consultas.add(new Consulta(data, horario, especialidade, medico, medico, medico, medico));
            System.out.println("Consulta agendada com sucesso!");
        } else {
            System.out.println("Paciente não encontrado!");
        }
    }

    public void listarConsultasPaciente(String cpf) {
        boolean encontrou = false;
        for (Consulta c : consultas) {
            if (c.getCpfPaciente().equals(cpf)) {
                c.exibirDetalhes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma consulta encontrada para este CPF.");
        }
    }

    public void listarResultadoConsulta(String cpf) {
        boolean encontrou = false;
        for (Consulta c : consultas) {
            if (c.getCpfPaciente().equals(cpf)) {
                c.exibirDetalhes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma consulta encontrada para este CPF.");
        }
    }

}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaHospital sistema = new SistemaHospital();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Agendar Consulta");
            System.out.println("3 - Listar Consultas de um Paciente");
            System.out.println("4 - Listar Resultados da Consulta de um Paciente");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();
                sistema.cadastrarPaciente(nome, cpf, idade, telefone);

            } else if (opcao == 2) {
                System.out.print("CPF do paciente: ");
                String cpf = scanner.nextLine();
                System.out.print("Data (dd/mm/aaaa): ");
                String data = scanner.nextLine();
                System.out.print("Horário (hh:mm): ");
                String horario = scanner.nextLine();
                System.out.print("Especialidade: ");
                String especialidade = scanner.nextLine();
                System.out.print("Médico: ");
                String medico = scanner.nextLine();
                sistema.agendarConsulta(cpf, data, horario, especialidade, medico);

            } else if (opcao == 3) {
                System.out.print("CPF do paciente: ");
                String cpf = scanner.nextLine();
                sistema.listarConsultasPaciente(cpf);
            
            }    else if (opcao == 4) {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Resposta: ");
                    String resposta = scanner.nextLine();
                    System.out.print("Data de Envio: ");
                    String dataEnvio = scanner.nextLine();

                    sistema.cadastrarResposta(nome, cpf, dataEnvio, resposta);

            } else if (opcao == 5) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}