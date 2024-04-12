package generics_gün2.classes;
//amacımız: farklı data tipindeki ürün kodlarını tutabilmek için
//ayrı ayrı classlar oluşturmadan (book, phone, laptop,...)
//tek bir class ile ürün objelerini oluşturmak
//çözüm : generic bir product class


     /*

     Generic olarak sadece NON_PRIMITVE data tipi kullanılabilir! (int,double kullanılamaz)
        E --> Element, collection gibi yapılarda kullanılır
        K --> Key
        V --> Value
        N --> Number
        T --> Type
        S,U,V , vb --> 2., 3. ve 4. tipler için
      */

public class GenericProduct <T> {

    private T code; //herhangi bir NON-Primitive data tipi gelebilir.

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }
}
