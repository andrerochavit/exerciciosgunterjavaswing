package spring;

class Carro extends Veiculo {
    private String combustivel;
    
    public Carro(String marca, String modelo, int ano, String combustivel) {
        super(marca, modelo, ano);
        this.combustivel = combustivel;
    }
    
    public String getCombustivel() {
        return combustivel;
    }
    
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    
    @Override
    public String toString() {
        return "Carro - " + super.toString() + " - Combustível: " + combustivel;
    }
}