/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author fladdomi
 */
public class Spieler {

    private String name;
    private String zeichen;
    private int index;
    
    Spieler(String value, int i){//
        name=value;
        zeichen="";// leeres Zeichen damit kein Nullfehler entsteht
        index=i;
    }
    
    public String getZeichen(){
        return zeichen;
    }
    
    public void setZeichen(String value){
        zeichen=value;
    }
    
    public int getIndex(){
        return index;
    }
    
    public void setIndex(int value){
        index=value;
    }
    
    public String getName(){return name;}
    
}
