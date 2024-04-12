package generics_gün2.interfaces;


//1. SEÇENEK : Generic bir interface'i implement eden sınıf da Generic olmalı


public class GenericInterfaceImpl<T> implements GenericInterfaces <T>{
    @Override
    public void print(T value) {
        System.out.println(value);
    }

    @Override
    public T find() {
        return null;
    }
}
