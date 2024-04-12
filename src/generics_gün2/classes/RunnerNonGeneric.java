package generics_gün2.classes;

public class RunnerNonGeneric {
    public static void main(String[] args) {


        //2 farklı nesne:book, laptop

        NonGenericProduct book=new NonGenericProduct();
        book.setCode("advjava");//code fieldını String data tipi ile set ettik

        NonGenericProduct laptop=new NonGenericProduct();
        laptop.setCode(123456);//code fieldını Integer data tipi ile set ettik


        // 1- CAST Problemi !!!
        String str = (String) book.getCode();
        String str2= (String) laptop.getCode();

        System.out.println(str); //String
        System.out.println(str2); //int

        //Hata veriyor.Unuttuk int olduğunu, program yandı.
    }
}
