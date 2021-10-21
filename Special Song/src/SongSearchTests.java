import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class SongSearchTests {
	 public static void main(String[] args) throws Exception {
	        
		 // Data Wrangler
		 	System.out.println("Done by FrontEnd Developer.");
	        System.out.println("The test result for DataWrangler_TestLoadfile is: " + DataWrangler_TestLoadfile());
	        System.out.println("The test result for DataWrangler_TestLoaddirectory is: " + DataWrangler_TestLoaddirectory());
	        System.out.println("The test result for DataWrangler_Test_gettitle_Artist is: " + DataWrangler_Test_gettitle_Artist());

	    }
	    
	// Data Wrangler Code Tests
     //test1 : check SongLoadfile function by comparing csv data
	 public static boolean DataWrangler_TestLoadfile()throws FileNotFoundException{
		 
		 SongLoader A = new SongLoader();      		 
		 List<SongDataInterface> C1 = new LinkedList();
		 try {
		 String k = "./data/top10s.csv";
		 C1=A.loadFile(k);
		 int nums= C1.get(0).getYearPublished();
		 if(nums == 2010)
			 return true;
		 else
			 return false;
		 }
		 catch (FileNotFoundException ex)  {
			 System.out.println("no csv file");
			 return false;
		 }
		 
	 }
	 
	// test2  : check SongLoadAllfiles by comparing csv data
	 public static boolean DataWrangler_TestLoaddirectory()throws FileNotFoundException{
		 
		 SongLoader A = new SongLoader();      		 
		 List<SongDataInterface> C2 = new LinkedList();
		 try {
		 String k = "./data/";
		 C2=A.loadAllFilesInDirectory(k);
		 int nums= C2.get(0).getYearPublished();
		 if(nums == 1965)
			 return true;
		 else
			 return false;
		 }
		 catch (FileNotFoundException ex)  {
			 System.out.println("no csv file");
			 return false;
		 }
			 
	 }
 //test3 : check getTitle,getArtits function by comparing csv data
   public static boolean DataWrangler_Test_gettitle_Artist()throws FileNotFoundException{
		 
		 SongLoader A = new SongLoader();      		 
		 List<SongDataInterface> C3 = new LinkedList();
		 try {
		 String k = "./data/top10s.csv";
		 C3=A.loadFile(k);
		 
		 String se = "Hey, Soul Sister";
		 String se2 = "Train";
		 
		
		 if (C3.get(0).getTitle().equals(se)) {
			 if (C3.get(0).getArtist().equals(se2)) {
				 return true;			 
			 }		 
		 }
		 return false;	
		 }
		 catch (FileNotFoundException ex)  {
			 System.out.println("no csv file");
			 return false;
		 }
	
	 }
		 /*
	
	    // Back End Developer Tests
	    // Front End Developer Tests
	    // Integration Manager Tests
	public static boolean IntegrationManager_TestAddSong(){
	        SearchBackEndInterface test1 = new SearchBackEnd();
	        SongDataInterface song1 = new SongDataPlaceholderA();
	        test1.addSong(song1);
	        //test normal adding
	        if(!test1.containsSong(song1)){
	            return false;
	        }
	        //test whether it can add the same song again(it should not)
	        test1.addSong(song1);
	        List<String> testlist = test1.findTitles("Song");
	        if(!testlist.toString().equals("[Song A Vowel]") ){
	             return false;
	        }
	        return true;
	    }
	public static boolean IntegrationManage_TestfindTitles(){
	        SearchBackEndInterface test2 = new SearchBackEnd();
	        SongDataInterface song1 = new SongDataPlaceholderA();
	        test2.addSong(song1);
	        //test the List while only one added
	        List<String> testlist = test2.findTitles("Song");
	        if(!testlist.toString().equals("[Song A Vowel]") ){
	             return false;
	        }
	//test the List when adding all three with the same word included
	        SongDataInterface song2 = new SongDataPlaceholderB();
	        SongDataInterface song3 = new SongDataPlaceholderC();
	        test2.addSong(song2);
	        test2.addSong(song3);
	        List<String> testlist1  = test2.findTitles("Song");
	        if(!testlist1.toString().equals("[Song A Vowel, Song B Consonant, Song C Consonant]")){
	             return false;
	        }
	        //test whether it would go into others
	        List<String> testlist2  = test2.findTitles("B");
	        if(!testlist2.toString().equals("[Song B Consonant]") ){
	             return false;
	        }
	        return true;
	    }
	*/
	}




