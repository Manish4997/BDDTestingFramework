package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.time.StopWatch;

import com.opencsv.CSVReader;  
/*
 This Class has the methods of different ways to read a CSV file using BufferedReader, Apache.commons.csv and OpenCSV
 */
public class CsvUtilities {
   
//Parsing using bufferedreader without using java stream
public static void CsvReaderbuffer(String FolderPath)
{
	
	try {
	File folder = new File(FolderPath);
	File [] fileList = folder.listFiles();
	
	for (File file: fileList) {
		
			BufferedReader br=new BufferedReader(new FileReader(file), 1024*1024);
		    String line;
		    System.out.println(br.readLine());
			while((line=br.readLine())!=null) {
//		    	System.out.println(line);
		    }
	
	}
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
}
public static void CSVBufferStreamReader(String folderPath) throws IOException {
	
	File folder = new File(folderPath);
	File [] fileList = folder.listFiles();
	
	for(File  file : fileList) {
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file), 1024 * 1024);
			br.lines().skip(1).forEach(System.out::println);
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
@SuppressWarnings("deprecation")
public static void CSVapacheCommonsReader(String FolderPath)
{
	try {
		
	
	File folder = new File(FolderPath);
	File [] fileList = folder.listFiles();
	for(File file: fileList) {
	
		BufferedReader br =new BufferedReader(new FileReader(file));
	
	CSVFormat csvformat = CSVFormat.RFC4180.withFirstRecordAsHeader().builder().setSkipHeaderRecord(true).setIgnoreEmptyLines(true).build();
	Iterable<CSVRecord> csvRecords= csvformat.parse(br); 
	
	for(CSVRecord record:csvRecords) {
	    System.out.println(record.getRecordNumber());
		System.out.println(record.get("YEAR"));
		System.out.println(record.get(1));
		System.out.println(record.get(2));
		System.out.println(record.get(3));
		System.out.println(record.get(4));
		System.out.println(record.get(5));
		System.out.println(record.get(6));
	}
	br.close();
	}
	
	
	

}
catch(Exception e) {
	e.printStackTrace();
}	
}
public static void OpenCsvReader(String FolderPath) {
	try {
	File folder = new File(FolderPath);
	File [] fileList = folder.listFiles();
	for(File file: fileList) {
		BufferedReader br =new BufferedReader(new FileReader(file));
		CSVReader csvReader=new CSVReader(br);
        String[] nextRecord;
     
        // we are going to read data line by line
        while ((nextRecord = csvReader.readNext()) != null) {
            for (String cell : nextRecord) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
	br.close();
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	}

public static void main(String [] args) {
	
	String folderPath = System.getProperty("user.dir")+"//"+"SampleFiles/CSV";
	StopWatch watch= new StopWatch();
	watch.start();
	CsvReaderbuffer(folderPath);
//	CSVBufferStreamReader(folderPath);
//	CSVapacheCommonsReader(folderPath);
//	OpenCsvReader(folderPath);
	watch.stop();
	System.out.println(watch.getTime(TimeUnit.MILLISECONDS));
	
	
	
}



}
