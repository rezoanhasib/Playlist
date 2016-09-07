import java.util.Scanner; 
/**
 * method to check both the SongRecord and Playlist classes 
 * @author 
 * Rezoan Hasib
 * <A HREF="mailto:hasib.rezoan@gmail.com"> (hasib.rezoan@gmail.com) </A>
 */
public class PlaylistOperations {
	
	 public static final int PLAYLIST_MAXNUMBER = 50;
	 static int tempPlaylist = 0, nextPlaylistlist = 2;
	
	public static void main(String[] args) throws FullPlaylistException,
	IllegalArgumentException,CloneNotSupportedException
	{
		String title,artist=""; 
		int minutes,seconds,position; 
		Playlist myPlaylist=new Playlist();
		boolean notQuit=true; 
        String currentPlaylist = "", nextPlaylist= "";
        String[] sample = new String[30];
        int size=0; 
        Playlist[] playlist = new Playlist[PLAYLIST_MAXNUMBER];


		while(notQuit)
		{
			System.out.println("***At least one song must be added in order to "+
			"make a new playlist***\n");
			System.out.println("Program Selection\tChoice");
			System.out.println("-----------------\t------");
			System.out.println("Add Song:\t\t  A  <Title> <Artist> <Minutes> "
					+ "<Seconds> <Position>");
			System.out.println("Get Song:\t\t  G  <Position>");
			System.out.println("Remove Song:\t\t  R  <Position>");
			System.out.println("Print All Songs:\t  P");
			System.out.println("Print Songs By Artist: \t  B  <Artist>");
			System.out.println("Size: \t\t\t  S");
			System.out.println("Quit: \t\t\t  Q");
		
			System.out.print("Select a menu option: "); 
		
			Scanner input=new Scanner(System.in);
			String userInput=input.nextLine(); 
			userInput=userInput.toUpperCase(); 
			/**
			 * switch method to determine function of the user input
			 */
			switch(userInput)
			{
				case "A": 
				{
					System.out.println("Enter the song title: ");
					title=input.nextLine();	
					System.out.println("Enter the song artist: ");
					artist=input.nextLine();	
					System.out.println("Enter the song length (minutes): ");
					minutes=input.nextInt(); 
					System.out.println("Enter the song length (seconds): ");
					seconds=input.nextInt(); 
					System.out.println("\nEnter the position: ");
					position=input.nextInt(); 
			
					SongRecord song=new SongRecord(title,artist,minutes,seconds); 
				try
				{
					myPlaylist.addSong(song, position);
				} catch (IllegalArgumentException e) 
				{		
					e.printStackTrace();
				} catch (FullPlaylistException e)
				{
					e.printStackTrace();
				}
				break; 
				
			}//end of case A
				
				case "G": 
				{
					
						System.out.print("Enter the position: ");
						position=input.nextInt();
						SongRecord tempSong=myPlaylist.getSong(position); 
						System.out.println(String.format("%1s %8s %26s %26s", "Song#","Tit"
								+ "le", "Artist", "Length"));
                        System.out.println("----------------------------------------------"
                        		+ "-----------------------");
						System.out.println(String.format("%-10s%-22s%-18s%13s",position,
								tempSong.getTitle(),tempSong.getArtist(),
								tempSong.getLength())); 
					break; 
				}
				
				case"P":
				{	
					myPlaylist.printAllSongs();
					break; 
				}
				
				case "R": 
				{
					System.out.print("Enter the position: ");
					position=input.nextInt(); 
					myPlaylist.removeSong(position);
					break; 
				}
				
				case"B":
				{
					Playlist tempPlaylist=new Playlist(); 
					System.out.print("Enter the artist name: ");
					artist=input.nextLine(); 
					tempPlaylist=(Playlist.getSongsByArtist(myPlaylist, artist));
                    tempPlaylist.printAllSongs();
                    
                    break;    
				}
				
				case"S":
				{
					System.out.print("There are "+myPlaylist.size()+" song(s) in"
							+ " the current playlist.\n");
					break; 
				}
				
				case"Q":
				{
					System.out.println("Program terminating normally...");
					notQuit=false; 
					break; 
				}
				case "N":

                    System.out.print("Enter the name of playlist: ");

                    for (; tempPlaylist < PLAYLIST_MAXNUMBER; ) {
                        input.nextLine();
                        currentPlaylist = input.nextLine();

                        tempPlaylist = size;
                        tempPlaylist++;
                        sample[tempPlaylist] = currentPlaylist;
                        size++;
                        for(int k = 1;  k < size; k++){

                            if(sample[k].equalsIgnoreCase(currentPlaylist)){
                                System.out.println("Playlist already exist");
                                sample[tempPlaylist] = null;
                                size--;
                                break;
                            }

                        }
                        if(sample[tempPlaylist]== null){
                            tempPlaylist--;
                            break;
                        }
                           playlist[tempPlaylist] = new Playlist();




                        System.out.println("Playlist: " + currentPlaylist + " added");
                        System.out.println("Playlist " + currentPlaylist + " is currently selected");

                        break;
                    }
                    break;
				
				default: 
					System.out.println("Invalid selection of choice!");
					System.out.println("Please try again: "); 			
		}
		
	}
	
	}
	
}
