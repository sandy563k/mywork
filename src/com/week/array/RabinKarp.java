package com.week.array;


	/**
	 * Java Program to Implement Rolling Hash
	 **/
	 
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.io.IOException;
	import java.util.Random;
	import java.math.BigInteger;
	 
	public class RabinKarp {
	
	    /** String Pattern **/
	    private String pat; 
	    /** pattern hash value **/    
	    private long patHash;    
	    /** pattern length **/
	    private int patlength;  
	    /** Large prime **/         
	    private long largePrime; 
	    /** radix **/         
	    private int radix;   
	    /** R^(M-1) % Q **/        
	    private long RM;          
	 
	    /** Constructor **/
	    public RabinKarp(String txt, String pat) 
	    {
	        this.pat = pat;      
	        radix = 256;
	        patlength = pat.length();
	        largePrime = longRandomPrime();
	        /** precompute R^(M-1) % Q for use in removing leading digit **/
	        RM = 1;
	        for (int i = 1; i <= patlength-1; i++)
	           RM = (radix * RM) % largePrime;
	        patHash = hash(pat, patlength);
	        int pos = search(txt);
	        if (pos == txt.length())
	            System.out.println("\nNo Match\n");
	        else
	            System.out.println("Pattern found at : "+ pos);
	    } 
	    /** Compute hash **/
	    private long hash(String key, int M)
	    { 
	        long h = 0; 
	        for (int j = 0; j < M; j++) 
	            h = (radix * h + key.charAt(j)) % largePrime; 
	        return h; 
	    } 
	    /** Funtion check **/
	    private boolean check(String txt, int i) 
	    {
	        for (int j = 0; j < patlength; j++) 
	            if (pat.charAt(j) != txt.charAt(i + j)) 
	                return false; 
	        return true;
	    }
	    /** Funtion to check for exact match**/
	    private int search(String txt) 
	    {
	        int N = txt.length(); 
	        if (N < patlength) return N;
	        long txtHash = hash(txt, patlength); 
	        /** check for match at start **/
	        if ((patHash == txtHash) && check(txt, 0))
	            return 0;
	        /** check for hash match. if hash match then check for exact match**/
	        for (int i = patlength; i < N; i++) 
	        {
	            // Remove leading digit, add trailing digit, check for match. 
	            txtHash = (txtHash + largePrime - RM*txt.charAt(i - patlength) % largePrime) % largePrime; 
	            txtHash = (txtHash * radix + txt.charAt(i)) % largePrime; 
	            // match
	            int offset = i - patlength + 1;
	            if ((patHash == txtHash) && check(txt, offset))
	                return offset;
	        }
	        /** no match **/
	        return N;
	    }
	    /** generate a random 31 bit prime **/
	    private static long longRandomPrime() 
	    {
	        BigInteger prime = BigInteger.probablePrime(31, new Random());
	        return prime.longValue();
	    }
	
	 

	    public static void main(String[] args) throws IOException
	    {    
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Rolling Hash Test\n");
	        System.out.println("\nEnter Text\n");
	        String text = br.readLine();
	        System.out.println("\nEnter Pattern\n");
	        String pattern = br.readLine();
	        System.out.println("\nResults : \n");
	        RabinKarp rk = new RabinKarp(text, pattern);        
	    }
	
}
