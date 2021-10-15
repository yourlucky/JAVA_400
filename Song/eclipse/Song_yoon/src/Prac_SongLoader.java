import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;



public class Prac_SongLoader  {


    public List<String> loadFile(String csvFilePath) throws FileNotFoundException {
        // TODO Auto-generated method stub
    	System.out.println(csvFilePath);
    	BufferedReader br = null;
    	
    	try {
    	br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath),"UTF-8"));

    	
    	String line ="";
    	List<String> File_line = new LinkedList();
    	
    	while ((line = br.readLine()) != null) {
    		//System.out.println(line);
    		File_line.add(line);
    		}
    	
    	return File_line;
    	
    	} catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	} 
 
   }



    public List<String> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException {
        // TODO Auto-generated method stub
    	
    	File file = new File(directoryPath);
    	
    	String[] fileList = file.list();    	
    	List<String> File_list = new LinkedList();
    	
    	for (String name : fileList)
    	{
    		String tmp;
    		tmp=directoryPath+"\\"+name;
    		File_list.add(tmp);
    		//System.out.println(tmp);
    	}
    	    	
        return File_list;
    }
    	
 
               
        public static void main(String args[]) throws IOException {
        	
        	Prac_SongLoader A = new Prac_SongLoader();        	
        	String k = "C:\\Users\\yoonc\\Desktop\\lecture note\\CS 400\\homework\\Song\\data";
        	List<String> b = new LinkedList();
        	b = A.loadAllFilesInDirectory(k);
        	
        	
        	//System.out.println(b);
        	
        	for (String file_path : b)
        	{
        		List<String> c = new LinkedList();
        		c = A.loadFile(file_path);
        		
        		System.out.println(c.get(0));
        		System.out.println(c.get(1));
        		System.out.println("*****************");
        	}        	
        	
        }
    }
