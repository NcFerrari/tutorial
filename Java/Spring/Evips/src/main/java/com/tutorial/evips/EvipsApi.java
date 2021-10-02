package com.tutorial.evips;

import com.tutorial.evips.user.IUser;
import com.tutorial.evips.user.Visitor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EvipsApi {

    /******************************************************************************************************************/
    //=========================================== KONSTANTNI ATRIBUTY TRIDY ============================================
    //================================================ ATRIBUTY TRIDY ==================================================
    //========================================= KONSTANTNI ATRIBUTY INSTANCE ===========================================
    //============================================== ATRIBUTY INSTANCE =================================================

    /******************************************************************************************************************/
    //============================================ PRISTUPOVE METODY TRIDY =============================================
    //================================================= METODY TRIDY ===================================================
    //================================================== KONSTRUKTOR ===================================================
    //================================================ TOVARNI METODA ==================================================

    /******************************************************************************************************************/
    //============================================ KONECNE METODY INSTANCE =============================================
    //========================================== PRISTUPOVE METODY INSTANCE ============================================
    //================================================ METODY INSTANCE =================================================

    /******************************************************************************************************************/
    //================================================ SOUKROME METODY =================================================
    //================================================== MAIN METODA ===================================================
    public static void main(String[] args) {
        // lead the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrive bean from spring container
        IUser firstUser = context.getBean("firstUser", IUser.class);
        Visitor secondUser = context.getBean("secondUser", Visitor.class);
        // call method on the bean
        System.out.println(firstUser.getAuthorization());
        System.out.println(secondUser.getAuthorization());
        // let's call our new method for role
        System.out.println(firstUser.getRole());
        System.out.println(secondUser.getRole());
        System.out.println(secondUser.getEmail());
        System.out.println(secondUser.getAddress());
        // close context
        context.close();
    }

    /******************************************************************************************************************/
    //=============================================== TESTOVACI METODY =================================================
    //================================================ SOUKROME TRIDY ==================================================
}
