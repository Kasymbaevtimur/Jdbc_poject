package org.peaksoft;

import org.peaksoft.dao.UserDaoJdbcImpl;

public class Main {
    public static void main(String[] args) {


        UserDaoJdbcImpl daoJdbc = new UserDaoJdbcImpl();

        daoJdbc.createUsersTable();
        daoJdbc.saveUser("Karim", "Benzema", (byte) 34);
        daoJdbc.saveUser("Luka", "Modric", (byte) 36);
        daoJdbc.saveUser("Toni", "Kroos", (byte) 32);
        daoJdbc.saveUser("Federico", "Valverde", (byte) 23);
        daoJdbc.saveUser("Eduardo", "Camavinga", (byte) 19);

        System.out.println(daoJdbc.getAllUsers());
        daoJdbc.cleanUsersTable();
        daoJdbc.dropUsersTable();

    }
}
