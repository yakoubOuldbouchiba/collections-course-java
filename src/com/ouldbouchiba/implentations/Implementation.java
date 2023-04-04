package com.ouldbouchiba.implentations;

import com.ouldbouchiba.interfaces.Contrat;

public class Implementation implements Contrat {
    @Override
    public void term1() {
        System.out.println("Implementation:term1");
    }

    @Override
    public void term2() {
        System.out.println("Implementation:term2");
    }

    @Override
    public void extendedTerm() {
        System.out.println("Implementation:extendedTerm");
    }
}
