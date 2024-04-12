package generics_gün2.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGeneric {
    public static void main(String[] args) {


        //Generic yapılar kullanılırken data tipine karar verilir.
        //2 farklı nesne: laptop, book
        GenericProduct<String> book = new GenericProduct<>();
        book.setCode("AdvJava");

        GenericProduct<Integer> laptop = new GenericProduct<>();
        laptop.setCode(123456);
        //laptop.setCode("laptop"); sıkı bir tür denetim, Exception almıyoruz.


        //----------------------------------------------------------
        ArrayList<String> list = new ArrayList<>();

        HashMap<String, Double> hashMap = new HashMap<>();

        hashMap.put("AdvJava", 99.9);
        //hashMap.put(12,23); olmaz, type security ihlal edilir.CTE alırız.

        //-------------ÇOK PARAMETRELİ GENERIC CLASS TANIMLAMA---------------

        //S: String , U: Integer
        GenericClassTwoParam<String,Integer> obj = new GenericClassTwoParam<>("Generic",1234);

        //S: String, U: String
        GenericClassTwoParam<String,String> obj2 = new GenericClassTwoParam<>("Generics","Harika");



    }
}
