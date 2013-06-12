/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Jan
 */

public class EnumCollection {
    
    
    public static timeLineType fromStringTimeLineType(String text) {
    if (text != null) {
      for (timeLineType b : timeLineType.values()) {
        if (text.equalsIgnoreCase(b.toString())) {
          return b;
        }
      }
    }
    return null;
  }   
    
     public enum timeLineType{        
        bloedDrukMeting,
        rapport,
        anamnese,
        afspraak,
        behandeling,
        checkUp,
        metingPatient    
    }
    
}
