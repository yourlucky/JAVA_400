
public class PokemonAppTest {
	public static void main(String[] args) throws Exception{
		
		System.out.println("PokemonApp Test");
		
		//Data Wrangler
		/*
        System.out.println("Done by DataWrangler.");
        System.out.println("The test result for DataWrangler_TestLoadfile is: " + DataWrangler_TestLoadfile());
        System.out.println("The test result for DataWrangler_TestLoaddirectory is: " + DataWrangler_TestLoaddirectory());
        System.out.println("The test result for DataWrangler_Test_gettitle_Artist is: " + DataWrangler_Test_gettitle_Artist());
		*/
		
		// Backend Developer
		/*
        System.out.println("Done by Backend Developer");
        System.out.println("Backend_TestFindTitles(): " + Backend_TestFindTitles());
        System.out.println("Backend_TestFindArtists(): " + Backend_TestFindArtists());
        System.out.println("Backend_TestFindNumberOfSongsInYear(): " +
                Backend_TestFindNumberOfSongsInYear());
                */
		
		// Frontend Developer
		/*
		System.out.println("Done by FrontEnd Developer.");
        System.out.println("The test result for FrontEnd_testInvalidOutputFor2(): " +FrontEnd_TestInvalidOutputFor2() );
        System.out.println("The test result for FrontEnd_testInvalidOutputFor3(): " + FrontEnd_TestInvalidOutputFor3());
        System.out.println("The test result forFrontEnd_testInvalidOutputFor4(): " + FrontEnd_TestInvalidOutputFor4());
		 */
		
		 // Integration Manager
		/*
		System.out.println("Done by Integration Manager.");
        System.out.println("The test result for Backend addition method is: " + IntegrationManager_TestAddSong());
        System.out.println("The test result for Backend findTitles method is: " +
                        IntegrationManage_TestfindTitles());
        System.out.println("The test result for Frontend exit choice is: " +
                        IntegrationManager_TestFrontEndExit());
        System.out.println("The test result for Frontend add choice is: " +
                        IntegrationManager_TestFrontEndAdd());
		 */
			

	}

}

///**
// * Test the implementation of choise of add in SearchFrontEnd class.
// * @return true if there's no problem in the method, otherwise false
// */
//public static boolean  IntegrationManager_TestFrontEndAdd(){
//    SongSearchTests tester1  = new SongSearchTests(" 1\nSong A Vowel\nArtist X\n1900\n5 ");
//    SearchFrontEnd engine = new SearchFrontEnd();
//    SearchBackEndInterface searchEngine = new SearchBackEnd();
//    engine.run(searchEngine);
//    // 3. Check whether the output printed to System.out matches your expectations.
//    String output = tester1.checkOutput();
//    if(output.startsWith("welcome to songSearch app!") &&
//       output.contains( "your new song is successfully added!")){
//        return true;
//     }
//    else{
//        return false;
//    }
//}
