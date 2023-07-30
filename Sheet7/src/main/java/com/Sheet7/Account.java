package com.Sheet7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Account {
    private String name;
    private HashSet<AccountingEntries> entries;

    public Account(String name) {
        this.name = name;
        this.entries = new HashSet<>();
    }

    public AccountingEntries searchEntry (double amount){
        for (AccountingEntries entry : entries) {
            if (entry.getAmount()==amount){
                return entry;
            }
        }
        return null;
    }

    public void addEntry(double amount, String date, String otherAccount) {
        AccountingEntries entry = new AccountingEntries(amount,date,otherAccount);
        entries.add(entry);
    }

    public String getName() {
        return name;
    }

    public Set<AccountingEntries> getEntries() {
        return entries;
    }

    public List<String> getDates() {
        ArrayList<String> dates = new ArrayList<>();
        for (AccountingEntries ae: entries) {
            String date = ae.getDate();
            dates.add(date);
        }
        return dates;
    }
}
