public static void main(){
    DatosBancarios datos1 = new DatosBancarios(1000.0);

    datos1.Depositar(500.0);
    System.out.println("Saldo actual: " + datos1.getSaldo());
}