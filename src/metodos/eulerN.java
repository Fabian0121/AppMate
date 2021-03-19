
package metodos;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class eulerN {
    /*
    Xn= Valores de Xn
    Va= Valores aproximados 
    Vr= Valores reales
    Error= Valores de error Vr-Va
    Error Relativo= Valores relativos de (Vr-Va/Vr)*100
    */
    private double []Xn=new double[21];
    private double []Va=new double[21];
    private double []Vr=new double[21];
    private double []Error=new double[21];
    private double []errorR=new double[21];
    //Calcular valores de Xn
    public  double[] calcularx()
    {   
        //Se le da valor al arreglo Xn en 0
        double valor1=1;
        Xn[0]=valor1;
        //Estas funciones guardar los valores en decimal, para darlos exactos
        BigDecimal x = new BigDecimal("1");
        BigDecimal ha = new BigDecimal("0.025");
        Double dob1;
        //Este for recorreo todo para guardarlo en arreglo
        for (int i = 0; i < 20; i++) {
            //Suma de valores
            x= x.add(ha);
            //Se guardan en double
            dob1 = x.doubleValue();
            Xn[i+1]=dob1;
        }
        return Xn;
    }
    //Calcular Y
    public  double[] calcularY()
    {
        double valor1=1;
        Xn[0]=valor1;
         //
        double valor =1;
        Va[0]= valor;
        double b1=2;
        double redondeado;
        for (int i = 1; i < Xn.length; i++) {
            //Variables
            //Sumas y multiplicacion
            double a1=b1*Va[i-1]*Xn[i-1];
            redondeado = new BigDecimal(a1)
                                    .setScale(4, RoundingMode.HALF_EVEN).doubleValue();
            a1=redondeado;
            double a2=0.025*a1;
            redondeado = new BigDecimal(a2)
                                    .setScale(4, RoundingMode.HALF_EVEN).doubleValue();
            a2=redondeado;
            double a3=Va[i-1]+a2;
            redondeado = new BigDecimal(a3)
                                    .setScale(4, RoundingMode.HALF_EVEN).doubleValue();
            Va[i]=redondeado;
        }
        return Va;
    }
    //Calcular Valor Real
    public double[] valorReal()
    {
        double valor1=1;
        Vr[0]=valor1;
        double a1;
        double a2;
        double a3;
        double redondeado;
        for (int i = 1; i < Xn.length; i++) {
            a1=Math.pow(Xn[i], 2);
             redondeado = new BigDecimal(a1)
                                    .setScale(4, RoundingMode.HALF_EVEN).doubleValue();
            a1=redondeado;
            a2=a1-1;
            redondeado = new BigDecimal(a2)
                                    .setScale(4, RoundingMode.HALF_EVEN).doubleValue();
            a2=redondeado;
            a3=Math.pow(2.7183, a2);
            redondeado = new BigDecimal(a3)
                                    .setScale(4, RoundingMode.HALF_EVEN).doubleValue();
            Vr[i]=redondeado;
        }
        return Vr;
    }
    //Calcular error
    public  double[] error()
    {
        double a1;
        for (int i = 0; i < Xn.length; i++) {
            a1=Vr[i]-Va[i];
            double redondeado = new BigDecimal(a1)
                                    .setScale(4, RoundingMode.HALF_EVEN).doubleValue();
            Error[i]=redondeado;
        }
        return Error;
    }
    //Calcular errorRelativo
    public  double[] errorRelativo(){
        double a;
        double a2;
        double a3;
        double Yn;
        double redondeado ;
        for (int i = 0; i < Xn.length; i++) {
            a=Vr[i]-Va[i];
            redondeado= new BigDecimal(a)
                                    .setScale(4, RoundingMode.HALF_DOWN).doubleValue();
            a=redondeado;
            a2=a/Vr[i];
            redondeado = new BigDecimal(a2)
                                    .setScale(4, RoundingMode.HALF_DOWN).doubleValue();
            a3=redondeado*100;
            redondeado = new BigDecimal(a3)
                                    .setScale(2, RoundingMode.HALF_DOWN).doubleValue();
            a3=redondeado*100;
            errorR[i]=redondeado;
        }
        return errorR;
    }
    
}
