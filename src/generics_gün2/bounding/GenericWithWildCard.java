package generics_gün2.bounding;


import java.util.ArrayList;
import java.util.List;

//wildcard(?): Joker. Bilinmeyen Data Tipi
public class GenericWithWildCard {

    public static void main(String[] args) {

        //?:bilinmeyen data tipi
        //wildcard: read-only
        //sadece data tipinden bağımsız işlemler yapılabilir
        //örn:remove,size,...


        //!!! NOT:List<T> ve List<?> benzer , fakat tamamen aynı değildir.


        //alttan sınırlama
        //listeye 1'den 10'a kadar Integer elemanları ekleyen bir metod tanımlaylalım.
        //list: Integer,Number,Object

        List<Integer> integers= new ArrayList<>();
        List<String> strings= new ArrayList<>();
        List<Double> doubles= new ArrayList<>();
        List<Number> numbers= new ArrayList<>();
        List<Object> objects= new ArrayList<>();


        System.out.println("---------------------Alttan sıralama---------------------");
        addElements(integers);
        //addElements(doubles); CTE
        //addElements(strings); CTE
        addElements(numbers);
        addElements(objects);

        multiplyByTwo(integers);
        multiplyByTwo(doubles);
        //multiplyByTwo(strings);
        //multiplyByTwo(objects);


        System.out.println("---------------------Sadece WildCard-----------------------");
        printElements(integers);
        printElements(doubles);
        printElements(strings);
        printElements(objects);

    }


    //alttan sınırlama
    public static void addElements(List<? super Integer> list){ //

        for (int i = 1; i < 11; i++){
            list.add(i);
        }
        System.out.println(list);


    }
    //Generic yapıyı üstten sınırlama
    //Listedeki elemanları 2 ile çarpan bir metod
    public static void multiplyByTwo(List<? extends Number> list){
        list.stream().map(t->2*t.doubleValue());
    }


    public static void printElements(List<?> list){//List<T> benzer
        for (Object obj : list){
            System.out.println(obj + " ");
        }

        //!!! NOT: List<T> ile List<?> benzer fakat tamamen aynı değil.
    }











}
