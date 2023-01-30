public class Main {
  public static void main(String[] args) {

    Singelton singelton = Singelton.getInstance();
    Singelton singelton2 = Singelton.getInstance();

    singelton.setContador(30);
    singelton2.setContador(60);

    System.out.println(singelton);
    System.out.println(singelton.contador);
    System.out.println(singelton2.contador);
  }
}