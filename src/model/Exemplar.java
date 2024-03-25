/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

/**
 *
 * @author Edson
 */
public class Exemplar implements Serializable{

    public Exemplar() {
    }

    public Exemplar(String livroISBN, String cod) {
        this.livroISBN = livroISBN;
        this.cod = cod;
    }
    
    private String livroISBN;
    private String cod;

        /**
     * @return the cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return the livroISBN
     */
    public String getLivroISBN() {
        return livroISBN;
    }

    /**
     * @param livroISBN the livroISBN to set
     */
    public void setLivroISBN(String livroISBN) {
        this.livroISBN = livroISBN;
    }
}
