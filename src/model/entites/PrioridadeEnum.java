package model.entites;

public enum PrioridadeEnum {

    EMERGENCIA(1, 0),
    MUITO_URGENTE(2, 15),
    URGENTE(3,30),
    POUCO_URGENTE(4, 60),
    NÃO_URGENTE(5, 120);

    private int prioridade;
    private int minutos;


    PrioridadeEnum(int prioridade, int minutos) {
        this.prioridade = prioridade;
        this.minutos = minutos;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}
