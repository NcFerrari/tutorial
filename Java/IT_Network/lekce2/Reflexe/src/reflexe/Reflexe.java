/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflexe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 *
 * @author NcFerrari
 */
public class Reflexe {

    private String text;
    private LocalDateTime datum;

    public Reflexe(String text, LocalDateTime datum) {
        this.text = text;
        this.datum = datum;
    }

    public static void main(String[] args) {
        Reflexe r = new Reflexe("test", LocalDateTime.MAX);
    }

}
