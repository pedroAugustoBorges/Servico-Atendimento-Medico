package model.entites;

import java.util.Objects;

public class Paciente implements Comparable<Paciente> {

    private String nome;
    private  int prioridade;
    private PrioridadeEnum prioridadeEnum;

    public Paciente(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public PrioridadeEnum getPrioridadeEnum() {
        return prioridadeEnum;
    }

    public void setPrioridadeEnum(PrioridadeEnum prioridadeEnum) {
        this.prioridadeEnum = prioridadeEnum;
    }

    public PrioridadeEnum relationPrioridade (){

        for (PrioridadeEnum tipo : PrioridadeEnum.values()){
            if (tipo.getPrioridade() == getPrioridade()){
                return tipo;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente pacientes = (Paciente) o;
        return prioridade == pacientes.prioridade && Objects.equals(nome, pacientes.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, prioridade);
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "nome='" + nome + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }

    @Override
    public int compareTo(Paciente e) {
        return Integer.compare(prioridade, e.getPrioridade());
    }
}
