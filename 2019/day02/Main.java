import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{
    public static List<Integer> readString(String input){
        return Arrays.asList(input.split(",")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public static List<Integer> process(List<Integer> list){
        for(int i=0; i<list.size() && list.get(i) != 99; i+=4){
            //System.out.println("starting from pos "+ i);
            Integer operand = list.get(i);
            Integer opcode1 = list.get(list.get(i+1));
            Integer opcode2 = list.get(list.get(i+2));
            Integer destination = list.get(i+3);
            Integer result = 0;
            if(operand == 1){
                result = opcode1 + opcode2;
            }
            else{
                result = opcode1 * opcode2;
            }
            list.set(destination, result);
        }
        return list;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //System.out.println(readString(br.readLine()));
        System.out.println(process(readString("1,0,0,0,99")));
        System.out.println(process(readString("2,3,0,3,99")));
        System.out.println(process(readString("2,4,4,5,99,0")));
        System.out.println(process(readString("1,1,1,4,99,5,6,0,99")));
        System.out.println("processing real input");
        String originalInput = br.readLine();
        List<Integer> l = readString(originalInput);
        l.set(1,12);
        l.set(2,2);
        System.out.println(process(l));

        // part 2: we'll do it brute force :)
        boolean found = false;
        int finalNoun = 0;
        int finalVerb = 0;
        for(int noun = 0; noun <100 && !found; noun++){
            for(int verb = 0; verb<100 && !found; verb++){
                List<Integer> attempt = readString(originalInput);
                attempt.set(1,noun);
                attempt.set(2,verb);
                List<Integer> processed = process(attempt);
                if(processed.get(0) == 19690720){
                    found = true;
                    finalNoun = noun;
                    finalVerb = verb;

                }
            }
        }
        System.out.println(String.format("Found it for verb %d and noun %d",finalVerb,finalNoun));
        System.out.println(String.format("Answer is %d", 100*finalNoun + finalVerb));
        System.out.println("Doublecheck:");
        List<Integer> check = readString(originalInput);
        check.set(1,finalNoun);
        check.set(2,finalVerb);
        System.out.println(process(check).get(0));

    }


}