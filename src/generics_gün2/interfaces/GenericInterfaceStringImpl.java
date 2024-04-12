package generics_gün2.interfaces;
//2.SEÇENEK : Generic Interface'i implement ederken data tipine karar verebiliriz.
public class GenericInterfaceStringImpl<String> implements GenericInterfaces<String>{


    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return null;
    }
}
