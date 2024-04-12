package generics_gün2.bounding;

import java.util.Arrays;

//Generic yapılarda parametre olarak alınan data tipini üstten sınırlandırabiliriz.
//T: sadece Number classının ve  alt sınıfları ile sınırlandıralım.
//T: BYTE,SHORT,INT,DOUBLE,LONG,FLOAT,NUMBER;
public class GenericUpperBound<T extends Number> {

    public T[] numberArray;

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }


    //numberArray içindeki elemanların ortalamasını hesaplayan bir metod yaz
    public Double getaverage() {
        double sum = 0;

        for (T t : this.numberArray) {
            sum += t.doubleValue();
        }

        double avg = sum / this.numberArray.length;
        return avg;
    }

    public static void main(String[] args) {
        Integer[] integers = {2,3,6,9,8,7};
        Double[] doubles = {0.3,99.3,10.0,2.3};
        String[] strings = {"Generics","üstten","sınırlandırılabilir"};


        GenericUpperBound<Integer> obj1 = new GenericUpperBound<>(integers);
        System.out.println(Arrays.toString(integers));
        System.out.println(obj1.getaverage());



        GenericUpperBound<Double> obj2 = new GenericUpperBound<>(doubles);

        System.out.println(obj2.getaverage());

        //GenericUpperBound<String> obj3  = new GenericUpperBound<>(); class Number ile generic boundingli.


    }



}
