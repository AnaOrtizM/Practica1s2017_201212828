/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColaFichas;

import MatrizTablero.Ficha;
import Utils.Graficador;
import java.util.Random;

/**
 *
 * @author ana_j
 */
public class CFichas {

    private NodoCF inicio;
    private NodoCF fin;
    public int tam;

    Graficador g = new Graficador();

    public CFichas() {
        inicio = fin = null;
    }

    public boolean estaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Push(String ficha, int puntos) {

        NodoCF actual;
        tam ++;

        if (estaVacia()) {
            actual = new NodoCF(new Ficha(ficha, puntos, 0, 0), null);
            inicio = actual;
            fin = actual;
        } else {
            actual = new NodoCF(new Ficha(ficha, puntos, 0, 0), null);
            fin.setSiguiente(actual);
            fin = actual;
        }
    }

    public Ficha Pop() {

        NodoCF actual;
        tam --;

        if(!estaVacia()){
            actual = inicio;
            inicio = inicio.getSiguiente();
            if(estaVacia()){
                fin = null;
            }
            return actual.getFicha();
        }
        return null;
        /*if (!estaVacia()) {
            actual = inicio;
            inicio = inicio.getSiguiente();
            Pop(actual.getFicha());
            if (estaVacia()) {
                fin = null;
            }
        }*/
    }
    
       /* public void Pop(String ficha) {
        NodoCF temp;
        NodoCF anterior;

        temp = inicio;
        anterior = null;

        while (temp != null) {
            if (ficha.equals(temp.getFicha())) {
                if (temp == inicio) {
                    inicio = inicio.getSiguiente();
                } else {
                    anterior.setSiguiente(temp);
                }
            }
            System.out.println(temp.getFicha());
            anterior = temp;
            temp = temp.getSiguiente();
        }
    }*/

    public void Mostrar() {

        NodoCF temp;

        if (estaVacia()) {
            System.out.println("Cola de Fichas Vacia");
        } else {
            temp = inicio;
            while (temp != null) {
                System.out.println(temp.getFicha());
                temp = temp.getSiguiente();
            }
        }
    }

    public void Graficar() {
        String grafo;
        NodoCF temp;
        grafo = "digraph g {  node [shape = circle,height=.1];  { \n";
        if (estaVacia()) {
            grafo += "\"ColaVacia\" [label = \"Cola Vacia\"]";
        } else {
            temp = inicio;
            int i = 0;
            while (temp != null) {
                grafo += "\"" + i + "\" [label = \"" + temp.getFicha().getLetra() + "\"];\n";
                if (i > 0) {
                    grafo += "\"" + (i - 1) + "\" -> \"" + i + "\" ;\n";
                }
                temp = temp.getSiguiente();
                i = i + 1;
            }
        }
        grafo += "}  labelloc=\"t\"; label=\" COLA FICHAS\";}";
        System.out.println(grafo);

        g.graficar("CFichas", grafo);
    }

    public void Fichas() {
        Letra ficha[] = new Letra[25];
        ficha[0] = new Letra("A", 12, 1);
        ficha[1] = new Letra("B", 2, 3);
        ficha[2] = new Letra("C", 4, 3);
        ficha[3] = new Letra("D", 5, 2);
        ficha[4] = new Letra("E", 12, 1);
        ficha[5] = new Letra("F", 1, 4);
        ficha[6] = new Letra("G", 2, 2);
        ficha[7] = new Letra("H", 2, 4);
        ficha[8] = new Letra("I", 6, 1);
        ficha[9] = new Letra("J", 1, 8);
        ficha[10] = new Letra("L", 4, 1);
        ficha[11] = new Letra("M", 2, 3);
        ficha[12] = new Letra("N", 5, 1);
        ficha[13] = new Letra("Ñ", 1, 8);
        ficha[14] = new Letra("O", 9, 1);
        ficha[15] = new Letra("P", 2, 3);
        ficha[16] = new Letra("Q", 1, 5);
        ficha[17] = new Letra("R", 5, 1);
        ficha[18] = new Letra("S", 6, 1);
        ficha[19] = new Letra("T", 4, 1);
        ficha[20] = new Letra("U", 5, 1);
        ficha[21] = new Letra("V", 1, 4);
        ficha[22] = new Letra("X", 1, 8);
        ficha[23] = new Letra("Y", 1, 4);
        ficha[24] = new Letra("Z", 1, 10);

        int limite = 95;
        Random rnd = new Random();

        while (limite > 0) {
            int numero = (int) (rnd.nextDouble() * 25);
            if (ficha[numero].cantidad > 0) {
                System.out.println(ficha[numero].letra + "--" + ficha[numero].cantidad);
                Push(ficha[numero].letra, ficha[numero].puntos);
                ficha[numero].cantidad--;
                limite--;
            }
        }
    }
}
