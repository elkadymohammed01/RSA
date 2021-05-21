package Main;
import java.util.*;
import java.io.*;
public class Main {
	//  Solution 
	// by Mohammed M Elkady

	  static double P,Q,N,eur,E,D;
	  static double Message,UnMessage;
   public static void main(String args[]){
	P=3;Q=7;N=P*Q;eur=(P-1)*(Q-1);
	// N=77 eur=60
	E=getE(eur);
	D=getD(E, eur);
	for(int i=0;i<N;i++) {
	Message=i;
	UnMessage =Encryption((long)E, N, Message);
	System.out.println("UNMessage "+UnMessage);
	Message=Encryption((long)D,N,UnMessage);
	Message%=N;
	System.out.println("Message"+Message);}
   }
   static Double Encryption(long e,double mod,double mes) {
	   if(e==1)
		   return mes;
	   if(e%2==0) {
		   double lop =Encryption(e/2, mod, mes)%mod;
		   return (lop*lop)%mod;}
	   double lop =Encryption(e/2, mod, mes)%mod;
	   return (lop*lop*mes)%mod;
   }
   static Double getE(double eur) {
	   if(eur%2!=0)
	   return 2.0;
	   else {
		   for(double i=3;i<eur;i+=2) {
			  if(GCD(eur,i)==1)
				  return i;
		   }
		   return 0.0;
	   }
   }
   static Double getD(double E,double eur) {
	   double D=(1 + (2*eur))/E;
	   return D;
   }
   static Double GCD(double A,double B) {
	   if(B==0)
		   return A;
	   else
		   return GCD(B,A%B);
   }
   
}