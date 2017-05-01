/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Observable;

/**
 *
 * @author fladdomi
 */
public class TicTacToe extends Observable{

    /**
     * @param args the command line arguments
     */
    private Spieler spieler;
    private Spieler spieler2;
    private Spieler aktuellerSpieler;
    private int[][] spielfeld;
  
    TicTacToe(){
        
        spieler = new Spieler("Spieler 1",1);
        spieler.setZeichen("x");
        
        spieler2 = new Spieler("Spieler 2",10);
        spieler2.setZeichen("o");
        
        aktuellerSpieler = spieler;
        
        iniSpielfeld();
    }
    
    public void spielerwechsel(){
        if (aktuellerSpieler==spieler){
            aktuellerSpieler=spieler2;
        }else { aktuellerSpieler=spieler;}
    }
    
    public Spieler getAktuellerSpieler(){
        return aktuellerSpieler;
    }
    
    public void iniSpielfeld(){
        spielfeld=new int[3][3];
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                spielfeld[i][j]=0;
                
        } 
    }
    
    public void turn(int i, int j){
        spielfeld[i][j]=aktuellerSpieler.getIndex();
         this.setChanged(); 
        this.notifyObservers(); 
                
        if(istSpielZuEnde()){
               iniSpielfeld();
         }else{ spielerwechsel();}
        outputSpielfeld();
       
                
    } 
    
    private void outputSpielfeld(){
         for(int i=0;i<3;i++){
            for(int j=0;j<3;j++)
                System.out.println(spielfeld[i][j]);
                
        }
    }
    
    public boolean istSpielZuEnde(){
        /*
        00|01|02
        --------
        10|11|12
        --------
        20|21|22
         */ 
         
        return chkLine(0,0,0,1,0,2)
                ||chkLine(1,0,1,1,1,2)
                ||chkLine(2,0,2,1,2,2)
                
                ||chkLine(0,0,1,0,2,0)
                ||chkLine(0,1,1,1,2,1)
                ||chkLine(0,2,1,2,2,2)
                
                ||chkLine(0,0,1,1,2,2)
                ||chkLine(2,0,1,1,0,2);
    }
    
    private int askValue(int i,int j){
         return spielfeld[i][j];
    }
    
    private boolean chkLine(int i, int j, int k, int l, int m, int n){
            return askValue(i,j)+askValue(k,l)+askValue(m,n)==3
                    ||askValue(i,j)+askValue(k,l)+askValue(m,n)==30;
    }
}
