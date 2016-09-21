package fcrs.pooed2.abstratas;

/**
*
* @author Josimar Junior
*/
public abstract class GeraSenha {

   private static int senhaGestante;
   private static int senhaIdoso;
   private static int senhaCaixaNormal;
   private static int senhaCaixaRapido;
   
   public static String geraSenhaGestante() {
       senhaGestante++;
       return "G - " + senhaGestante;
   }
   
   public static String geraSenhaIdoso() {
       senhaIdoso++;
       return "I - " + senhaIdoso;
   }
   public static String geraSenhaCaixaNormal() {
       senhaCaixaNormal++;
       return "CN - " + senhaCaixaNormal;
   }
   public static String geraSenhaCaixaRapido() {
       senhaCaixaRapido++;
       return "CR - " + senhaCaixaRapido;
   }
}
