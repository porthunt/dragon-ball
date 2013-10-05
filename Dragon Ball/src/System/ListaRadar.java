package System;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListaRadar {
	
	private List<Estrutura> lista;	
	
	public ListaRadar()
	{
		lista = new LinkedList<Estrutura>();
	}
	
	public Estrutura RetornaMenor()
	{
		Mapa mp= null;
		mp=mp.getInstance1();
		
		Estrutura retorno= lista.get(0);
		Estrutura temp=null;
		Iterator itr = lista.iterator();
		
		
		while(itr.hasNext()){
			temp = (Estrutura) itr.next();
			if(!mp.getCasas(temp.pt.getCoordX(),temp.pt.getCoordY()).isVisitado())
			{
				if (retorno.custo > temp.custo){
					retorno = temp;
					
				}
			}
			
		}
		
		return lista.remove(lista.indexOf(retorno));
	}
	
	public void AdicionaLista(List<Estrutura> adc)
	{
		Iterator itr = adc.iterator();
		while(itr.hasNext()){
			lista.add((Estrutura) itr.next());
		}
	}
	public void AddEstrutura(Estrutura add)
	{
		lista.add(add);
	}
	public void ClearLista()
	{
		this.lista.clear();
				
	}
}
