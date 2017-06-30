/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.insightfullogic.java8.examples.chapter1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 *
 * @author richard
 */
public class RyanChapter1 extends MusicChapter {

    public List<String> getNamesOfArtists_Lambda() {
        return artists.stream()
                      .map(artist -> artist.getName())
                      .collect(Collectors.toList());
    }
    
    public List<String> getNamesOfArtists_MethodReference() {
        return artists.stream()
                      .map(Artist::getName)
                      .collect(Collectors.toList());
    }
    
    public List<Artist> artistsLivingInLondon() {
        return artists.stream()
                      .filter(artist -> "London".equals(artist.getNationality()))
                      .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("test");
            System.out.println("test2");
        };

        ActionListener actionListener =
                e -> System.out.println(e.toString());

        BinaryOperator<Integer> binaryOperator =
                (integer, integer2) -> integer + integer2;
    }

}
