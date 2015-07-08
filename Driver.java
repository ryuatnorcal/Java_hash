/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java_hash;

import java.util.Hashtable;
import java.util.Random;

/**
 *  This practice is mock interview question that I made up 
 *  Question : 
 *  given array contain huge char sets, find occurance of the same array set 
 *  [Try to use ] 
 *  Hashtable<K,V> http://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html
 *  Map <k,v> http://docs.oracle.com/javase/7/docs/api/java/util/Map.html
 *  
 * @author Ryu
 *
 */
public class Driver {
  public static void main(String str[]){
		Hashtable<Integer,Integer> hash = new Hashtable<>(); 
    
    
		Character[] alphaData = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Random randomGenerator = new Random();
		int randInt = 0;
		int count = 0;
		int array_size = 1000;
    Character[] data = new Character[array_size];
    
		System.out.println("Original Array data[] = {");
	    for (int i = 0; i < array_size; i++){
	      randInt = randomGenerator.nextInt(26);
	      data[i] = alphaData[randInt];	 	    
	      System.out.printf("\'%s\',",data[i]);
	      if(count == 30){
	    	  System.out.println("\'"+data[i]+"\',");
	    	  count = 0;
	      }
	      count++;
	    }
	    System.out.println("}");
      
    /*************************************************
    * Insert data into hash
    ************************************************/
      int key = 0;
      int value = 0;
    for(int x = 0; x < array_size; x++){
      key = data[x].hashCode() - 97;         
      
      if(hash.containsKey(key)){
        value = hash.get(key) + 1;
        hash.put(key, value);
      }else{
        hash.putIfAbsent(key, 1);
      }  
    }
     int size = 0;
    for(int i = 0; i < 26 ; i++){
      System.out.println("occurrence of "+alphaData[i] + " : "+ hash.get(i));
    }
	}
}
