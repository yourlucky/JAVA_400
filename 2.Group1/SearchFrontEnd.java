import java.util.*;
interface SearchFrontEndInterface {    
    public void run(SearchBackEndInterface searchEngine);
    

    // Here is a sample of the minimal set of options that 
    // this front end will support:

    // SongSearch Command Menu:
    // 1. Insert New Song into Database
    // 2. Search For Song Titles by Words in those Title
    // 3. Search For Artists by Words in their Song Titles
    // 4. Display Years of Songs with Word in Title as Histogram
    // 5. Quit
}

// public class (implemented primarilly in final app week)

public class SearchFrontEnd implements SearchFrontEndInterface {

    @Override
    public void run(SearchBackEndInterface searchEngine) {
        // TODO Auto-generated method stub
        boolean finished = false;
	
        System.out.println("welcome to songSearch app!");
	Scanner input1 = new Scanner(System.in);
        while(finished != true){
            System.out.println("Type the command number to operate");
            System.out.println(" 1. insert a new song \n 2. search for song titles by words \n 3. search for artists by words \n 4. display years of songs with world in title as histogram \n 5. quit");
		int num; 
           try{num = input1.nextInt();input1.nextLine();
	   }catch(Exception e){
		   input1.nextLine();
	   	System.out.println("Invalid input, please type a number.");
		continue;
	   }
            //insert a song command
            if(num == 1){
                System.out.println("you chose to insert a song. \nplease type the tile of the song.");
                
                SongData newsong = new SongData();
                String title = input1.nextLine();
                newsong.setTitle(title);
                System.out.println("plese type the name of artist.");
                String artist = input1.nextLine();
                newsong.setArtist(artist);
                System.out.println("Finally, plese type the year published.");
		boolean checkDataType = false;
                while(checkDataType == false){
                    try{
                        int year = input1.nextInt();input1.nextLine();
                        
                        newsong.setYear(year);;
                        checkDataType = true;
                    }catch(Exception e){
                        input1.nextLine();
                        System.out.println("error, you should type number, try again");
                        continue;
                    }
                }

                if(searchEngine.containsSong(newsong)){
                    System.out.println("error: this song is already in the table");
                }
                // detect invalid input
                else if(newsong.getArtist().length() == 0 || newsong.getTitle().length() == 0 || newsong.getYearPublished() < 0 ){
                    System.out.println("one of data you typed is invalid,  please try again");
                    continue;
                }else{
                    searchEngine.addSong(newsong);
                    System.out.println("your new song is successfully added!");
                }
                
                //search song tites by words command
            }else if(num == 2){
                System.out.println("you chose to search for song titles by words.");
                
                System.out.println("type the words you want to search.");
                String words = input1.nextLine();
                if(words.length() == 0){
                    System.out.println(" invalid,  input cannot be empty");
                    continue;
                }
                List<String> songList = searchEngine.findTitles(words);
                System.out.println("here are songs found:");
                System.out.println(songList);
                //search artists by words
            }else if(num ==3){
                System.out.println("you chose to search for artists by words.");
                
                System.out.println("type the artists you want to search.");
                String words = input1.nextLine();
                if(words.length() == 0){
                    System.out.println(" invalid,  input cannot be empty");
                    continue;
                }
                List<String> artistList = searchEngine.findArtists(words);
                System.out.println("here are artists found:");
                System.out.println(artistList);

            }else if(num == 4){
                System.out.println("you chose to display years of songs with world in title as histogram.");
                
                System.out.println("type the word you want to search.");
                String words = input1.nextLine();
                if(words.length() == 0){
                    System.out.println("invalid, input cannot be empty");
                    continue;
                }
                String histogram = "";
                //use findNumberOfSongsInYear() to find number of songs in a specific year
                //set range of year between 1900 and 2020
                for(int i = 1900; i <2021; i++){
                    //if find there is a song in a specific year
                    if(searchEngine.findNumberOfSongsInYear(words, i) != 0){
                        int numOfSong = searchEngine.findNumberOfSongsInYear(words, i);
                        String specificYear = Integer.toString(i);
                        histogram += specificYear + "-" + "*".repeat(numOfSong)+ " " + numOfSong +"\n";
                    }
                }
                System.out.println("here is the histogram of keyword= " + words + ". ");
                System.out.println(histogram);
            }else if(num == 5){
                System.out.println("you chose to quit. Bye!");
                finished = true;
                input1.close();
                
            }else{
                System.out.println("invalid command number! please type again");
                continue;
            }
        }
    }

}
