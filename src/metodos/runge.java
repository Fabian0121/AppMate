
package metodos;

import java.math.BigDecimal;
import java.math.RoundingMode;


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
        //valored de k;
        BigDecimal aux1,aux2;
        BigDecimal a1,a2,a3,a4,a5,h,constante,c2,c3,k1,k2,k3,k4;
        double b;
        double redondeado;
        for (int i = 1; i < Xn.length; i++) {
            //Valores de K1
            //K1=hf(Xn-Yn)
            constante=new BigDecimal(2);
            h = new BigDecimal("0.025");
            aux1=new BigDecimal(Xn[i-1]);
            aux2=new BigDecimal(Va[i-1]);
            a1=aux1.multiply(aux2);
            a2=a1.multiply(constante).multiply(h);
            b= a2.floatValue();
            redondeado = redondear.redondeo6(b);
            a2 = new BigDecimal(redondeado);
            k1=a2;
            //K2=hf(xn-1+1/2h)(yn-1+1/2K1)
            c2 = new BigDecimal("0.5");
            a1=c2.multiply(h);
            a2=a1.add(aux1);
            //
            a1=c2.multiply(k1);
            a3=a1.add(aux2);
            a4=a2.multiply(a3);
            //
            a5=a4.multiply(h);
            b= a5.floatValue();
            redondeado = redondear.redondeo6(b);
            a5 = new BigDecimal(redondeado);
            k2=a5;
            //K3 hf(xn-1+1/2h)(yn-1+1/2h)
            c2 = new BigDecimal("0.5");
            a1=c2.multiply(h);
            a2=a1.add(aux1);
            //
            a1=c2.multiply(k2);
            a3=a1.add(aux2);
            a4=a2.multiply(a3);
            //
            a5=a4.multiply(h);
            b= a5.floatValue();
            redondeado = redondear.redondeo6(b);
            a5 = new BigDecimal(redondeado);
            k3=a5;
            //K4 hf(Xn-1+h)(Yn-1+K3)
            a1=aux1.add(h);
            a2=aux2.add(k3);
            a3=a1.multiply(a2);
            a4=h.multiply(a3);
            b= a4.floatValue();
            redondeado = redondear.redondeo6(b);
            a4 = new BigDecimal(redondeado);
            k4=a4;
            //Y Yn-1-1/6[k1+2k2+2k3+k4]
            a1=constante.multiply(k2);    
            a2=constante.multiply(k3);
            a3=k1.add(a1).add(a2).add(k4);
            //
            BigDecimal a,d,e;
            c3= new BigDecimal(0.16666666666);
            a4=c3.multiply(a3);
            b= a4.floatValue();
            redondeado = redondear.redondeo10(b);
            a4= new BigDecimal(redondeado);
            a5=aux2.add(a4);
            b= a5.floatValue();
            redondeado = redondear.redondeo4(b);
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
