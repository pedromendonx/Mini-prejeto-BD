package terminal;

import modelo.dao.consultaDao;
import modelo.dao.medicoDao;
import modelo.dao.pacienteDao;
import modelo.entidade.Consulta;
import modelo.entidade.Medico;
import modelo.entidade.Paciente;

import java.util.List;
import java.util.Scanner;

import java.time.LocalDateTime;

public class principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("-----------------------");
            System.out.println("00. Encerrar o programa");
            System.out.println("01. Cadastrar novo médico");
            System.out.println("02. Cadastrar novo paciente");
            System.out.println("03. Buscar médico por matrícula");
            System.out.println("04. Buscar paciente por CPF");
            System.out.println("05. Cadastrar uma nova consulta");
            System.out.println("06. Remover uma consulta");
            System.out.println("07. Atualizar horário da consulta");
            System.out.println("08. Gerar relatório de consultas");
            System.out.print("Escolha sua opção: ");
            int opcao = teclado.nextInt();
            teclado.nextLine();

            if (opcao == 0) {
                System.out.println("Saindo do programa...");
                break;
            } else if (opcao == 1) {
                Medico medico = new Medico();

                System.out.println("Digite o nome do médico: ");
                medico.setNome(teclado.nextLine());

                System.out.println("Digite a matricula do médico: ");
                medico.setMatricula(teclado.nextInt());
                teclado.nextLine();

                System.out.println("Digite a especialidade: ");
                medico.setEspecialidade(teclado.nextLine());

                System.out.println("Digite o salário do médico: ");
                medico.setSalario(teclado.nextFloat());
                teclado.nextLine();

                if (new medicoDao().adicionar(medico))
                    System.out.println("Médico adicionado com sucesso!");
                else
                    System.err.println("Erro ao cadastrar!!");
            } else if (opcao == 2) {
                Paciente paciente = new Paciente();

                System.out.println("Digite o nome do paciente: ");
                paciente.setNome(teclado.nextLine());

                System.out.println("Digite o CPF do paciente: ");
                paciente.setCpf(teclado.nextLine());

                System.out.println("Digite a doença do paciente: ");
                paciente.setDoenca(teclado.nextLine());

                if (new pacienteDao().adicionar(paciente))
                    System.out.println("Paciente salvo com sucesso!!");
                else
                    System.err.println("Erro ao cadastrar!!");
            } else if (opcao == 3) {

                System.out.println("Digite a matricula do médico (ex: 123456): ");
                int matricula = teclado.nextInt();

                Medico m = new medicoDao().BuscarPorMatricula(matricula);

                if (m == null)
                    System.out.println("Número não encontrado!!");
                else
                    System.out.println(m);
            } else if (opcao == 4) {
                System.out.println("Digite o CPF do paciente: ");
                String cpf = teclado.nextLine();

                Paciente p = new pacienteDao().BuscarPorCpf(cpf);

                if (p == null)
                    System.out.println("Número não encontrado!!");
                else
                    System.out.println(p);
            } else if (opcao == 5) {
                Consulta consulta = new Consulta();

                System.out.println("Digite a matricula do médico (ex: 123456): ");
                int matricula = teclado.nextInt();
                teclado.nextLine();

                Medico m = new medicoDao().BuscarPorMatricula(matricula);

                if (m == null) {
                    System.out.println("Número não encontrado!!");
                } else {
                    System.out.println(m);
                    System.out.println("Digite o CPF do paciente: ");
                    String cpf = teclado.nextLine();

                    Paciente p = new pacienteDao().BuscarPorCpf(cpf);

                    if (p == null) {
                        System.out.println("Número não encontrado!!");
                    } else {
                        System.out.println(p);
                        System.out.println("Digite o horário da consulta (ex: 12/03/2006 02:15)");
                        DateUtil.stringToDate(teclado.nextLine(), LocalDateTime.class);

                        System.out.println("Digite o valor da consulta: ");
                        consulta.setValor(teclado.nextFloat());

                        if (new consultaDao().adicionar(m.getMatricula(), p.getCpf(), consulta.getHorario(),
                                consulta.getValor()))
                            System.out.println("Consulta adicionado com sucesso!!");
                        else
                            System.out.println("Consulta já cadastrada!!");
                    }
                }
            } else if (opcao == 6) {
                Consulta consulta = new Consulta();

                System.out.println("Digite a matricula do médico (ex: 123456): ");
                int matricula = teclado.nextInt();
                teclado.nextLine();

                Medico m = new medicoDao().BuscarPorMatricula(matricula);

                if (m == null) {
                    System.out.println("Número não encontrado!!");
                } else {
                    System.out.println(m);
                    System.out.println("Digite o CPF do paciente: ");
                    String cpf = teclado.nextLine();

                    Paciente p = new pacienteDao().BuscarPorCpf(cpf);

                    if (p == null) {
                        System.out.println("Número não encontrado!!");
                    } else {
                        System.out.println(p);

                        System.out.println("Digite o horário da consulta (ex: 12/03/2006 02:15)");
                        DateUtil.stringToDate(teclado.nextLine(), LocalDateTime.class);

                        if (new consultaDao().remover(m.getMatricula(), p.getCpf(), consulta.getHorario()))
                            System.out.println("Consulta removida com sucesso!!");
                        else
                            System.out.println("consulta não cadastrada!!");
                    }
                }

            } else if (opcao == 7) {
                Consulta consulta = new Consulta();

                System.out.println("Digite a matricula do médico (ex: 123456): ");
                int matricula = teclado.nextInt();
                teclado.nextLine();

                Medico m = new medicoDao().BuscarPorMatricula(matricula);

                if (m == null) {
                    System.out.println("Número não encontrado!!");
                } else {
                    System.out.println(m);
                    System.out.println("Digite o CPF do paciente: ");
                    String cpf = teclado.nextLine();

                    Paciente p = new pacienteDao().BuscarPorCpf(cpf);

                    if (p == null) {
                        System.out.println("Número não encontrado!!");
                    } else {
                        System.out.println(p);

                        Consulta c = new Consulta();

                        System.out.println("Digite o horário da consulta (ex: 12/03/2006 02:15)");
                        DateUtil.stringToDate(teclado.nextLine(), LocalDateTime.class);

                        System.out.println("Digite o novo horario: ");
                        DateUtil.stringToDate(teclado.nextLine(), LocalDateTime.class);

                        if (new consultaDao().ConsultarConsulta(m, p, c)) {
                            System.out.println("Consulta Existe!!");

                            System.out.println("Digite o novo horario: ");
                            LocalDateTime novoHorario = DateUtil.stringToDate(teclado.nextLine(), LocalDateTime.class);

                            if (new consultaDao().atualizar(matricula, cpf, novoHorario))
                                System.out.println("Consulta atualizada!!");
                            else
                                System.out.println("Falha ao atualizar a consulta!!");
                        } else {
                            System.err.println("Consulta não encontrada!!");
                        }

                    }
                }

            } else if (opcao == 8) {
                List<Consulta> consulta = new consultaDao().listar();

                if (consulta.isEmpty())
                    System.out.println("Não a médico cadastrado!!");
                else
                    consulta.forEach(System.out::println);
            }
        }
    }
}