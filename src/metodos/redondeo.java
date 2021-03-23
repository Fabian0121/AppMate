
package metodos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class redondeo {
    public double redondeo;
    //Metodo para redondear a 4
    public double redondeo4(double valor){
        redondeo = new BigDecimal(valor)
                                    .setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        return redondeo;
    }
    //Metodo para redondear a 2
    public double redondeo2(double valor){
        redondeo = new BigDecimal(valor)
                                    .setScale(4, RoundingMode.HALF_EVEN).doubleValue();
        return redondeo;
        
    }
    //Metodo para redondear a 10
    public double redondeo9(double valor){
        redondeo = new BigDecimal(valor)
                                    .setScale(9, RoundingMode.HALF_EVEN).doubleValue();
        return redondeo;
        
    }
    //Metodo para redondear a 10
    public double redondeo6(double valor){
        redondeo = new BigDecimal(valor)
                                    .setScale(6, RoundingMode.HALF_EVEN).doubleValue();
        return redondeo;
        
    }
    //
}
