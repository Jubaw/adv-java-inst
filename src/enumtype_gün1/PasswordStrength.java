package enumtype_gün1;

public enum PasswordStrength {



    FAIL(0),
    LOW(10),
    MEDIUM(50),
    HIGH(100);









    private final int LEVEL;

    private PasswordStrength(int level){
        this.LEVEL = level;
        System.out.println(level);

    }//default constructor privatetır.ENUM type'lar privatetır.

    public int getLEVEL(){
        return this.LEVEL;
    }










}
