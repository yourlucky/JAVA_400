import java.util.*;

interface SearchBackEndInterface {
    /**
     * Add a song to the backend data by providing a SongDataInterface.
     * @param song the song to be added to the backend data.
     */
    public void addSong(SongDataInterface song);

    /**
     * Check if the given song is in the backend data.
     * @param song the SongDataInterface to be checked
     * @return true if the given song is in the backend data, otherwise false
     */
    public boolean containsSong(SongDataInterface song);

    /**
     * Find the titles that contain the word titleWord in their song title
     * @param titleWord the searched title word
     * @return the List which contains all songs that contain the word titleWord in their song title.
     */
    public List<String> findTitles(String titleWord);

    /**
     * Find list of the artists of all songs that contain the word titleWord in their song title
     * @param titleWord the searched title word
     * @return the List of the artists of all songs that contain the word titleWord in their song
     * title
     */
    public List<String> findArtists(String titleWord);

    /**
     * Find the number of songs that contain the word titleWord in their song title, and were
     * published in given year.
     * @param titleWord the searched title word
     * @param year the searched year
     * @return the number of songs that contain the word titleWord in their song title, and were
     * published in year
     */
    public int findNumberOfSongsInYear(String titleWord, int year);
}

public class SearchBackEnd implements SearchBackEndInterface {
    private Set<SongDataInterface> songs = new HashSet<>();
    private MapADT<String, List<SongDataInterface>> titleSongsMap = new HashtableMap<>();
    private MapADT<String, List<SongDataInterface>> artistSongsMap = new HashtableMap<>();

    @Override
    public void addSong(SongDataInterface song) {
        // add song
        songs.add(song);

        // add every title words to titleSongsMap
        String fullTitile = song.getTitle();
        addSongHelper(song, fullTitile, titleSongsMap);

        // add every words of the artist's name to artistSongsMap
        String fullArtist = song.getArtist();
        addSongHelper(song, fullTitile, artistSongsMap);
    }

    private void addSongHelper(SongDataInterface song, String fullName,
                               MapADT<String, List<SongDataInterface>> songMap) {
        String[] words = fullName.split(" ");
        for (String word : words) {
            List<SongDataInterface> titleSongs;
            if (songMap.containsKey(word)) {
                titleSongs = songMap.get(word);
                titleSongs.add(song);
            } else {
                titleSongs = new LinkedList<>();
                titleSongs.add(song);
                songMap.put(word, titleSongs);
            }
        }
    }

    private List<String> songsToTitles(List<SongDataInterface> songs) {
        List<String> titles = new LinkedList<>();
        for (SongDataInterface song : songs) {
            titles.add(song.getTitle());
        }
        return titles;
    }

    private List<String> songsToArtists(List<SongDataInterface> songs) {
        Set<String> artistSet = new HashSet<>();
        for (SongDataInterface song : songs) {
            artistSet.add(song.getArtist());
        }
        return new LinkedList<>(artistSet);
    }

    @Override
    public boolean containsSong(SongDataInterface song) {
        return songs.contains(song);
    }

    @Override
    public List<String> findTitles(String titleWord) {
        List<SongDataInterface> songs;
        try {
            songs = titleSongsMap.get(titleWord);
        } catch (NoSuchElementException e) {
            return new LinkedList<>();
        }
        return songsToTitles(songs);
    }

    @Override
    public List<String> findArtists(String titleWord) {
        List<SongDataInterface> songs;
        try {
            songs = titleSongsMap.get(titleWord);
        } catch (NoSuchElementException e) {
            return new LinkedList<>();
        }
        return songsToArtists(songs);
    }

    @Override
    public int findNumberOfSongsInYear(String titleWord, int year) {
        List<SongDataInterface> songs;
        try {
            songs = titleSongsMap.get(titleWord);
        } catch (NoSuchElementException e) {
            return 0;
        }
        int count = 0;
        for (SongDataInterface song : songs) {
            if (year == song.getYearPublished()) {
                count++;
            }
        }
        return count;
    }

}
