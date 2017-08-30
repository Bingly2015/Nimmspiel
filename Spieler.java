package nimmspiel;

/**
 * 
 * @author Bing und Josy
 *
 */
public class Spieler {
	/**
	 *   name = name der Spieler
	 */
  private  String name;
   public Spieler(String newName){
	   name=newName;}
   
   /**
    * 
    * @param newName input  a new name 
    * @return Name
    */
   public String setName(String newName){
	   return newName;
   }
  /**
   * 
   * @return
   */
	 public String getName(){
		 return name;
	   
   }
}
