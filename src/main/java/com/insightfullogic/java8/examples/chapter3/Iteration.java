package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import com.insightfullogic.java8.examples.chapter1.Track;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteration {

    public int externalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN external_count_londoners
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners
        return count;
    }

    public int externalCountArtistsFromLondonExpanded(List<Artist> allArtists) {
        // BEGIN external_count_londoners_expanded
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while(iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners_expanded
        return count;
    }


    public long internalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN internal_count_londoners
//        long count = allArtists.stream()
//                .filter(artist -> artist.isFrom("London"))
//                .count();
//        // END internal_count_londoners
//        return count;
        return allArtists.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
    }

    public void filterArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN filter_londoners
        allArtists.stream()
                .filter(artist -> artist.isFrom("London"));
        // END filter_londoners
    }

    public void filterArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN filter_londoners_printed
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                });
        // END filter_londoners_printed
    }

    public long internalCountArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN internal_count_londoners_printed
        long count = allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                })
                .count();
        // END internal_count_londoners_printed
        System.out.println(count);
        return count;
    }

    public void collect(List<Artist> artists) {
        System.out.println(
                artists.stream()
                        .filter(artist -> artist.isFrom("UK"))
                        .collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        Iteration iteration = new Iteration();
        // iteration.filterArtistsFromLondon(SampleData.membersOfTheBeatles);
        // iteration.internalCountArtistsFromLondonPrinted(SampleData.membersOfTheBeatles);
        iteration.collect(SampleData.membersOfTheBeatles);

        System.out.println(
                SampleData.membersOfTheBeatles.stream()
                        .map(Artist::getName)
                        .collect(Collectors.toList()));

        System.out.println(
                Stream.of("hello", "world")
                        // .map(s -> s.toUpperCase())
                        .map(String::toUpperCase)
                        .collect(Collectors.toList())
        );

        System.out.println(
                Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                        .flatMap(list -> list.stream())
                        .collect(Collectors.toList())
        );

        List<Track> tracks = Arrays.asList(
                new Track("123", 45),
                new Track("234", 89));
        // tracks.stream().max((o1, o2) -> o1.getLength() - o2.getLength());
        System.out.println(
                tracks.stream()
                        .max(Comparator.comparingInt(Track::getLength))
                        .get()
        );

        System.out.println(
                Stream.of(1, 2, 3)
                        .reduce(0, (acc, element) -> acc + element)
        );

        System.out.println(
                SampleData.manyTrackAlbum.getMusicianList().stream()
                        .filter(artist -> !artist.isSolo())
                        .map(Artist::getNationality)
                        .collect(Collectors.toList())
        );

        System.out.println(
                SampleData.manyTrackAlbum.getTrackList().stream()
                        .filter(track -> track.getLength() > 30)
                        .map(Track::getName)
                        .collect(Collectors.toList())
        );

        System.out.println(
                Stream.of(SampleData.manyTrackAlbum, SampleData.aLoveSupreme)
                        .flatMap(album -> album.getTrackList().stream())
                        .filter(track -> track.getLength() > 30)
                        .map(Track::getName)
                        .collect(Collectors.toList())
        );
    }
}
