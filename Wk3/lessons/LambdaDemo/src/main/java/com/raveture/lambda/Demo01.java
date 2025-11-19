package com.raveture.lambda;
import java.util.Optional;

public class Demo01 {
    public static void main() {
        String [] words=new String[10];
        //words[5]="Perry";

        Optional<String> checkNull=Optional.ofNullable(words[5]);
        if(checkNull.isPresent()){
            String word=words[5].toLowerCase();
            System.out.println(word);
        }
        System.out.println(" The word is null");
    }
}
