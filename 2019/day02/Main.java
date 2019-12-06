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
        List<Integer> l = readString(br.readLine());
        l.set(1,12);
        l.set(2,2);
        System.out.println(process(l));


    }


}