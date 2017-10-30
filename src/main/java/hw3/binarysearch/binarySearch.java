package hw3.binarysearch;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class binarySearch {
	 public static final int NOT_FOUND = -1;
	public static int binarySearch( Comparable [ ] a, Comparable x )
    {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while( low <= high )
        {
            mid = ( low + high ) / 2;

            if( a[ mid ].compareTo( x ) < 0 )
                low = mid + 1;
            else if( a[ mid ].compareTo( x ) > 0 )
                high = mid - 1;
            else
                return mid;
        }

        return NOT_FOUND;
    }


 public static void main(String[] args) throws Exception {
	   
    	
     
  Options options = new Options();

  Option input = new Option("type", "input", true, "input file to read data from");
  input.setRequired(true);
  input.setArgName("FILE PATH");
  options.addOption(input);

  Option output = new Option("key", "output", true, "output file to write the final result");
  output.setRequired(true);
  output.setArgName("FILE PATH");
  options.addOption(output);
  
 Option output2 = new Option("list", "output2", true, "output file to write the final result");
  output2.setRequired(true);
  output2.setArgName("FILE PATH");
  options.addOption(output2);

  CommandLineParser commandLineParser = new DefaultParser();

  CommandLine commandLine;
try{
  commandLine = commandLineParser.parse(options, args);

  String inputFilePath = commandLine.getOptionValue("input");
  String outputFilePath = commandLine.getOptionValue("output");
  String firstelement = commandLine.getOptionValue("output2");
  List<String> list = commandLine.getArgList();
  
  
  String [ ] a1 = new String [list.size()+1];
  a1[0]=firstelement;
  for (int i=1;i<list.size()+1;i++)
	  a1[i]=list.get(i-1);
 
  if(inputFilePath.compareTo("s")==0)
  {
	  int f = binarySearch(a1,outputFilePath);
	  if(f == -1)
		  System.out.println("0");
	  else
		  System.out.println("1");
  }
  else if(inputFilePath.compareTo("i")==0)
  {
	  int f = binarySearch(a1,outputFilePath);
  if(f == -1)
	  System.out.println("0");
  else
	  System.out.println("1");
  }
  else
	  System.out.println("Invalid Type.Please enter i for integers and s for strings");
	}

  catch( ParseException exp ) {
	    System.out.println( "Unexpected exception:" + exp.getMessage() );
	}
 
 }
 
 }