import entity.PessoaConta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PessoaConta pc = null;

        System.out.println("Olar, seja bem vindo ao banco B!\n" +
                "No caso de já possuir conta tecle 1 ou 2 para criar uma conta:");
        int op = sc.nextInt();
        int aux = 0;
        if(op == 2){

             System.out.println("Nome: ");
             sc.nextLine();
             String nome = sc.nextLine();
             System.out.println("Sobrenome: ");
             String sobrenome = sc.nextLine();
             System.out.println("CPF: ");
             String cpf = sc.nextLine();
             pc = (new PessoaConta(nome,sobrenome,cpf));
             System.out.println("Parabéns!\n" +
                        "Agora se quiser logar tecle 1 ou qualquer outro para sair");
             op = sc.nextInt();

        }
        if(op == 1){
            do{
                System.out.printf("Olar, %s\n", pc.getNome());
                System.out.println("gostaria de acessar os seus dados? 1 sim ou 2 para consultar o seu saldo\n" +
                        "Caso queira continuar tecle qualquer outro numero");
                int ac = sc.nextInt();

                if(ac == 1){
                    System.out.printf("Nome : %s %s, dono do cpf: %s\n",pc.getNome(),pc.getSobrenome(),pc.getCpf());
                }
                else if(ac == 2){
                    System.out.printf("Saldo: %.2f\n",pc.getSaldo());
                }
                System.out.println("gostaria de fazer um saque, tecle 1 mas se for deposito tecle 2");
                ac = sc.nextInt();

                while (ac == 1 || ac ==2){
                    int resp = 0;

                    if(ac == 1){
                        double saque =0;
                        System.out.printf("Seu saldo atual é de %.2f\n", pc.getSaldo());
                        System.out.println("Nós informe o valor do saque:");
                        saque = sc.nextDouble();
                        if(pc.getSaldo() < saque){
                            System.out.println("Saque superior ao saldo atual, porfavor selecione um valor valido");
                            System.out.printf("Seu saldo atual é de %.2f\n", pc.getSaldo());
                        }else {
                            pc.sacar(saque);
                            System.out.printf("Seu saldo atual é de %.2f\n", pc.getSaldo());
                        }
                        resp = 1;
                    }
                    else if(ac == 2){
                        double dep = 0;
                        System.out.println("Nós informe o valor de deposito:");
                        dep = sc.nextDouble();
                        pc.depositar(dep);
                        System.out.println();
                        System.out.printf("Deposito feito com sucesso %.2f\n",pc.getSaldo());
                        resp = 2;
                    }
                    if(resp == 1){
                        System.out.println("Gostaria de fazer um saque novamente? tecle 1 ou 2 para depositar ou " +
                                "0 para finalizar");
                        ac = sc.nextInt();
                    }
                    else if(resp == 2){
                        System.out.println("Gostaria de fazer um deposito novamente? tecle 2 ou 1 para sacar ou " +
                                "0 para finalizar");
                        ac = sc.nextInt();
                    }
                }
                System.out.println("Gostaria de repetir a seção? tecle 1, não tecle 0");
                aux = sc.nextInt();

            }while(aux == 1);
        }else {
            System.out.println("Adeus! volte sempre");
        }
    }
}