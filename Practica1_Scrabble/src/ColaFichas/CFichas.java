/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColaFichas;

import Utils.Graficador;

/**
 *
 * @author ana_j
 */
public class CFichas {

    private NodoCF inicio;
    private NodoCF fin;

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

    public void Push(String ficha) {

        NodoCF actual;

        if (estaVacia()) {
            actual = new NodoCF(ficha, null);
            inicio = actual;
            fin = actual;
        } else {
            actual = new NodoCF(ficha, null);
            fin.setSiguiente(actual);
            fin = actual;
        }
    }

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
                grafo += "\"" + i + "\" [label = \"" + temp.getFicha() + "\"];\n";
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
}