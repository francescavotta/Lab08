package it.polito.tdp.extflightdelays.model;

import org.jgrapht.Graph;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		Graph grafo = model.creaGrafo(4000);
		System.out.println(grafo.edgeSet());

	}

}
