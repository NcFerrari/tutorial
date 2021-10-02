package com.tutorial.evips.user;

import com.tutorial.evips.authorization.IRoleService;

public class Visitor implements IUser {

    /******************************************************************************************************************/
    //=========================================== KONSTANTNI ATRIBUTY TRIDY ============================================
    //================================================ ATRIBUTY TRIDY ==================================================
    //========================================= KONSTANTNI ATRIBUTY INSTANCE ===========================================
    //============================================== ATRIBUTY INSTANCE =================================================
    private IRoleService iRoleService;
    private String email;
    private String address;

    /******************************************************************************************************************/
    //============================================ PRISTUPOVE METODY TRIDY =============================================
    //================================================= METODY TRIDY ===================================================
    //================================================== KONSTRUKTOR ===================================================
    public Visitor() {
        System.out.println("Návštěvník: vnitřek bezparametrického konstruktoru");
    }

    //================================================ TOVARNI METODA ==================================================

    /******************************************************************************************************************/
    //============================================ KONECNE METODY INSTANCE =============================================
    //========================================== PRISTUPOVE METODY INSTANCE ============================================
    @Override
    public int hashCode() {
        return address != null ? address.hashCode() : 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println("setEmail method");
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("setAddress method");
        this.address = address;
    }

    public void setIRoleService(IRoleService iRoleService) {
        System.out.println("Návštěvník: vnitřek set metody setIRoleService");
        this.iRoleService = iRoleService;
    }

    @Override
    public String getAuthorization() {
        return "Jsem návštěvník a můžu jen koukat, případně se někam hlásit";
    }

    @Override
    public String getRole() {
        return "nemůžu skoro nic a už vůbec nejsem " + iRoleService.getRole();
    }

    //================================================ METODY INSTANCE =================================================

    /******************************************************************************************************************/
    //================================================ SOUKROME METODY =================================================
    //================================================== MAIN METODA ===================================================

    /******************************************************************************************************************/
    //=============================================== TESTOVACI METODY =================================================
    //================================================ SOUKROME TRIDY ==================================================
}
