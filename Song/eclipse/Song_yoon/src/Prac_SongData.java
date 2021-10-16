
interface SongDataInterface_p {
    public String getTitle();
    public String getArtist();
    public int getYearPublished();
}

public class Prac_SongData  implements SongDataInterface_p  {
	
	public String Title;
	public String Artist;
	public int Year;
	
	
	Prac_SongData(String FileLine,String FileName)
	{
		int k = FileName.length();
		String Type_=FileName.substring(k-7,k-4);
		
		if(Type_.equals("10s")) {
			int comma_count=0;
			int quot_count=0;
			String T_title="";
			String T_artist="";
			String T_year="";
			
			
			for(int i=0; i<FileLine.length();i++)
			{
				if(FileLine.charAt(i)=='"')
					quot_count++;
				if(FileLine.charAt(i)==',' && quot_count%2==0)
					comma_count++;
				
				if(comma_count==1) {
					if(FileLine.charAt(i)!=',' && FileLine.charAt(i)!='"')
						T_title += FileLine.charAt(i);
				}
				
				if(comma_count==2) {
					if(FileLine.charAt(i)!=',' && FileLine.charAt(i)!='"')
						T_artist += FileLine.charAt(i);
				}
					
				
				if(comma_count==4) {
					if(FileLine.charAt(i)!=',' && FileLine.charAt(i)!='"')
						T_year += FileLine.charAt(i);
				}
				if(comma_count==5)
					break;									
			}
			
			this.Title = T_title;
			this.Artist=T_artist;
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
					quot_count++;
				if(FileLine.charAt(i)==',' && quot_count%2==0)
					comma_count++;
				
				if(comma_count==0) {
					if(FileLine.charAt(i)!=',' && FileLine.charAt(i)!='"')
						T_title += FileLine.charAt(i);
				}
				
				if(comma_count==3) {
					if(FileLine.charAt(i)!=',' && FileLine.charAt(i)!='"')
						T_artist += FileLine.charAt(i);
				}
					
				
				if(comma_count==6) {
					if(FileLine.charAt(i)!=',' && FileLine.charAt(i)!='"')
						T_year += FileLine.charAt(i);
				}
				if(comma_count==7)
					break;									
			}
			this.Title = T_title;
			this.Artist=T_artist;
			
			int kk = T_year.length();
			String Numb_= T_year.substring(kk-4,kk);
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
