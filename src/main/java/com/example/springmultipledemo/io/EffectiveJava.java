package com.example.springmultipledemo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

/**
 * @Describe
 * @Author orang
 * @Create 2019/2/13 10:33
 **/
public class EffectiveJava {
    public static void main(String[] args) {
        File file = new File("F:\\Documents\\effictivejava3单词.txt");
        File file1 = new File("F:\\Documents\\effictivejava3单词去重复.txt");
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(file.toPath());
                BufferedWriter bufferedWriter = Files.newBufferedWriter(file1.toPath())
        ) {
            Set<String> stringSet = new HashSet<>();
            while (bufferedReader.ready()){
                String input = bufferedReader.readLine();
                stringSet.add(input.trim());
            }
            for (String out:stringSet
                 ) {
                bufferedWriter.write(out);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            System.out.println("程序复制完成单词一共"+stringSet.size()+"个");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
