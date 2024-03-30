package com.busycoder.bankapp.dao;

import com.busycoder.bankapp.entities.Account;
import com.busycoder.bankapp.exceptions.BankAccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;
@Repository
@Primary
public class AccountDaoImpl implements AccountDao{

    private EntityManagerFactory emf;

    @Autowired
    public AccountDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManager getEm(){
        return emf.createEntityManager();
    }
    @Override
    public List<Account> getAll() {
        return getEm().createQuery("select a from Account a", Account.class).getResultList();
    }

    @Override
    public Optional<Account> getById(int id) {
        Account account=getEm().find(Account.class, id);
        return Optional.ofNullable(account);
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println(account);
        getEm().merge(account);
        System.out.println("---------------------------------");
    }

    @Override
    public void addAccount(Account account) {
        getEm().persist(account);
    }

    @Override
    public void deleteAccount(int id) {
        Account account=getById(id)
                .orElseThrow(()-> new BankAccountNotFoundException("account with id "+id +" is not found"));
        getEm().remove(account);

    }
}
