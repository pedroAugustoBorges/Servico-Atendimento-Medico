package test;

import model.entites.Paciente;
import model.services.AtendimentoMedicoServices;

import java.time.LocalDateTime;

public class AtendimentoMedicoTest {
    public static void main(String[] args) {


        Paciente paciente1 = new Paciente("Pedro", 1);
        Paciente paciente2 = new Paciente("Taina", 4);
        Paciente paciente3 = new Paciente("Joao", 3);
        Paciente paciente4 = new Paciente("Yasmin", 2);
        Paciente paciente5 = new Paciente("Cleber", 1);
        Paciente paciente6 = new Paciente("Felipe", 5);



        AtendimentoMedicoServices atendimentoMedicoServices = new AtendimentoMedicoServices(paciente1.relationPrioridade(), paciente1, LocalDateTime.now());

        AtendimentoMedicoServices atendimentoMedicoServices2 = new AtendimentoMedicoServices(paciente3.relationPrioridade(), paciente3, LocalDateTime.now());
        AtendimentoMedicoServices atendimentoMedicoServices3= new AtendimentoMedicoServices(paciente4.relationPrioridade(), paciente4, LocalDateTime.now());
        AtendimentoMedicoServices atendimentoMedicoServices4 = new AtendimentoMedicoServices(paciente6.relationPrioridade(), paciente6, LocalDateTime.now());

        System.out.println(atendimentoMedicoServices);
        System.out.println();
        System.out.println(atendimentoMedicoServices2);
        System.out.println();
        System.out.println(atendimentoMedicoServices3);
        System.out.println();
        System.out.println(atendimentoMedicoServices4);

    }




}
