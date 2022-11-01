public class FluxoComErro {

  public static void main(String[] args) {
      System.out.println("Ini do main");
      try{
        metodo1();
      }catch(ArithmeticException | NullPointerException | MinhaExceção ex){
            String msg = ex.getMessage();
            System.out.println(msg);
            ex.printStackTrace();
      }
      System.out.println("Fim do main");
  }

  private static void metodo1() throws MinhaExceção{
      System.out.println("Ini do metodo1");
        metodo2();
      System.out.println("Fim do metodo1");
  }

  private static void metodo2() throws MinhaExceção{
      System.out.println("aaaaaa");
      metodo2();
  }
}