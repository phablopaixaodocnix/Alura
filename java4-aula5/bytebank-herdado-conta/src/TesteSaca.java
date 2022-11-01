public class TesteSaca {
  public static void main(String[] args) {
    Conta conta = new ContaCorrente(100, 1000);
    conta.deposita(1000);
    try{
      conta.saca(2000);
    }catch(SaldoInsuficienteException ex){
      System.out.println(ex.getMessage());
    }
    System.out.println(conta.getSaldo());
  }
  
}
