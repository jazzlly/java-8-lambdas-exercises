package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;
import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class LongestName {

    public static Artist byReduce(List<Artist> artists) {
//        return artists.stream()
//                .reduce(new Artist("", ""),
//                        BinaryOperator.maxBy((o1, o2) -> o1.getName().length() - o2.getName().length()));
//
                return artists.stream()
                .reduce(new Artist("", ""),
                        (artist, artist2) -> {
                            if (artist2.getName().length() > artist.getName().length()) {
                                return artist2;
                            } else {
                                return artist;
                            }
                        });

    }

    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream().collect(
                () -> new Artist("", ""),
                (artist, artist2) -> {
                    if (artist.getName().length() < artist2.getName().length())
                        artist = artist2;
                },
                (artist1, artist21) -> {
                    if (artist1.getName().length() < artist21.getName().length()) {
                        artist1 = artist21;
                    }
                }
        );
        // return Exercises.replaceThisWithSolution();
    }

    public static void main(String[] args) {
        LongestName longestName = new LongestName();

        System.out.println(
                longestName.byReduce(Arrays.asList(
                        new Artist("tet", ""), new Artist("ttttt", "")))
        );

        System.out.println(
                longestName.byCollecting(Arrays.asList(
                        new Artist("tet", ""), new Artist("ttttt", "")))
        );

    }

}
