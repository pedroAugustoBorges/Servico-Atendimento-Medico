package test;

import model.entites.Paciente;
import model.entites.PrioridadeEnum;
import model.services.AtendimentoMedicoServices;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public class AtendimentoMedicoTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Paciente> pacientes = new ArrayList<>();

        System.out.println("Seja bem vindo a central de serviços!");
        System.out.println();

        while (true){


            System.out.println("Insira os dados do paciente ou 'sair'");

            System.out.println("Insira o nome do paciente:");

            String name = input.nextLine().trim();


            if (name.equalsIgnoreCase("sair")){
                break;
            }

            System.out.println("Insira o nivel de prioridade com base no numero: ");

            menuPrioridades();

            int prioridade = input.nextInt();
            input.nextLine();

            LocalDateTime ldt = LocalDateTime.now();

            Paciente paciente = new Paciente(name, prioridade);
            pacientes.add(paciente);

            PrioridadeEnum prioridadeEnum = paciente.relationPriority();

            AtendimentoMedicoServices service = new AtendimentoMedicoServices(prioridadeEnum, paciente, ldt );

            System.out.println();
            System.out.println(service);

            System.out.println();



        }

        pacientes.sort(Paciente::compareTo);

        System.out.println(filter(pacientes, paciente -> paciente.getPrioridade() <= 2));






    }

    public static void menuPrioridades (){
        System.out.println("1- Emergencia");
        System.out.println("2- Muito urgente");
        System.out.println("3- Urgente");
        System.out.println("4- Pouco urgente");
        System.out.println("5- Não urgente");
    }

    public static <T> List<T> filter (List <T> list, Predicate <T> predicate){

        List<T> result = new ArrayList<>();

       for (T t:list){
           if (predicate.test(t)){
               result.add(t);
           }
       }


        return result;

    }





}
