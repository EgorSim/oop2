package L6;

import L6.comparator.TitleArtistComparator;
import L6.model.Artist;
import L6.model.Song;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static L6.util.Utils.getRandomDate;
import static L6.util.Utils.getRandomInt;
import static L6.util.Utils.getRandomString;
import static org.assertj.core.api.Assertions.assertThat;


class SongComparatorTest {

    private static final String SONG_1_TITLE = "Book test title";
    private static final String SONG_2_TITLE = "Book title test";
    private static final String ARTIST_1 = "LOVV66";
    private static final String ARTIST_2 = "Егор Крид";

    private static List<Song> sortingByTitle;
    private static List<Song> sortingByTitleAndArtist;

    @BeforeAll
    static void setUp() {
        sortingByTitle = getSortingByTitle();
        sortingByTitleAndArtist = getSortingByTitleAndArtist();
    }


    @Test
    @DisplayName("Сортировка только по названию песни")
    void sortBookByTitle(){
        var songs = new ArrayList<Song>();
        songs.add(new Song()
                .setTitle(SONG_2_TITLE)
                .setPagesCount(getRandomInt())
                .setArtist(
                        new Artist()
                                .setBirthDate(getRandomDate())
                                .setName(getRandomString())
                                .setSurname(getRandomString())
                ));

        songs.add(new Song()
                .setTitle(SONG_1_TITLE)
                .setPagesCount(getRandomInt())
                .setArtist(
                        new Artist()
                                .setBirthDate(getRandomDate())
                                .setName(getRandomString())
                                .setSurname(getRandomString())
                ));

        songs.sort(new TitleArtistComparator());

        for (int i = 0; i < songs.size(); i++) {
            assertThat(songs.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields("pagesCount", "artist")
                    .isEqualTo(sortingByTitle.get(i));
        }
    }

    @Test
    @DisplayName("Сортировка только по словам в песне и артисту")
    void sortBookByTitleAndAuthor(){
        var songs = new ArrayList<Song>();
        songs.add(new Song()
                .setTitle(SONG_2_TITLE)
                .setPagesCount(getRandomInt())
                .setArtist(
                        new Artist()
                                .setBirthDate(getRandomDate())
                                .setName(getRandomString())
                                .setSurname(ARTIST_2)
                ));

        songs.add(new Song()
                .setTitle(SONG_1_TITLE)
                .setPagesCount(getRandomInt())
                .setArtist(
                        new Artist()
                                .setBirthDate(getRandomDate())
                                .setName(getRandomString())
                                .setSurname(ARTIST_1)
                ));

        songs.sort(Comparator.comparing(Song::getPagesCount).thenComparing(Song::getArtist));

        for (int i = 0; i < songs.size(); i++) {
            assertThat(songs.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields("pagesCount", "artist.name", "artist.birthDate")
                    .isEqualTo(sortingByTitleAndArtist.get(i));
        }
    }

    private static List<Song> getSortingByTitle(){
        return List.of(
                new Song()
                        .setTitle(SONG_1_TITLE)
                        .setPagesCount(getRandomInt())
                        .setArtist(
                                new Artist()
                                        .setBirthDate(getRandomDate())
                                        .setName(getRandomString())
                                        .setSurname(getRandomString())
                        ),
                new Song()
                        .setTitle(SONG_2_TITLE)
                        .setPagesCount(getRandomInt())
                        .setArtist(
                                new Artist()
                                        .setBirthDate(getRandomDate())
                                        .setName(getRandomString())
                                        .setSurname(getRandomString())
                        )
        );
    }

    private static List<Song> getSortingByTitleAndArtist(){
        return List.of(
                new Song()
                        .setTitle(SONG_1_TITLE)
                        .setPagesCount(getRandomInt())
                        .setArtist(
                                new Artist()
                                        .setBirthDate(getRandomDate())
                                        .setName(getRandomString())
                                        .setSurname(ARTIST_1)
                        ),
                new Song()
                        .setTitle(SONG_2_TITLE)
                        .setPagesCount(getRandomInt())
                        .setArtist(
                                new Artist()
                                        .setBirthDate(getRandomDate())
                                        .setName(getRandomString())
                                        .setSurname(ARTIST_2)
                        )
        );
    }
}