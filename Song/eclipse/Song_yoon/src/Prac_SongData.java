
interface SongDataInterface_P {
    public String getTitle();
    public String getArtist();
    public int getYearPublished();
}

public class Prac_SongData  implements SongDataInterface_P  {
	
	public String Title;
	public String Artist;
	public int Year;
	
	
	Prac_SongData(String FileLine,String Type_)
	{
		
		if(Type_.equals("10s")) {
			int comma_count=0;
			int quot_count=0;
			String T_title="";
			String T_artist="";
			String T_year="";
			
			
			for(int i=0; i<FileLine.length();i++)
			{
				if(FileLine.charAt(i)=='"')
				{
					quot_count++;
					if(FileLine.charAt(i+1)=='"')
						continue;
				}
				if(FileLine.charAt(i)==',' && quot_count%2==0)
				{
					comma_count++;
					continue;
				}
				if(comma_count==1) 
						T_title += FileLine.charAt(i);
				
				if(comma_count==2) 
						T_artist += FileLine.charAt(i);				
				
				if(comma_count==4) {
					if(FileLine.charAt(i)!=',' && FileLine.charAt(i)!='"')
						T_year += FileLine.charAt(i);
				}
				if(comma_count==5)
					break;									
			}
			int T_l = T_title.length();
			String  S_T_title = T_title.substring(1,T_l-1);
			this.Title = S_T_title.strip();
			
			int A_l = T_artist.length();
			String  S_T_artist = T_artist.substring(1,A_l-1);
			this.Artist=S_T_artist.strip();
			
			
			this.Year = Integer.parseInt(T_year);
		}
		
		
		else {
			
			int comma_count=0;
			int quot_count=0;
			String T_title="";
			String T_artist="";
			String T_year="";
			
			for(int i=0; i<FileLine.length();i++)
			{
				if(FileLine.charAt(i)=='"')
				{
					quot_count++;
					if(FileLine.charAt(i+1)=='"')
						continue;
						
				}
				if(FileLine.charAt(i)==',' && quot_count%2==0)
				{
					comma_count++;
					continue;
				}
				if(comma_count==0)
						T_title += FileLine.charAt(i);
				
				if(comma_count==3) 
						T_artist += FileLine.charAt(i);
					
				
				if(comma_count==6) {
					if(FileLine.charAt(i)!=',' && FileLine.charAt(i)!='"')
						T_year += FileLine.charAt(i);
				}
				if(comma_count==7)
					break;									
			}
			
			int T_l = T_title.length();
			String  S_T_title = T_title.substring(1,T_l-1);
			this.Title = S_T_title.strip();
			
			int A_l = T_artist.length();
			String  S_T_artist = T_artist.substring(1,A_l-1);
			this.Artist=S_T_artist.strip();
			
			String TT_year=T_year.strip();
			int kk = TT_year.length();
			//System.out.println(T_year);
			String Numb_= TT_year.substring(kk-4,kk);
			this.Year = Integer.parseInt(Numb_);
						
		}		
					
	}
	
	
	
	 @Override
	    public String getTitle() {
	        // TODO Auto-generated method stub
	        return this.Title;
	    }

	    @Override
	    public String getArtist() {
	        // TODO Auto-generated method stub
	        return this.Artist;
	    }

	    @Override
	    public int getYearPublished() {
	        // TODO Auto-generated method stub
	        return this.Year;
	    }

}
