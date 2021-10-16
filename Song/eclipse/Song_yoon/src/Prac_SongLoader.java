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
    public List<SongDataInterface_P> loadFile(String csvFilePath) throws FileNotFoundException;
    public List<SongDataInterface_P> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException;
}


//public class Prac_SongLoader  implements SongLoaderInterface_P {

public class Prac_SongLoader implements SongLoaderInterface_P {


    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SongDataInterface_P> loadFile(String csvFilePath) throws FileNotFoundException {
        // TODO Auto-generated method stub
    	System.out.println(csvFilePath);
    	BufferedReader br = null;
    	
    	try {
    	br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath),"UTF-8"));
    	
    	String line ="";
    	List<String> File_line = new LinkedList();
    	
    	int k = csvFilePath.length();
		String Type_=csvFilePath.substring(k-7,k-4);
    	
    	
    	while ((line = br.readLine()) != null) {
    		File_line.add(line);
    		}
    	
    	File_line.remove(0);    	
    	List<SongDataInterface_P> D1 = new LinkedList();
    	
    	for (String line_data : File_line )
		{
			Prac_SongData song_d = new Prac_SongData(line_data,Type_);
			D1.add((SongDataInterface_P)song_d);
		}  	
    	br.close();
    	return D1;
    	
    	} catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	} 
 
   }



    public List<SongDataInterface_P> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException {
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
    	
    	
    	List<SongDataInterface_P> D2 = new LinkedList();
    	
    	for (String name : fileList)
    	{
    		D2.add((SongDataInterface_P) loadFile(name));
    	}
    	
    	    	
        return D2;
    	}
    	 
	}
