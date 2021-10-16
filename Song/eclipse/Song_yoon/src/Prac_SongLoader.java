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
    		File_line.add(line);
    		}
    	
    	File_line.remove(0);
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
    	}
    	    	
        return File_list;
    }
    	
 
               
        public static void main(String args[]) throws IOException {
        	
        	Prac_SongLoader A = new Prac_SongLoader();        	
        	String k = "C:\\Users\\yoonc\\Desktop\\lecture note\\CS 400\\homework\\Song\\data";
        	List<String> B = new LinkedList();
        	B = A.loadAllFilesInDirectory(k);
        	
        	
        	//System.out.print(b.get(1));
        	List<String> C = new LinkedList();
        	C = A.loadFile(B.get(1));
        	Prac_SongData D = new Prac_SongData(C.get(0),B.get(1));
        	
        	System.out.println(D.getTitle());
        	System.out.println(D.getArtist());   	
        	System.out.println(D.getYearPublished());
        	
        	
        	System.out.println("^^^^^^^^^^^^^^^^");
        	
        	C = A.loadFile(B.get(0));        	
        	//System.out.println(C.get(0));
        	Prac_SongData D2 = new Prac_SongData(C.get(0),B.get(0));        	
        	System.out.println(D2.getTitle());
        	System.out.println(D2.getArtist());   	
        	System.out.print(D2.getYearPublished());
        	
        	//System.out.println(c.get(1));
        	
        	
        	
        	//System.out.print(D.getYearPublished());
        	
        	//System.out.println(b);
        	/*
        	for (String file_path : b)
        	{
        		List<String> c = new LinkedList();
        		c = A.loadFile(file_path);
        		
        		System.out.println(c.get(0));
        		System.out.println(c.get(1));
        		System.out.println("*****************");
        	}
        	*/        	
        	
        }
    }
