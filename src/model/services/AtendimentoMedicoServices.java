package model.services;

import model.entites.Paciente;
import model.entites.PrioridadeEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class AtendimentoMedicoServices {

    private PrioridadeEnum prioridadeEnum;
    private Paciente pacientes;
    private LocalDateTime entrada;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    public AtendimentoMedicoServices(PrioridadeEnum prioridadeEnum, Paciente pacientes, LocalDateTime entrada) {
        this.prioridadeEnum = prioridadeEnum;
        this.pacientes = pacientes;
        this.entrada = entrada;
    }

    public PrioridadeEnum getPrioridadeEnum() {
        return prioridadeEnum;
    }

    public void setPrioridadeEnum(PrioridadeEnum prioridadeEnum) {
        this.prioridadeEnum = prioridadeEnum;
    }

    public Paciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime exitEstimated (LocalDateTime entrada){
        return entrada.plusMinutes(prioridadeEnum.getMinutos());
    }

    @Override
    public String toString() {


        String nome = Optional.ofNullable(pacientes)
                .map(Paciente::getNome)
                .orElse("Nome não disponivel");


        String relationType = getPrioridadeEnum().name();

        return String.format("Paciente: %s \nPrioridade: %d \nTipo prioridade: %s \nTempo de espera estimado: %d \nHora estimada para atendimento: %s",
                nome, pacientes.getPrioridade(), relationType, prioridadeEnum.getMinutos(), exitEstimated(entrada).format(dtf));



    }
}
