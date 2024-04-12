package generics_gün2.interfaces.example;
//Account'un database işlemleri bu classta yapılacak.
public class AccountRepo<T> implements Repo<Account>{



    @Override
    public void save(Account obj) {

    }
}
