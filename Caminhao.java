package spring;

class Caminhao extends Veiculo {
    private double capacidadeCarga;
    
    public Caminhao(String marca, String modelo, int ano, double capacidadeCarga) {
        super(marca, modelo, ano);
        this.capacidadeCarga = capacidadeCarga;
    }
    
    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }
    
    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
    
    @Override
    public String toString() {
        return "Caminhão - " + super.toString() + " - Capacidade de carga: " + capacidadeCarga;
    }
}
