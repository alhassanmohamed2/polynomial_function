import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;

public class poly_inf { 

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
    System.out.println("In the poly functuin you will write the equation like this"+"\n"+"(first cof , power of first x , second cof , power of second x,power of function)"+"\n"+"order function has the same except the order of the number"+"\n"+"the power function write the base and the power"+"\n"+"fictorial write the number directly"+"\n"+"combination write the two numbers of it"+"\n"+"write the numbers one after the other");
        System.out.println("poly=1 , orders=2 ,combination=3 ,fictorial=4 ,power=5");
        int k=in.nextInt();
        if (k==1){
        	System.out.println("is there any decimals in cof1 or cof2 =1 or intgers=2");
            int l=in.nextInt();
            if (l==1){
            	int d,h,j;
        		double c,f;
        c=in.nextDouble();
        d=in.nextInt();
        f=in.nextDouble();
        h=in.nextInt();
        j=in.nextInt();
        poly_decimal(c,d,f,h,j);
            }else if(l==2){
            	int d,h,j;
            	int c,f;
        c=in.nextInt();
        d=in.nextInt();
        f=in.nextInt();
        h=in.nextInt();
        j=in.nextInt();
        poly_intger(c,d,f,h,j);
            }
        	
       }else if(k==2){
            	System.out.println("is there any decimals in cof1 or cof2 =1 or intgers=2");
                int l=in.nextInt();
                if (l==1){
            	int d,h,j,o;
          double c,f;
          c=in.nextDouble();
      	  d=in.nextInt();
      	  f=in.nextDouble();
      	  h=in.nextInt();
      	  j=in.nextInt();
    	  o=in.nextInt();
    	  ord_decimal(c,d,f,h,j,o);}
                else if(l==2){
                	int d,h,j,o;
                    int c,f;
                    c=in.nextInt();
                	  d=in.nextInt();
                	  f=in.nextInt();
                	  h=in.nextInt();
                	  j=in.nextInt();
              	  o=in.nextInt();
              	  ord_intger(c,d,f,h,j,o);
                }
        }else if (k==3){
              int c,d;
              c=in.nextInt();
         	  d=in.nextInt();
      		  BigInteger t =C(c,d);
      		  System.out.println(t);
      	  }else if(k==4){
              int c;
              c=in.nextInt();
       		 BigInteger t =vic(c);
     		  System.out.println(t);
      	  }else if(k==5) {
      	System.out.println("Decimal in the base =1 or intger=2");
         int l=in.nextInt();
        if (l==1){
        	double o;
            int d;
    	      o=in.nextDouble();
           	  d=in.nextInt();
           	  BigDecimal t =pow_decimal(o,d);
           	System.out.println(t);
        }else if (l==2){
        	int o;
            int d;
    	      o=in.nextInt();
           	  d=in.nextInt();
           	BigInteger t =pow_intger(o,d);
           	
           	System.out.println(t);
        }
       }
        }
    		
	//power function
	public static BigDecimal  pow_decimal(double base , int power){
		BigDecimal r=new BigDecimal("1");
		for(int p =1 ; p<=power ; p ++){
            r = r.multiply(BigDecimal.valueOf(base));
}
		return r;
			}
	public static BigInteger  pow_intger(int base , int power){
		BigInteger r=new BigInteger("1");
		for(int p =1 ; p<=power ; p ++){
            r = r.multiply(BigInteger.valueOf(base));
}
		return r;
			}
	//factorial function
	 public static BigInteger vic(int x){
		 BigInteger y = new BigInteger("1") ;
		 	
		 for ( int i =1 ; i<=x ; i++){
	            y=y.multiply(BigInteger.valueOf(i));
	        }
	        return y;
}
	 //combination function
	 public static BigInteger C(int v, int d ){
		 
		 BigInteger x = vic(v);
		 BigInteger y = vic(v-d);
		 BigInteger z = vic(d);
		 BigInteger i = y.multiply(z);
		 BigInteger g = x.divide(i);
	//vic(v) / (vic(v-d)*vic(d))
 		return g;
 				}
	 //polynomial function
	 public static void poly_decimal(double first,int power_x1,double second ,int power_x2,int power){
		 BigDecimal u=new BigDecimal("1");		 
		 BigDecimal q=new BigDecimal("1");
 	for(int r=0 ; r<=power ; r++){
 		BigDecimal x,y;
 			BigInteger z;
 		x=pow_decimal(first,(power-r));
 		y=pow_decimal(second,(r));
 		z=C(power,r);
 		BigDecimal bd = BigDecimal.valueOf(z.intValue());
 		q=x.multiply(y).multiply(bd); 
 		int h=r*power_x2;
 		int j=(power-r)*power_x1;
     	System.out.println(q+" X^"+(h+j));
 	}
}
 	public static void poly_intger(int first,int power_x1,int second ,int power_x2,int power){
 				 
 		BigInteger q=new BigInteger("1");
	for(int r=0 ; r<=power ; r++){
		BigInteger x,y;
			BigInteger z;
		x=pow_intger(first,(power-r));
		y=pow_intger(second,(r));
		z=C(power,r);
		
		q=x.multiply(y).multiply(z); 
		int h=r*power_x2;
		int j=(power-r)*power_x1;
    	System.out.println(q+" X^"+(h+j));
		
}
		
}
	 //number Order polynomial function
	 public static void ord_decimal(double first ,int power_x1, double second,int power_x2 , int power,int order){
		
		 BigInteger x= C(power,order-1);
		 BigDecimal y = pow_decimal(first,power-(order-1));
		 BigDecimal z= pow_decimal(second,order-1);
	     BigDecimal bd = BigDecimal.valueOf(x.intValue());
	     BigDecimal ordered=y.multiply(z).multiply(bd);
		 int h=(order-1)*power_x2;
		 int j=(power-(order-1))*power_x1;
		System.out.println(ordered+" X^"+(h+j));

 	}
	 public static void ord_intger(int first ,int power_x1, int second,int power_x2 , int power,int order){
			
		 BigInteger x= C(power,order-1);
		 BigInteger y = pow_intger(first,power-(order-1));
		 BigInteger z= pow_intger(second,order-1);
		BigInteger ordered=y.multiply(z).multiply(x);
	     int h=(order-1)*power_x2;
		 int j=(power-(order-1))*power_x1;
		System.out.println(ordered+" X^"+(h+j));

 	}
}