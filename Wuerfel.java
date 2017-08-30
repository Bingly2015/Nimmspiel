package nimmspiel;
/**
 *  Die Anzahl der Steine wurde erstellt;
 * @author Bing und Josy
 *
 */
public class Wuerfel {
	/**
	 *   diese Feld wird nicht benutzt,
	 */
	private static  int min=1;
	private static   int max=6;
	
private static int augen;


public Wuerfel(){
	
	
	
}
 
/**
 * 
 * @return wie viele Steine gibt es;
 */
 public static int getAugen(){
	 
	 return augen;
	 
 }
 /**
  *   
  * @return  die  Anzahl der Steine wurde gestellt; 
  */
 public static  float wuerfel(){
	    return min+((float) Math.random()*(max-min));
	   	 }
 
 //	static int wuerfel() {
   //  return (int)(Math.random() * (double)(max - min +1)) + min;
 //}

}
