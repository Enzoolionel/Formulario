public class Singelton {
  private static Singelton singelton;
  int contador = 0;

  private Singelton() { }

  public static Singelton getInstance(){
    if (singelton == null){
      singelton = new Singelton();
    }
    return singelton;
  }

  public int getContador() {
    return contador;
  }

  public void setContador(int contador) {
    this.contador = contador;
  }
}
