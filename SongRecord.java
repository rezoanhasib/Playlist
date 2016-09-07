/**
* The <CODE>SongRecord</CODE> Java application creates
* an object that comes with a title,an artist,and length(minutes)
* and length(seconds). 
* @author 
* Rezoan Hasib
* <A HREF="mailto:hasib.rezoan@gmail.com"> (hasib.rezoan@gmail.com) </A>
*/

public class SongRecord 
{
	/**
	 * title of a song
	 */
	private String title;
	/**
	 * artist of a song
	 */
	private String artist; 
	/**
	 * the minute length of a song
	 */
	private int lengthMinutes; 
	/**
	 * the second length of a song
	 */
	private int lengthSeconds; 
	/**
	 * default constructor
	 */
	public SongRecord()
	{
		
	}
	/**
	 * constructor to create a new song with given title,artist,lengthMinutes,lengthSeconds
	 * @param title
	 * @param artist
	 * @param lengthMinutes
	 * @param lengthSeconds
	 */
	public SongRecord(String title,String artist,int lengthMinutes,int lengthSeconds)
	{
		this.title=title; 
		this.artist=artist; 
		this.lengthMinutes=lengthMinutes; 
		this.lengthSeconds=lengthSeconds; 
	}
	/**
	 * method to return the title of a song 
	 * @return
	 * 	  the title of selected song 
	 */	   
	public String getTitle()
	{
		return title; 
	}
	/**
	 * method to return the artist of a song 
	 * @return
	 * 	  the artist of selected song 
	 */
	public String getArtist()
	{
		return artist; 
	}
	/**
	 * method to return the length(minutes) of a song 
	 * @return
	 * 	  the length(minutes) of selected song 
	 */
	public int getLengthMinutes()
	{
		return lengthMinutes; 
	}
	/**
	 * method to return the length(seconds) of a song 
	 * @return
	 * 	  the length(seconds) of selected song 
	 */
	public int getLengthSeconds()
	{
		return lengthSeconds; 
	}
	/**
	 * method to set the given title of a song 
	 * @param title
	 * 		the inputed title of a song 
	 */		
	public void setTitle(String title)
	{
		this.title=title; 
	}
	/**
	 * method to set the given artist of a song 
	 * @param artist
	 * 		the inputed artist of a song 
	 */	
	public void setArtist(String artist)
	{
		this.artist=artist; 
	}
	/**
	 * method to set the given length(minutes) of a song 
	 * @param lengthMinutes
	 * 		the length(minutes) of a song 
	 * @throws IllegalArgumentException
	 * 		lets the user know if the inputed minutes is negative
	 */
	public void setLengthMinutes(int lengthMinutes)throws IllegalArgumentException
	{
		if(lengthMinutes<0)
			throw new IllegalArgumentException("Minute value is out of range!!"); 
		this.lengthMinutes=lengthMinutes; 
	}
	/**
	 * method to set the given length(seconds) of a song 
	 * @param lengthSeconds
	 * 		the length(seconds) of a song 
	 * @throws IllegalArgumentException
	 * 		lets the user know if the inputed seconds is negative or more than 59 
	 */
	public void setLengthSeconds(int lengthSeconds) throws IllegalArgumentException 
	{
		if(lengthSeconds<0 || lengthSeconds>59)
			throw new IllegalArgumentException("Second value is out of range!!"); 
		this.lengthSeconds=lengthSeconds; 
	}
	/**
	 * method to return the length of a song in minutes and seconds
	 * @return
	 * 		the song length in minutes and seconds 
	 */		
	public String getLength()
	{
		String temp=null;
		if(lengthSeconds<10)
			temp=lengthMinutes+":0"+lengthSeconds;
		else 
			temp=lengthMinutes+":"+lengthSeconds;
		return temp; 
		
	}
	/**
	 * @post 
	 * 		the title,artist and the length is printed on the screen 
	 */
	public String toString()
	{
		return String.format("%-15s%-25s%-18s%13s"," ",title,artist,getLength()); 
		
	}
	/**
	 * method to check if two songs are the same 
	 * @param
	 * 		a SongRecord object to compare with 
	 */
	public boolean equals(Object obj)
	{
		if(obj==null)return false;
		else if (!(obj instanceof SongRecord))
			return false; 
		else 
		{	SongRecord temp=(SongRecord) obj; 
			return (temp.title==title) &&
				   (temp.artist==artist) &&
				   (temp.lengthMinutes==lengthMinutes) &&
				   (temp.lengthSeconds==lengthSeconds); 
		}
	}
	/**
	 * method to copy a song into a new song 
	 * @return
	 * 		returns the copied song 
	 */
	public SongRecord clone()
	{
		SongRecord tempSongRecord=new SongRecord(); 
		tempSongRecord.artist=this.artist; 
		tempSongRecord.title=this.title;
		tempSongRecord.lengthMinutes=this.lengthMinutes; 
		tempSongRecord.lengthSeconds=this.lengthSeconds;
		
		return tempSongRecord; 
		
	}
	
}

