
package metodos;

import java.math.BigDecimal;


public class runge {
    /*
    Xn= Valores de Xn
    Va= Valores aproximados 
    Vr= Valores reales
    Error= Valores de error Vr-Va
    Error Relativo= Valores relativos de (Vr-Va/Vr)*100
    */
    //
    private double []Xn=new double[21];
    private double []Va=new double[21];
    private double []Vr=new double[21];
    private double []Error=new double[21];
    private double []errorR=new double[21];
    public double a;
    public double a1;
    public double a2;
    public double a3;
    public redondeo redondear = new redondeo();
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
        //
        double valor1=1;
        Xn[0]=valor1;
        //
        double valor =1;
        Va[0]= valor;
        //
        double b1=2;
        double redondeado;
        for (int i = 1; i < Xn.length; i++) {
            //Sumas y multiplicacion
            a1=b1*Va[i-1]*Xn[i-1];
            redondeado =redondear.redondeo4(a1);
            
            a2=0.025*redondeado;
            redondeado =redondear.redondeo4(a2);

            a3=Va[i-1]+redondeado;
            redondeado = redondear.redondeo4(a3);
            Va[i]=redondeado;
        }
        return Va;
    }
    //Calcular Valor Real
    public double[] valorReal()
    {
        //Se agrega el valor de inicio a todas las tablas
        double valor1=1;
        Vr[0]=valor1;

        double redondeado;
        for (int i = 1; i < Xn.length; i++) {
            
            a1=Math.pow(Xn[i], 2);
            redondeado = redondear.redondeo4(a1);
            
            a2=redondeado-1;
            redondeado = redondear.redondeo4(a2);
            
            a3=Math.pow(2.7183, redondeado);
            redondeado = redondear.redondeo4(a3);
            
            Vr[i]=redondeado;
        }
        return Vr;
    }
    //Calcular error
    public  double[] error()
    {
        double redondeado;
        for (int i = 0; i < Xn.length; i++) {
            
            a1=Vr[i]-Va[i];
            
            redondeado = redondear.redondeo4(a1);
            Error[i]=redondeado;
            
        }
        return Error;
    }
    //Calcular errorRelativo
    public  double[] errorRelativo(){

        double redondeado ;
        
        for (int i = 0; i < Xn.length; i++) {
            
            a=Vr[i]-Va[i];
            redondeado= redondear.redondeo4(a);
            
            a2=redondeado/Vr[i];
            redondeado = redondear.redondeo4(a2);
            
            a3=redondeado*100;
            redondeado = redondear.redondeo4(a3);

            errorR[i]=redondeado;
        }
        return errorR;
    }
}
