package hw3.binarysearch;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main  {
	
	public static void main(String[] args) {
		int returnValue = -1;
		
		Options options = new Options();
		Option typeOption = Option.builder("t").required().longOpt("type").hasArg().argName("TYPE").build();
		options.addOption( typeOption );
		
		Option keyOption = Option.builder("k").required().longOpt("key").hasArg().argName("KEY").build();
		options.addOption( keyOption );	
				
		Option listOption = Option.builder("l").required().longOpt("list").hasArgs().argName("LIST").build();
		options.addOption( listOption );
		
		
		CommandLineParser parser = new DefaultParser();	
		try {	
		    
		    CommandLine line = parser.parse( options, args );
		    String inputType = line.getOptionValue("type");
		    String inputKey = line.getOptionValue("key");
		    String[] inputList = line.getOptionValues("list");
		    if (inputType.equalsIgnoreCase("i")) {
		    	
		    	try {											
		    		Integer keyValue=Integer.parseInt(inputKey);
			    	int length= inputList.length;
			    	Integer[] listCopy= new Integer[length];
		    		for (int i = 0; i < length; i++) {
		    			listCopy[i]=Integer.parseInt(inputList[i]); 
			    	}
		    		
			    	if (binSearch(listCopy,keyValue)){
			    		returnValue = 1;
			    	}
			    	else {
			    		returnValue = 0;
			    	}
		    	} 
		    	catch (NumberFormatException numexcep) {
		    		    System.out.println("Incorrect Input! Exception: " + numexcep);
		    		    System.exit(1);
		    	}
		    }
		    else if (inputType.equalsIgnoreCase("s")) {
		    	String keyValue=inputKey;
		    	String[] listCopy=inputList;
		    	if (binSearch(listCopy,keyValue)){
		    		returnValue = 1;
		    	}
		    	else {
		    		returnValue = 0;
		    	}
		    }
		    System.out.println(returnValue);				
		}
		catch( ParseException e ) {
		    System.out.println("Unexpected exception:" + e.getMessage());
		}
		
	}
		
	private static <T extends Comparable<T>> boolean binSearch(T[] aList, T key) {
		int first = 0;						
		int last = aList.length - 1;		
		int mid = (first + last)/2;
		T middleValue=aList[mid];
		while (first <= last) {			
			if(key.compareTo(middleValue)==0){
				return true;				
			}
			else if (key.compareTo(middleValue)<0){
				
				last = mid-1	;		
			}
			else if (key.compareTo(middleValue)>0){
				first = mid+1;		
				
			}
			mid=(first+last)/2;
			middleValue=aList[mid];
		}
		return false;
	}
}
