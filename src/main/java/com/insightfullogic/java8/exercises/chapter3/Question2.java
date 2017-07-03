package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;
import com.insightfullogic.java8.exercises.Exercises;

import java.util.List;

public class Question2 {
    // Q3
    public static long countBandMembersInternal(List<Artist> artists) {
        return artists.stream().map(artist -> artist.getMembers().count())
                .reduce(0l, (aLong, aLong2) -> aLong + aLong2);
        // return Exercises.replaceThisWithSolution();
    }

    public static void main(String[] args) {
        System.out.println(
                countBandMembersInternal(SampleData.getThreeArtists())
        );
    }
}
