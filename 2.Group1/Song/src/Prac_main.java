import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Prac_main {
	 
		public static void main(String args[]) throws IOException {
		
			SongLoader A = new SongLoader();        	
			String k = "C:\\Users\\yoonc\\Desktop\\lecture note\\CS 400\\homework\\Song\\data";	
			String k2 = "C:\\Users\\yoonc\\Desktop\\lecture note\\CS 400\\homework\\Song\\data\\top 500 Songs.csv";	
			String k3 = "C:\\Users\\yoonc\\Desktop\\lecture note\\CS 400\\homework\\Song\\data\\top10s.csv";
			
			String kk = "/home/yna23/SCI400/Pra/JAVA_400/Song/eclipse/Song_yoon/src";	
			String kk2 = "/home/yna23/SCI400/Pra/JAVA_400/Song/eclipse/Song_yoon/src/'top 500 Songs.csv'";	
			String kk3 = "/home/yna23/SCI400/Pra/JAVA_400/Song/eclipse/Song_yoon/srctop10s.csv";
			
			
			List<SongDataInterface> C1 = new LinkedList();
			
			
			
			C1=A.loadFile(k2);
			//C1=A.loadAllFilesInDirectory(k);
			
			//System.out.println(C1.size());
			
			
			int num1=0;
			int num2=10;
			int num3=600;
			System.out.println(C1.get(num1).getTitle());
			System.out.println(C1.get(num1).getArtist());
			
			String se = "Like a Rolling Stone";
			String se2 = "Bob Dylan";
			
			if (C1.get(num1).getTitle().equals(se))
				System.out.println("hi");
			if (C1.get(num1).getArtist().equals(se2))
				System.out.println("hi");
		
			//System.out.println(C1.get(num1).getArtist()+" & "+C1.get(num1).getTitle()+" & "+C1.get(num1).getYearPublished());
			//System.out.println(C1.get(num2).getArtist()+" & "+C1.get(num2).getTitle()+" & "+C1.get(num2).getYearPublished());
			//System.out.println(C1.get(num3).getArtist()+" & "+C1.get(num3).getTitle()+" & "+C1.get(num3).getYearPublished());

			}
}
