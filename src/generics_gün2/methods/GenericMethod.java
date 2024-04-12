package generics_gün2.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        Integer[] intArr = {2, 3, 8, 99, 55};
        Double[] doubleArr = {1.3, 35.6, 99.9, 0.5};
        String[] stringArr = {"Java", "generics", "hayatımızı", "kolaylaştırır"};

        printArray(intArr);
        printArray(doubleArr);
        printArray(stringArr);

        printArrayGeneric(doubleArr);

        System.out.println(getFirst(stringArr)); // T: String
        System.out.println(getFirst(doubleArr)); //T: Double
        System.out.println(getFirst(intArr)); //T: Integer

        Integer first = getFirst(intArr);

    }


    //arrayleri yazdırmak için metod tanımlayalım.
    public static void printArray(Integer[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.println(t + " "));
        System.out.println();

    }

    public static void printArray(Double[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.println(t + " "));
        System.out.println();
    }

    public static void printArray(String[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.println(t + " "));
        System.out.println();
    }

    public static <T> void printArrayGeneric(T[] arr) {
        Arrays.stream(arr).forEach(t -> System.out.println("Generic: " + t + " "));
    }

    //Generic method ile generic bir data tipi döndürme
    //Geriye dönüş data tipi, T olmak zorunda değil.
    public static <T> T getFirst(T[] arr) { //<T> T-- Geri dönüş tipini belirtir.
        T first = arr[0];
        return first;

    }

    //Birden fazla data tipiyle generic method
    public static <T,U> void printArrAndElement(T[] arr,U element){

        //arr[0] = element; -->//ikisi farklı data tipi olabilir bu yüzden type security için bunu kabul etmez.


        Arrays.stream(arr).forEach(t-> System.out.println( t + " "));
        System.out.println(element);

    }


}
