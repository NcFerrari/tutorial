package ukoly17az19lekce.stredniPriklad;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bedna bedna = new Bedna(10000);
        bedna.vypisZBedny();
        Nastroj kladivko = new Kladivo(1200, "Kladívko", false);
        Nastroj velkeKladivo = new Kladivo(3000, "Velké kladivo", true);
        Nastroj bouraciKladivo = new Kladivo(4000, "Bourací kladivo", true);
        Nastroj sroubovakPhilips = new Sroubovak(800, "Šroubovák Philips");
        Nastroj zrezavelaPila = new Pila(2500, "Zrezivělá pila");
        Nastroj elektrickySroubovakBosh = new ElektrickySroubovak(1800, "Elektrický šroubovák Bosh", 100);
        bedna.vlozitNastroj(kladivko);
        bedna.vlozitNastroj(velkeKladivo);
        bedna.vlozitNastroj(bouraciKladivo);
        bedna.vlozitNastroj(sroubovakPhilips);
        bedna.vlozitNastroj(zrezavelaPila);
        bedna.vlozitNastroj(elektrickySroubovakBosh);
        bedna.vypisZBedny();
        for (Nastroj nastroj : bedna.getNastroje()) {
            System.out.println(nastroj.pracuj());
        }
        System.out.printf("Váha obouručních kladiv je %d gramů\n", bedna.zjistiVahuObourcnichKladiv());
    }
}