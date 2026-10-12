public class DatosBancarios {
    private double Saldo;

    public DatosBancarios(double saldo){
        this.Saldo = saldo;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void Depositar(double cantidad){
        this.Saldo += cantidad;
    }
}