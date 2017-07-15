package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Question1 {
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, element) -> acc + element);
        // return Exercises.replaceThisWithSolution();
    }

    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream()
                .map(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .flatMap(stringStream -> stringStream)
                .collect(toList());
        // return Exercises.replaceThisWithSolution();
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream()
                .filter(album -> album.getTrackList() != null && album.getTrackList().size() <= 3)
                .collect(toList());
       // return Exercises.replaceThisWithSolution();
    }


    public static long getLowcaseCharsNum(String str) {
        return str.chars().filter(value -> Character.isLowerCase(value)).count();
    }

//    public static String getLowcaseMaxString(List<String> strings) {
//        String tmp = "";
//        strings.stream().filter(s -> {
//
//        })
//    }

    public static void main(String[] args) {
        System.out.println(addUp(Stream.of(1,2,3)));

        System.out.println(
                getNamesAndOrigins(
                        Stream.of(
                                new Artist("a1", "n1"),
                                new Artist("a2", "n2")).collect(toList())));

        System.out.println(getLowcaseCharsNum("Hello, World"));

    }
}
