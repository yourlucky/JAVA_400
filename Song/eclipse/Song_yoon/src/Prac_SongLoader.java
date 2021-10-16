import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileInputStream;


interface SongLoaderInterface_P {
    public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException;
    public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException;
}


//public class Prac_SongLoader  implements SongLoaderInterface_P {

public class Prac_SongLoader {


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
    	 
		}
