import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Prac_main {
	 
		public static void main(String args[]) throws IOException {
		
			Prac_SongLoader A = new Prac_SongLoader();        	
			String k = "C:\\Users\\yoonc\\Desktop\\lecture note\\CS 400\\homework\\Song\\data";
			List<String> B = new LinkedList();
			B = A.loadAllFilesInDirectory(k);        	
			List<String> C1 = new LinkedList();
			C1 = A.loadFile(B.get(0));
		
			List<Prac_SongData> D1 = new LinkedList();
		
		
			for (String line_data : C1 )
			{
				Prac_SongData song_d = new Prac_SongData(line_data,B.get(0));
				D1.add(song_d);
			}
		
			System.out.println(D1.size());
		

			/*
			String kk = "C:\\Users\\yoonc\\Desktop\\lecture note\\CS 400\\homework\\Song\\write\\test.csv";
		
			File csv = new File(kk);
			BufferedWriter bw = null;
		        	
			try {
				
			 	bw = new BufferedWriter(new FileWriter(csv,true));
		
			for (int i = 0; i < D1.size(); i++) {
	     		String aData="";                
	     		//System.out.println(D1.get(i).getTitle() + "," + D1.get(i).getArtist() + "," + D1.get(i).getYearPublished());
	     		aData=D1.get(i).getTitle() + "," + D1.get(i).getArtist() + "," + D1.get(i).getYearPublished();
	     
	     		bw.write(aData);
	     		bw.newLine();                
			}
	 		}catch (FileNotFoundException e) {
	     		e.printStackTrace();
	 		}
			 */


		
			//System.out.println("====================");
		
			List<String> C2 = new LinkedList();
		
			C2 = A.loadFile(B.get(1));
			List<Prac_SongData> D2 = new LinkedList();
		
			for (String line_data : C2 )
			{
				Prac_SongData song_d = new Prac_SongData(line_data,B.get(1));
				D2.add(song_d);
			}
		
			//Write���� ���� for�� ���������ϸ�ȵ�
			// 242������ ����̵�
		
			/*
			String kk = "C:\\Users\\yoonc\\Desktop\\lecture note\\CS 400\\homework\\Song\\write\\test4.csv";
		
			File csv = new File(kk);
			BufferedWriter bw = null;
		        	
			try {
			
			 bw = new BufferedWriter(new FileWriter(csv,true));
		
			for (int i = 0; i < D2.size(); i++) {
	     		String aData="";                
	     		//System.out.println(D1.get(i).getTitle() + "," + D1.get(i).getArtist() + "," + D1.get(i).getYearPublished());
	     		aData=D2.get(i).getTitle() + "," + D2.get(i).getArtist() + "," + D2.get(i).getYearPublished();
	     
	     		bw.write(aData);
	     		bw.newLine();                
				}
	 		}catch (FileNotFoundException e) {
	     		e.printStackTrace();
	 		}
			 */
			int nu=577;
			System.out.println(D2.get(nu).getTitle() + " & " + D2.get(nu).getArtist() + " & " + D2.get(nu).getYearPublished());        	

			//Q
			System.out.println(D2.get(202).getTitle() + " & " + D2.get(202).getArtist() + " & " + D2.get(202).getYearPublished());        	
		
			System.out.println(D2.size());	


			}
}