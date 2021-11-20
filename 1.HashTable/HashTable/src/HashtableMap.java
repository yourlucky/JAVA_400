// --== CS400 Project One File Header ==--
// Name: <YoonChae_Na>
// Email: <yna23@wisc.edu>
// Team: <BLUE>
// Group: <DE>
// TA: <Daniel>
// Lecturer: <Florian>
// Notes to Grader: <I put more than 100 hours>

import java.util.NoSuchElementException;
import java.util.LinkedList;

@SuppressWarnings("static-access")
class Pair<KeyType,ValueType>{
	KeyType key;
	ValueType value;
	public Pair(KeyType key, ValueType value) {
		this.key=key;
		this.value=value;
	}
	public KeyType key() {
		return key;
	}
	public ValueType value() {
		return value;
	}
}


@SuppressWarnings("static-access")
public class HashtableMap <KeyType,ValueType>  implements MapADT<KeyType, ValueType>{
	int KL_size=0;
	int KL_count=0;
	
	@SuppressWarnings("rawtypes")
	LinkedList<Pair> [] key_list;
	
	
	@SuppressWarnings("unchecked")
	public HashtableMap()
	{
		this.KL_size=20;
		this.key_list=new LinkedList[this.KL_size];
	}
	
	@SuppressWarnings("unchecked")
	public HashtableMap(int capacity)
	{
		this.KL_size=capacity;		
		this.key_list=new LinkedList[this.KL_size];
		
	}
	
	public int GetArraySize ()
	{
		return this.KL_size;		
	}
	
	public boolean containsKey(KeyType key)
	{
		int location =  Math.abs(key.hashCode())%this.KL_size;
		
		if (this.key_list[location] == null) {
			return false;		
		}
		
		for(int i=0; i<this.key_list[location].size(); i++ )
		{
			if (this.key_list[location].get(i).key().equals(key))
				return true;
		}
		
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean put(KeyType key, ValueType value)
	{
		if (key == null)
			return false;
		@SuppressWarnings("unchecked")
		Pair pair = new Pair(key, value);				
		int location =  Math.abs(key.hashCode())%this.KL_size;
		
		if (this.key_list[location] == null) {
			if(this.check() == true)
				this.twice();
			
			this.key_list[location]= new LinkedList<Pair>();						
			this.key_list[location].add(pair);
			this.KL_count++;
					
			return true;
		}
		else {
			if (containsKey(key) == true)
				return false;
			else{
				if(this.check() == true)
					this.twice();
				
				this.key_list[location].add(pair);
				this.KL_count++;
				return true;
			}
		}
	}
	
	public boolean check()
	{
		double ratio_k = ((double)KL_count+1)/KL_size;		
		if(ratio_k >= 0.8)
		{
			return true;
		}
		return false;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void twice() {
		int temp_size=this.twicehelper();

		LinkedList<Pair> [] tmp_key_list= new LinkedList[temp_size];	
		
		for (int i=0; i<this.KL_size;i++)
		{
			if (this.key_list[i] != null)
			{
				for(int j=0; j<this.key_list[i].size();j++)
				{
					int location =  Math.abs(this.key_list[i].get(j).key().hashCode()) %temp_size;
					
					if (tmp_key_list[location] == null) {
						tmp_key_list[location] = new LinkedList<Pair>();	
						tmp_key_list[location].add(new Pair(this.key_list[i].get(j).key(), this.key_list[i].get(j).value()) );
					}
					else {
						tmp_key_list[location].add(new Pair(this.key_list[i].get(j).key(), this.key_list[i].get(j).value()) );
					}
				}
			}
		}
		this.key_list=tmp_key_list;
		this.KL_size=temp_size;
	}
	
	private int twicehelper() {
		return this.KL_size*2;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public ValueType get(KeyType key) throws NoSuchElementException
	{
		int location =  Math.abs(key.hashCode())%this.KL_size;
		
		if (key == null)
			throw new NoSuchElementException();
		
		if (this.key_list[location] == null) {
			throw new NoSuchElementException();
		}
		else
		{
			for(int i=0; i<this.key_list[location].size(); i++ )
			{				
				if (this.key_list[location].get(i).key().equals(key))
					return (ValueType)this.key_list[location].get(i).value();
			}
			throw new NoSuchElementException();
		}
	}
		
	public ValueType remove(KeyType key)
	{		
		if (containsKey(key) == true)
		{
			int location =  Math.abs(key.hashCode())%this.KL_size;
			
			for(int i=0; i<this.key_list[location].size(); i++ )
			{
				if (this.key_list[location].get(i).key().equals(key))
				{
					@SuppressWarnings("unchecked")
					ValueType rvalue=(ValueType)key_list[location].get(i).value();
					key_list[location].remove(i);
					this.KL_count--;
					
					return (ValueType)rvalue;
				}
			}
		}	
		return null;	
	}
	
	public void clear()
	{
		for (int i=0; i<this.KL_size; i++)
			this.key_list[i]=null;	
		
		this.KL_count=0;
		this.KL_size=0;
	}
	
	public int size() 
	{
		return this.KL_count;
	}
}
