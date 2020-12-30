
package javaapplication10;

import java.util.Scanner;

/**
 *
 * @author adelf
 */
public class JavaApplication10 {

    
    
    int x;
    String numbers;
 int framesize=0;
 int pfault=0;
 char pageframe[];
 int c=0;
 
 Scanner n=new Scanner(System.in);
 
 public boolean search(char ch){
     
  for(int i=0;i<c;i++){
   char temp=pageframe[i];
   if(temp==ch){
    return true;
   }
  }
  return false;
 }
 int future(char ch, int pos){
  int b=numbers.length()+1;
  for(int i=pos+1;i<numbers.length();i++){
   char temp=numbers.charAt(i);
   if(temp==ch){
    if(i<b){
     b=i;
    }
   }
  }
  return b;
  
 }
 public void optimal(){
     System.out.println("Enter numbers");
  numbers=n.next();
  System.out.println("Enter Frame size");
  framesize=n.nextInt();
  pageframe=new char[framesize];
  System.out.println("Lenght="+numbers.length());
  for(int i=0;i <numbers.length();i++){
   char ch=numbers.charAt(i);
  if(search(ch)){
    
   }else{
  
    System.out.print("Page fault At index "+i);
    pfault++;
    
    if(c<framesize){
     pageframe[c]=ch;
     c++;
    }else{
     
     int optimal[]=new int[framesize];
     
     for(int j=0;j<framesize;j++){
      optimal[j]=future(pageframe[j],i);
     }
     
    int index=0;
     int max=optimal[0];
     for(int j=1;j<framesize;j++){
      if(optimal[j]>max){
       max=optimal[j];
       index=j;
      }
     }

     System.out.print(" and page "+ pageframe[index]+" is replaced by "+ch);
     pageframe[index]=ch;
     
    }
    System.out.println();
    
   }
   
 
  
  System.out.println("No. of Page fault="+pfault);
 }
 }
 void LRU(){
 Scanner sc=new Scanner(System.in);

  System.out.println("ENTER FRAME SIZE");
  int framesize=sc.nextInt();
  System.out.println("ENTER THE NUMBER OF PAGES");
  int num=sc.nextInt();
  int page[]=new int[num];
  int frame[]=new int[num];
  System.out.println("ENTER NUMBERS");
  for(int i=0;i<num;i++)
  page[i]=sc.nextInt();
  for(int i=0;i<framesize;i++)
  frame[i]=-1;
  for(int k=0;k<framesize;k++)
  System.out.print(" "+frame[k]);
  System.out.println();
  int m=0,hit=0,pagefault=0;
  int pageframes[]=new int[framesize];
  for(int i=0;i<framesize;i++)
  pageframes[i]=0;
  for(int j=0,i=0;j<framesize && i<num;j=j%framesize,i++)
  {
    m=0;
     
    for(int y=0;y<framesize;y++)
    {
    if(frame[y]==page[i])
    {
     m=1;
     hit++;
     pageframes[y]=0; 
    }
    }
    if(m==0)
    if(frame[j]==-1)
    { 
 
     frame[j]=page[i];
    pagefault++;
     j++;
    }
    else
     
    {
     int max=pageframes[0],h=0;
     pagefault++;


     for(int b=0;b<framesize;b++)
     if(pageframes[b]>max)
     {
     max=pageframes[b];h=b;
     }
     frame[h]=page[i];
     pageframes[h]=0;
     j++;
                                           } 
   for(int k=0;k<framesize;k++)
   System.out.print(" "+frame[k]);
   System.out.println();
   for(int a=0;a<framesize;a++)
     {
     if(frame[a]==-1)
     pageframes[a]=0;
     else
     pageframes[a]++;
     }

  }
  System.out.println("Hit="+hit+" pagefault="+pagefault);
  
 
    
 
 
 }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("1-optimal"
                + " /  "
               + "2-LRU");
        System.out.println("Enter the choice");
        
         int x=s.nextInt();
        JavaApplication10 obj=new JavaApplication10();
       
  if(x==1){
  obj.optimal();
  }
  if(x==2){
  
  obj.LRU();
  }
    }
    
}
