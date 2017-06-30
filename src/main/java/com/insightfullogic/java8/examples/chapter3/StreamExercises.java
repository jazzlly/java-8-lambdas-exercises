package com.insightfullogic.java8.examples.chapter3;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {

    // Q3
    public static int countBandMembersExternal(List<Artist> artists) {
        // BEGIN COUNT_MEMBERS_EXTERNAL
    int totalMembers = 0;
    for (Artist artist : artists) {
        Stream<Artist> members = artist.getMembers();
        totalMembers += members.count();
    }
        // END COUNT_MEMBERS_EXTERNAL

        return totalMembers;
    }

    // map f = foldr ((:) . f) []
    // Advanced Exercise
    public static <T, R> List<R> map(Stream<T> stream, Function<T, R> mapper) {
        return stream.reduce(new ArrayList<>(), (acc, value) -> {
        	// Make copy of list (modifying acc would violate contract of reduce method) 
            ArrayList<R> result = new ArrayList<>();
            result.addAll(acc);
            result.add(mapper.apply(value));
            return result;
        }, (left, right) -> {
            ArrayList<R> result = new ArrayList<>();
            result.addAll(left);
            result.addAll(right);
            return result;
        });
    }

    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3)
                        .reduce(0, (acc, element) -> acc + element)
        );

        System.out.println(
                SampleData.membersOfTheBeatles.stream()
                        .map(artist -> artist.getName() + "," + artist.getNationality())
                        .collect(Collectors.toList())
        );

        System.out.println(
                Stream.of(SampleData.manyTrackAlbum,
                        SampleData.sampleShortAlbum,
                        SampleData.aLoveSupreme)
                        .filter(album -> album.getTrackList().size() <= 3)
                        .collect(Collectors.toList())
        );

        System.out.println(
                SampleData.manyTrackAlbum.getMusicianList().stream()
                        .map(artist -> artist.getMembers().count())
                        .reduce(0L, (a, e) -> a + e));

        System.out.println(
            "myheLLo, worLD!".chars().filter(s -> {
                char c = (char) s;
                return (c >= 'a' && c <= 'z');
            }).count()
        );

        System.out.println(
                Stream.of("hello", "test", "myMO", "MKL:KLJIJlks")
                        .max(Comparator.comparingInt(StreamExercises::lowcaseLen)).get()
        );
    }

    static int lowcaseLen(String str) {
        return (int) str.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    int test(int a, int b) {
        int c = 20;
        return a + b + c;
    }
    // todo: 第三章高阶练习

}
