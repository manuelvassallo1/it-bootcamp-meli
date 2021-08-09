package com.meli.morse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ConvertMorseController {

    @GetMapping("/toText/{morse}")
    public String convertToText(@PathVariable String morse) {
        return convert(morse);
    }

    private static final String[] ascii = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?", "!", ":", "@", "=", "-", "+", "\"", "/", "&",
            "'", "(", ")", "ñ"
    };

    private static final String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--..", "-.-.--", "---...", ".--.-.",
            "-...-", "-....-", ".-.-.", ".-..-.", "-..-.", ".-...", ".----.",
            "-.--.", "-.--.-", "--.--"
    };

    private static final Map<String, String> MORSE_TO_TEXT = new HashMap<>();

    static {
        for (int i = 0; i < ascii.length; i++) {
            MORSE_TO_TEXT.put(morse[i], ascii[i]);
        }
    }

    private static String convert(String input) {
        return Arrays
                .stream(input.trim().toUpperCase().split("   "))
                .map(ConvertMorseController::createWord)
                .collect(Collectors.joining(" "));
    }

    private static String createWord(String word) {
        return Arrays.stream(word.split(" ")).map(MORSE_TO_TEXT::get).collect(Collectors.joining(""));
    }
}
