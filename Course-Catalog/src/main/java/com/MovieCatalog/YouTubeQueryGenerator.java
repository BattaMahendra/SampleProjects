package com.MovieCatalog;

import java.io.*;
import java.util.*;

public class YouTubeQueryGenerator {

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\batta\\Documents\\in.txt";   // your input file
        String outputFilePath = "C:\\Users\\batta\\Documents\\out.txt"; // generated output file

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] words = line.split("\\s+");
                List<String> wordList = Arrays.asList(words);

                List<List<String>> permutations = new ArrayList<>();
                generatePermutations(wordList, 0, permutations);

                for (List<String> perm : permutations) {
                    String joined = String.join("*", perm);
                    bw.write("youtube.*/*search_query=*"
                             + joined
                             + "*");
                    bw.newLine();
                }
                bw.newLine(); // blank line between groups
            }

            System.out.println("✅ Output generated successfully in: " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Recursive permutation generator
    private static void generatePermutations(List<String> list, int index, List<List<String>> result) {
        if (index == list.size() - 1) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, i, index);
            generatePermutations(list, index + 1, result);
            Collections.swap(list, i, index);
        }
    }
}
