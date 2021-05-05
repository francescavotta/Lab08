package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	
	private Map <Integer, Airport> idMap;
	
	public Model() {
		this.dao = new ExtFlightDelaysDAO();
		this.idMap = new HashMap<Integer, Airport>();
	}
	
	public void riempiMappa() {
		List<Airport> air = dao.loadAllAirports();
		for(Airport a : air) {
			idMap.put(a.getId(), a);
		}
	}
	
	public Graph<Airport, DefaultWeightedEdge> creaGrafo(int distanza) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.riempiMappa();
		Graphs.addAllVertices(grafo, idMap.values());
		//List<Adiacenze> list = dao.getAllArchi(distanza);
		for(Adiacenze a: dao.getAllArchi(distanza)) {
			Airport a1 = idMap.get(a.getId1());
			Airport a2 = idMap.get(a.getId2());
			if(a1==null || a2==null)
				return null;
			
			DefaultWeightedEdge e = grafo.getEdge(a1, a2);
			if(e == null)
			{
				Graphs.addEdgeWithVertices(grafo, a1, a2);
				e =grafo.getEdge(a1, a2);
				grafo.setEdgeWeight(e, a.getDistance());
			}else {
				double pesoVecchio = grafo.getEdgeWeight(e);
				double pesoNuovo = (pesoVecchio + a.getDistance())/2;
				this.grafo.setEdgeWeight(e, pesoNuovo);
			}
			//Graphs.addEdge(grafo, idMap.get(a.getId1()), idMap.get(a.getId2()), a.getDistance() );
		}
		System.out.println("Grafo creato");
		System.out.println("#Vertici: " + grafo.vertexSet().size());
		System.out.print("#Archi: " + grafo.edgeSet().size());
		return grafo;
	}
	
	public String stampa(Graph grafo) {
		String stampa = "";
		
		return stampa;
	}

}
