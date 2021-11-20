import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*;

public class SongSearchTests {

    public static void main(String[] args) throws Exception {
        // Run All Tests

	// Data Wrangler
	System.out.println("Done by Data Wrnagler.");
        System.out.println("The test result for DataWrangler_TestLoadfile is: " + DataWrangler_TestLoadfile());
	System.out.println("The test result for DataWrangler_TestLoaddirectory is: " +
		       	DataWrangler_TestLoaddirectory());
	System.out.println("The test result for DataWrangler_Test_gettitle_Artist is: " +
		       	DataWrangler_Test_gettitle_Artist());

        // Backend Developer
	System.out.println("Done by Backend Developer");
        System.out.println("Backend_TestFindTitles(): " + Backend_TestFindTitles());
        System.out.println("Backend_TestFindArtists(): " + Backend_TestFindArtists());
        System.out.println("Backend_TestFindNumberOfSongsInYear(): " +
                Backend_TestFindNumberOfSongsInYear());

        // Integration Manager
	System.out.println("Done by Integration Manager.");
        System.out.println("The test result for Backend addition method is: " + IntegrationManager_TestAddSong());
        System.out.println("The test result for Backend findArtist method with specific case is: " +
		       	IntegrationManage_TestreptedArtist());
        System.out.println("The test result for Frontend exit choice is: " +
		       	IntegrationManager_TestFrontEndExit());
	System.out.println("The test result for Frontend add choice is: " + 
			IntegrationManager_TestFrontEndAdd());
	System.out.println("The test result for creating a new SondData is: "+ 
			IntegrationManager_TestDataWranglerSet());
	System.out.println("The test result for Frontend having invalid input test is: " + 
			IntegrationManager_TestFrontEndException());
        // Frontend Developer
	 
	System.out.println("Done by FrontEnd Developer.");
        System.out.println("The test result for FrontEnd_testInvalidOutputFor2(): " + 
			FrontEnd_TestCommand2());
        System.out.println("The test result for FrontEnd_testInvalidOutputFor3(): " + 
			FrontEnd_TestCommand3());
        System.out.println("The test result forFrontEnd_testInvalidOutputFor4(): " + 
			FrontEnd_TestCommand4());
		
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

    // Back End Developer Tests
    /**
     * Test the implementation of findTitles() method from SearchBackEnd class.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean Backend_TestFindTitles() {
        SearchBackEndInterface engine = new SearchBackEnd();
        // case 1: empty list
        List<String> titles = engine.findTitles("Song");
        if (!titles.isEmpty()) {
            System.out.println("Backend_TestFindTitles() --- test case 1 failed!");
            return false;
        }

        // case 2: one element in the list
        SongDataInterface song1 = new SongDataPlaceholderA();
        engine.addSong(song1);
        titles = engine.findTitles("Song");
        if (!titles.get(0).equals(song1.getTitle())) {
            System.out.println("Backend_TestFindTitles() --- test case 2 failed!");
            return false;
        }

        // case 3: multiple elements in the list
        SongDataInterface song2 = new SongDataPlaceholderB();
        SongDataInterface song3 = new SongDataPlaceholderC();
        engine.addSong(song2);
        engine.addSong(song3);
        SongDataInterface[] songs = {song1, song2, song3};
        titles = engine.findTitles("Song");

        for (int i = 0; i < 3; i++) {
            if (!songs[i].getTitle().equals(titles.get(i))) {
                System.out.println("Backend_TestFindTitles() --- test case 3 failed!");
                return false;
            }
        }

        // passed all test cases
        return true;
    }

    /**
     * Test the implementation of findArtists() method from SearchBackEnd class.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean Backend_TestFindArtists() {
        SearchBackEndInterface engine = new SearchBackEnd();
        // case 1: empty list
        List<String> artists = engine.findArtists("A");
        if (!artists.isEmpty()) {
            System.out.println("Backend_TestFindArtists() --- test case 1 failed!");
            return false;
        }

        // case 2: one element in the list
        SongDataInterface song1 = new SongDataPlaceholderA();
        engine.addSong(song1);
        artists = engine.findArtists("A");
        if (!artists.get(0).equals(song1.getArtist())) {
            System.out.println("Backend_TestFindArtists() --- test case 2 failed!");
            return false;
        }

        // case 3: multiple elements in the list
        SongDataInterface song2 = new SongDataPlaceholderB();
        SongDataInterface song3 = new SongDataPlaceholderC();
        engine.addSong(song2);
        engine.addSong(song3);
        SongDataInterface[] songs = {song1, song2, song3};
        artists = engine.findArtists("Song");

        if (artists.size() != 2) {
            System.out.println("Backend_TestFindArtists() --- test case 3 failed!");
            return false;
        }

        // passed all test cases
        return true;
    }

    /**
     * Test the implementation of findNumberOfSongsInYear() method from SearchBackEnd class.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean Backend_TestFindNumberOfSongsInYear() {
        SearchBackEndInterface engine = new SearchBackEnd();

        // add songs
        SongDataInterface song1 = new SongDataPlaceholderA();
        engine.addSong(song1);
        SongDataInterface song2 = new SongDataPlaceholderB();
        engine.addSong(song2);
        SongDataInterface song3 = new SongDataPlaceholderC();
        engine.addSong(song3);

        // case 1: no song was added with year 1999
        if (engine.findNumberOfSongsInYear("Song", 1999) != 0) {
            System.out.println("Backend_TestFindNumberOfSongsInYear() --- test case 1 failed!");
            return false;
        }

        // case 2: song1 was added with year 1900
        if (engine.findNumberOfSongsInYear("A", 1900) != 1) {
            System.out.println("Backend_TestFindNumberOfSongsInYear() --- test case 2 failed!");
            return false;
        }

        // case 3: 2 songs was added with year 2000 - B and B 2
        engine.addSong(new SongDataInterface() {
            @Override
            public String getTitle() {
                return "Song B 2";
            }

            @Override
            public String getArtist() {
                return "Artist B 2";
            }

            @Override
            public int getYearPublished() {
                return 2000;
            }
        });

        if (engine.findNumberOfSongsInYear("B", 2000) != 2) {
            System.out.println("Backend_TestFindNumberOfSongsInYear() --- test case 3 failed!");
            return false;
        }

        // passed all test cases
        return true;
    }

    // Front End Developer Tests
    /**
     * Test the implementation of command2 from frontend  class.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean FrontEnd_TestCommand2(){
    	SongSearchTests tester = new SongSearchTests(" 2\n\n5\n");
        SearchFrontEnd engine = new SearchFrontEnd();
        SearchBackEndInterface searchEngine = new SearchBackEnd();
        engine.run(searchEngine);
        // 3. Check whether the output printed to System.out matches your expectations.
        String output = tester.checkOutput();
        if(output.contains("invalid")){
            return true;
         }
        else{
            return false;
        }
    }
        /**
     * Test the implementation of command3 from frontend  class.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean FrontEnd_TestCommand3(){
    	SongSearchTests tester = new SongSearchTests(" 3\n\n5\n");
        SearchFrontEnd engine = new SearchFrontEnd();
        SearchBackEndInterface searchEngine = new SearchBackEnd();
        engine.run(searchEngine);
        // 3. Check whether the output printed to System.out matches your expectations.
        String output = tester.checkOutput();
        if(output.contains("invalid")){
            return true;
         }
        else{
            return false;
        }
    }
    
	public static boolean FrontEnd_TestCommand4(){
		SongSearchTests tester = new SongSearchTests(" 4\n\n5\n");
        SearchFrontEnd engine = new SearchFrontEnd();
        SearchBackEndInterface searchEngine = new SearchBackEnd();
        engine.run(searchEngine);
        // 3. Check whether the output printed to System.out matches your expectations.
        String output = tester.checkOutput();
        if(output.contains("invalid")){
            return true;
         }
        else{
            return false;
        }
	}


    // Integration Manager Tests
    /**
     * Test the implementation of addSong() method from SearchBackEnd class.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean IntegrationManager_TestAddSong() {
        SearchBackEndInterface test1 = new SearchBackEnd();
        SongDataInterface song1 = new SongDataPlaceholderA();
        test1.addSong(song1);
        //test normal adding
        if (!test1.containsSong(song1)) {
            return false;
        }
        //test whether it works when add the next song
        SongDataInterface song3 = new SongDataPlaceholderC();
	test1.addSong(song3);
        if (!test1.containsSong(song3)) {
            return false;
        }
        return true;
    }
    /**
     * Test the implementation of findArtists() method of specific case of same artist.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean IntegrationManage_TestreptedArtist() {
        SearchBackEndInterface test = new SearchBackEnd();
        SongDataInterface song1 = new SongDataPlaceholderA();
	SongDataInterface song2 = new SongDataPlaceholderC();
	test.addSong(song1);
	test.addSong(song2);
        List<String> testlist = test.findArtists("Song");
        if (!testlist.toString().equals("[Artist X]")) {
            return false;
	}
        return true;
    }
    /**
     * Test the implementation of choise of exit in SearchFrontEnd class.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean  IntegrationManager_TestFrontEndExit(){
	SongSearchTests tester = new SongSearchTests(" 5 ");
        SearchFrontEnd engine = new SearchFrontEnd();
	SearchBackEndInterface searchEngine = new SearchBackEnd();
	engine.run(searchEngine);

        // 3. Check whether the output printed to System.out matches your expectations.
        String output = tester.checkOutput();
        if(output.startsWith("welcome to songSearch app!") && 
           output.contains("you chose to quit. Bye!")){
            return true;
	 }
        else{
            return false;
	}
    }
    /**
     * Test the implementation of choise of add in SearchFrontEnd class.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean  IntegrationManager_TestFrontEndAdd(){
        SongSearchTests tester1  = new SongSearchTests(" 1\nSong A Vowel\nArtist X\n1900\n5 ");
        SearchFrontEnd engine = new SearchFrontEnd();
        SearchBackEndInterface searchEngine = new SearchBackEnd();
        engine.run(searchEngine);

        // 3. Check whether the output printed to System.out matches your expectations.
        String output = tester1.checkOutput();
        if(output.startsWith("welcome to songSearch app!") &&
           output.contains( "your new song is successfully added!")){
            return true;
         }
        else{
            return false;
        }
    }
     /**
     * Test the implementation of some exceptions condition in SearchFrontEnd class.
     * @return true if there's no problem in the method, otherwise false
     */
    public static boolean  IntegrationManager_TestFrontEndException(){
        //condition not a int at first
	SongSearchTests tester1  = new SongSearchTests("dfhejdo\n 1\nSong A Vowel\nArtist X\n1900\n5 ");
        SearchFrontEnd engine = new SearchFrontEnd();
        SearchBackEndInterface searchEngine = new SearchBackEnd();
        engine.run(searchEngine);
        String output = tester1.checkOutput();
        if(!output.startsWith("welcome to songSearch app!") &&
           !output.contains( "Invalid input, please type a number.")){
            return false;
        }
	//condition of the year not a int
	SongSearchTests tester2  = new SongSearchTests("1\nSong A Vowel\nArtist X\nghjh\n1990\n5 ");
        SearchFrontEnd engine1 = new SearchFrontEnd();
        SearchBackEndInterface searchEngine1 = new SearchBackEnd();
        engine1.run(searchEngine1);
	String output1 = tester2.checkOutput();
        if(!output1.startsWith("welcome to songSearch app!") &&
           !output1.contains( "erro, you should type number, try again")){
            return false;
        }
	//insert the same song
	SongSearchTests tester3  = new SongSearchTests("1\nSong A Vowel\nArtist X\n1990\n1\nSong A Vowel\nArtist X\n1990\n 5 ");
        SearchFrontEnd engine2 = new SearchFrontEnd();
        SearchBackEndInterface searchEngine2 = new SearchBackEnd();
        engine2.run(searchEngine2);
        String output2 = tester3.checkOutput();
        if(!output2.startsWith("welcome to songSearch app!") &&
           !output2.contains( "erro: this song is already in the table")){
            return false;
        }
        return true;
    }
    public static boolean  IntegrationManager_TestDataWranglerSet(){
        SongData song1 = new SongData();
	song1.setTitle("Song A");
	song1.setArtist("Artist X");
	song1.setYear(1990);
	if(song1.getTitle().equals("Song A")&&song1.getArtist().equals("Artist X")&&
			song1.getYearPublished()==1990){
            return true;
        }else{
	    return false;
	}
    }

    private PrintStream saveSystemOut; // store standard io references to restore after test
    private PrintStream saveSystemErr;
    private InputStream saveSystemIn;
    private ByteArrayOutputStream redirectedOut; // where output is written to durring the test
    private ByteArrayOutputStream redirectedErr;

    /**
     * Creates a new test object with the specified string of simulated user input text.
     * @param programInput the String of text that you want to simulate being typed in by the user.
     */
    public SongSearchTests(String programInput) {
        // backup standard io before redirecting for tests
        saveSystemOut = System.out;
        saveSystemErr = System.err;
        saveSystemIn = System.in;
        // create alternative location to write output, and to read input from
        System.setOut(new PrintStream(redirectedOut = new ByteArrayOutputStream()));
        System.setErr(new PrintStream(redirectedErr = new ByteArrayOutputStream()));
        System.setIn(new ByteArrayInputStream(programInput.getBytes()));
    }

    /**
     * Call this method after running your test code, to check whether the expected
     * text was printed out to System.out and System.err.  Calling this method will
     * also un-redirect standard io, so that the console can be used as normal again.
     *
     * @return captured text that was printed to System.out and System.err durring test.
     */
    public String checkOutput() {
        try {
            String programOutput = redirectedOut.toString() + redirectedErr.toString();
            return programOutput;
        } finally {
            // restore standard io to their pre-test states
            System.out.close();
            System.setOut(saveSystemOut);
            System.err.close();
            System.setErr(saveSystemErr);
            System.setIn(saveSystemIn);
        }
    }

}
