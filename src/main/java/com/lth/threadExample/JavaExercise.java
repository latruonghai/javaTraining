package com.lth.threadExample;

public class JavaExercise {

    private int Solution(String number){
        int sum = 0;
        int count = 0;
        for(int i = 0; i< number.length(); i++){
            sum += number.charAt(i) - 48;
        }
        if(sum % 3 == 0){
            count++;
        }

        for(int i = 0 ; i<number.length() ; i++){
            int remaining_sum = sum - (number.charAt(i)-48);
            for(int j =0 ; j< 10; j++){
                if((remaining_sum + j) %3 ==0 && j != (number.charAt(i) -48) ){
                    count++;
                }
            }
        }
        return count;
    }

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }
    public static String repeat(int count) {
        return repeat(count, " ");
    }
    public static String Solution2(String[] a, String[] b, String P) {
        String min_string = repeat(20, "z");

        for (int i = 0; i < b.length; i++) {
            if (b[i].indexOf(P) != -1) {
                if (a[i].compareTo(min_string) < 0) {
                    min_string = a[i];
                }
            }
        }
        return min_string;
    }

    public static void main(String[] args){
        String[] a = new String[]{"sander", "ann", "victor", "anna", "amie"};
        String[] b = new String[]{"1586123480", "461861326", "748948968", "489453648", "4053486278"};
        String P = "1";
        System.out.println(Solution2(a, b, P));

    }
}
