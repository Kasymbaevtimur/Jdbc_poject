package org.peaksoft;

import org.peaksoft.dao.UserDaoHibernateImpl;

public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();


        // userDaoHibernate.saveUser("Tomi","Shelbi", (byte) 27);
        // userDaoHibernate.saveUser("Karim","Benzema", (byte) 32);
        // userDaoHibernate.saveUser("Luka","Modric", (byte) 36);

        //userDaoHibernate.removeUserById(2);
        //System.out.println(userDaoHibernate.getAllUsers());
        // userDaoHibernate.cleanUsersTable();

    }
}
