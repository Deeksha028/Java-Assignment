package com.wipro.rest.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.rest.jpa.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

    Bank findByAccountHolderName(String name);

    List<Bank> findByBalanceGreaterThanOrderByAccountHolderNameAsc(double balance);
    

 
     @Query("select b from Bank b order by b.balance")
     public List<Bank> findAllBySorted();

     
     @Query("select b from Bank b where b.balance between ?1 and ?2")
     public List<Bank> findByBalanceRange(double min, double max);

     
     @Modifying
     @Query("update Bank b set b.balance = :bal where b.accountNumber = :id")
     public int updateBalance(@Param("bal") double balance, @Param("id") int accNo);

     @Query(value = "select * from bank", nativeQuery = true)
     public List<Bank> getAllBySQL();


}