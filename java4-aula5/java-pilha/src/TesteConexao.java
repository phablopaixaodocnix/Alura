public class TesteConexao {
  public static void main(String[] args) {
    /*Conexao con = null;
    try{
      con = new Conexao();
      con.leDados(); 
    } catch(IllegalStateException exception){
      System.out.println("chegou no catch");
    }finally{
      con.fecha();
    }*/


    try(Conexao conexao = new Conexao()){ //automaticamente executa o método close, pois implementa a interface autoCloseable. Consequentemente não é necessário o finally
      conexao.leDados();
    } catch(IllegalStateException exception){
      System.out.println("Erro");
    }
  }
}
