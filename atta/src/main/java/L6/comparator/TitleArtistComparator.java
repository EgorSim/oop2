package L6.comparator;

import L6.model.Artist;
import L6.model.Song;

import java.util.Comparator;


/**
 * Сортировка городов по названию
 */
public class TitleArtistComparator implements Comparator<Song> {

    @Override
    public int compare(Song o1, Song o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

}
