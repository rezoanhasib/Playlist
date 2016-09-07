/**
 * an exception class to throw an exception if a playlist is already full 
 * @author 
 * Rezoan Hasib
 * <A HREF="mailto:hasib.rezoan@gmail.com"> (hasib.rezoan@gmail.com) </A>
 */
public class FullPlaylistException extends Exception{

	public FullPlaylistException() {
		super("Playlist is already full!!\n"); 
	}

}
