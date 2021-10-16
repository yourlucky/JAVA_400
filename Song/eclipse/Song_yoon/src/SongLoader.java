import java.util.List;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

// interface (implemented with proposal)

interface SongLoaderInterface {
    public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException;
    public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException;
}

// public class (implemented primarily in final app week)

public class SongLoader implements SongLoaderInterface {

    @Override
    public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException {
        // TODO Auto-generated method stub
    	 BufferedReader br = null;
    	
    	try {
        	br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFilePath),"UTF-8"));
        	
        	String line ="";
        	List<String> File_line = new LinkedList();
        	
        	int k = csvFilePath.length();
    		String Type_=csvFilePath.substring(k-7,k-4);
        	
        	while ((line = br.readLine()) != null)
        		File_line.add(line);
        	
        	File_line.remove(0);    
        	
        	List<SongDataInterface> D1 = new LinkedList();
        	
        	for (String line_data : File_line ) {
    			SongData song_d = new SongData(line_data,Type_);
    			D1.add((SongDataInterface)song_d);
    		}  	
        	
        	br.close();
        	return D1;
        	
        	} catch(Exception e) {
        		e.printStackTrace();
        		return null;
        	}     	    	
    }

    @Override
    public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException {
        // TODO Auto-generated method stub
    	
    	File file = new File(directoryPath);
    	
    	String[] fileList = file.list();    	
    	List<String> File_list = new LinkedList();
    	
    	for (String name : fileList)
    	{
    		String tmp;
    		tmp=directoryPath+"/"+name;
    		File_list.add(tmp);
    	}
    	
    	
    	List<SongDataInterface> D2 = new LinkedList();
    	
    	for (String name_2 : File_list)
     	  		D2.addAll(loadFile(name_2));   
    	
        return D2;
    	}
}

//placeholder(s) (implemented with proposal, and possibly added to later)

class SongLoaderPlaceholder implements SongLoaderInterface {
    public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException{
        List<SongDataInterface> list = new LinkedList<>();
        list.add(new SongDataPlaceholderA());
        list.add(new SongDataPlaceholderB());
        return list;
    }
    public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException{
        List<SongDataInterface> list = new LinkedList<>();
        list.add(new SongDataPlaceholderA());
        list.add(new SongDataPlaceholderB());
        list.add(new SongDataPlaceholderC());
        return list;
    }
}