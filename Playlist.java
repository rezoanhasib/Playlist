/**
* a method to create a new playlist with selected songs
* @author 
* Rezoan Hasib
* <A HREF="mailto:hasib.rezoan@gmail.com"> (hasib.rezoan@gmail.com) </A>
*/

public class Playlist implements Cloneable
{
	static final int MAX_SIZE = 50;
	private int capacity = 0;
	private SongRecord records[];
	private int itemNumber; 
	/**
	 * default constructor 
	 */
	public Playlist()
	{
		records = new SongRecord[MAX_SIZE];
	
	}
	/**
	 * constructor to create a playlist 
	 * @param capacity
	 * 		number items in the playlist 
	 */		
	public Playlist(int capacity)
	{
		records = new SongRecord[capacity];
	}
	/**
	 * method to create a deep copy of an object 
	 * @throws CloneNotSupportedException
	 * 		helps to know if the cloning is not possible 
	 */
	public Object clone() throws CloneNotSupportedException
	{	
		Playlist PlaylistClone=(Playlist)super.clone();
		for(int x=1;x<=itemNumber;x++)
		{ 
			PlaylistClone.records[x]=(SongRecord)(records[x].clone()); 
		}
		return PlaylistClone; 

	}
	/**
	 * method to provide a particular song description 
	 * @param index
	 * 		the position of the asked song 
	 * @return
	 * 		the requested song 
	 */
	public SongRecord getRecords(int index)
	{
		return records[index]; 
	}
	/**
	 * method to check if two songs are the same 
	 * @param
	 * 		the song being compared with 
	 * @return	
	 * 		true if two compared songs are equal 
	 */
	public boolean equals (Object obj)
	{
		if(!(obj instanceof Playlist))
			return false;
		Playlist temp=(Playlist) obj; 
		if(temp.size()!=itemNumber)
			return false; 
		for(int a=1;a<=itemNumber;a++)
		{
			if((temp.getRecords(a).equals(records[a]))==false)
			{
				return false;
			}
		}
		return true; 
	}
	/**
	 * method to return the number of songs in a perticular playslist 
	 * @return itemNumber
	 * 		the number of songs in an array
	 */
	public int size()
	{
		return itemNumber; 
	}
	/**
	 * method to add a song to a playlist 
	 * @param song
	 * 		the song to be added to the list 
	 * @param position
	 * 		the position where the song to be added 
	 * @throws IllegalArgumentException
	 * 		lets the user know if the position is out of range		
	 * @throws FullPlaylistException
	 * 		lets the usesr know if the 
	 * 		playlist is already full so no new songs can be added  
	 */	  
	public void addSong(SongRecord song,int position) throws IllegalArgumentException,FullPlaylistException
	{
		if((position<1) || (position>itemNumber+1))
			throw new IllegalArgumentException("Position is out of range!!\n"); 
		if(itemNumber>MAX_SIZE)
		{
			itemNumber--; 
			throw new FullPlaylistException(); 
		}
		itemNumber++; 

		if(records[position]!=null)
		{
			int z=1; 
			for(int y=position;y<itemNumber;y++)
			{
				records[itemNumber-z+1]=records[itemNumber-z]; 
				z++; 
			}
		}
		records[position]=song;
		System.out.println("New Song added!!	Title: "+song.getTitle()+", Artist: "+song.getArtist()+".\n"); 
		
	}
	/**
	 * method to remove a song from the playlist 
	 * @param position
	 * 		the positio to remove the song from 
	 * @throws IllegalArgumentException
	 * 		lets the user know if the postion is out of range 
	 */
	public void removeSong(int position)throws IllegalArgumentException
	{
		if(position<1||position>itemNumber)
			throw new IllegalArgumentException("Removal position is out of range!!"); 
		
		System.out.println("Song deleted!!	  Title: "+records[position].getTitle()+", Artist: "+records[position].getArtist()); 

		int z=1; 
		for(int y=position;y<itemNumber;y++)//shouldn't it be y<=itemNumber? 
		{
			records[position-1+z]=records[position+z]; 
			z++; 
		}
		itemNumber--; 
	}
	/**
	 * method to get the details of a perticular song 
	 * @param position
	 * 		position/index of song removal 
	 * @return
	 * 		desired song description 
	 * @throws IllegalArgumentException
	 * 		if the position is not in range 
	 */
	public SongRecord getSong(int position)throws IllegalArgumentException
	
	{
		if(position<1||position>itemNumber)
			throw new IllegalArgumentException("GetSong argument is out of range!!"); 
		return records[position]; 
	}
	/**
	 * method to print all the songs in a playlist 
	 * @postcondition 
	 * 		all the songs in the playlist are printed in the screen 
	 */
	public void printAllSongs()
	{
		System.out.println(toString());
	}
	/**
	 * mehtod to get a new playlist containing songs of the same artist 
	 * @param originalList
	 * 		original playlist containing all the songs 
	 * @param artist
	 * 		the artist name 
	 * @return
	 * 		the new created playlist 
	 * @throws IllegalArgumentException
	 * 		if artist is not found 
	 */
	public static Playlist getSongsByArtist(Playlist originalList,String artist) throws IllegalArgumentException
	{
		int playlistByArtistIndex=1;
		boolean artistMatch=false; 
		Playlist playlistByArtist=new Playlist();
		for(int x=1;x<=originalList.size();x++)
		{
			if(artist.equals(originalList.records[x].getArtist()))
			{
				artistMatch=true;
				break; 
			}
		}
		if(artistMatch==false)
			throw new IllegalArgumentException("Artist: "+artist+" is not valid in the current playlist!!"); 

		for(int x=1;x<=originalList.size();x++)
		{
			if((originalList.records[x].getArtist()).equals(artist))
			{
				//which side of .equals method should be what data? 
				SongRecord s1 = new SongRecord(originalList.records[x].getTitle(),originalList.records[x].getArtist(), originalList.records[x].getLengthMinutes(),originalList.records[x].getLengthSeconds());
				playlistByArtist.records[playlistByArtistIndex] = s1;//originalList.records[x].clone(); 
				playlistByArtistIndex++; 
				playlistByArtist.itemNumber++;
			}
		}
		
		return playlistByArtist; 
	}
	/**
	 * method to print the song details 
	 * @postcondition 
	 * 		the song is printed 
	 */
	public String toString()
	{
		String answer=""; 
		String temp=""; 
		System.out.println(String.format("%1s %8s %26s %26s","Song#","Title","Artist","Length"));
		System.out.println("---------------------------------------------------------------------");
		for(int x=1;x<=itemNumber;x++)
		{
			temp= Integer.toString(x);
			temp+=records[x].toString(); 
			answer+=temp+"\n"; 		
		}
		return answer; 
	}	
}



