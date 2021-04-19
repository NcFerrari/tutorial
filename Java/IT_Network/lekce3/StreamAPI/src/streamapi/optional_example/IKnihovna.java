/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamapi.optional_example;

import java.util.Optional;

/**
 *
 * @author NcFerrari
 */
public interface IKnihovna {
    
    void pridej(Kniha kniha);
    void odstran(Kniha kniha);
    Kniha najdiKnihu(String nazev);
    Optional<Kniha> najdiKnihuBezpecne(String nazev);
}
