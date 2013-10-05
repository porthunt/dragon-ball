package System;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Radar {

	private Casa radar[][] = new Casa[7][7];
	private List<Ponto> Esferas, PontoChave, Caminho;
	private ListaRadar Source;
	private Estrutura Proximo, Anterior;
	private FileWriter writer;
	private boolean mode = false;
	public boolean retorno= false;
	Goku goku = null;
	Mapa mapa = null;

	public Radar() {

		Esferas = new LinkedList<Ponto>();
		PontoChave = new LinkedList<Ponto>();
		Caminho = new LinkedList<Ponto>();
		Source = new ListaRadar();

		try {
			if (mode) {
				writer = new FileWriter(new File("Teste.txt"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Ponto> GetEsferas() {
		return Esferas;
	}
	
	public List<Ponto> GetPontoChave()
	{
		return PontoChave;
	}

	public List<Ponto> GetCaminho() {
		return Caminho;
	}

	public void PreencherRadar() {
		Esferas.clear();
		PontoChave.clear();
		int i = 0;
		int j = 0;
		int tempx;
		int tempy;
		Mapa map = null;
		map = map.getInstance1();
		Goku gk = null;
		gk = gk.getInstance();
		
		if (gk.getAtual().getCoordX() < 3)
		{
			tempx = 0;
			tempy = gk.getAtual().getCoordY()-3;
		}
		else if(gk.getAtual().getCoordY() <3)
		{
			tempx=gk.getAtual().getCoordX()-3;
			tempy=0;
		}
		else
		{
			tempx = gk.getAtual().getCoordX() - 3;
			tempy = gk.getAtual().getCoordY() - 3;
		}
		
		try {
			if (mode) {
				writer.write("Disposição das casas do Radar por tipo \n\n");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (i < 7) {
			while (j < 7) {
				if (((tempx + j >= 0 && tempx + j <= 41) && (tempy + i >= 0 && tempy + i <= 41)))
				{
					map.getCasas(tempx + j, tempy + i).Reseta();
					char c = map.getCasas(tempx + j, tempy + i).getTipo();
					try {
						if (mode) {
							writer.write(c + "\t");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					radar[i][j] = map.getCasas(tempx + j, tempy + i);
				}
				else
				{
					radar[i][j] = new Casa(-1,-1,-1,'X');
				}
				j++;
			}
			try {
				if (mode) {
					writer.write("\n\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j = 0;
			i++;

		}

	}

	public void ReconhecerCenario() {

		int i = 0;
		int j = 0;
		int tempx;
		int tempy;
		Mapa mp = null;
		mp = mp.getInstance1();
		Goku gk = null;
		gk = gk.getInstance();

		tempx = gk.getAtual().getCoordX() - 3;
		tempy = gk.getAtual().getCoordY() - 3;

		try {
			if (mode) {
				writer.write("Disposição das casas do Radar por coordenada \n\n");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (i < 7) {
			while (j < 7) {
				try {
					if (mode) {
						writer.write("(" + String.valueOf(tempx + j) + ","
								+ String.valueOf(tempy + i) + ")\t");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (radar[i][j].isEsfera()) {
					Esferas.add(new Ponto(tempx + j, tempy + i));

				} else {
					if (radar[i][j].isPontoChave() && gk.getAtual().getCoordX()!=tempx+j && gk.getAtual().getCoordY()!=tempy+i) {
						PontoChave.add(new Ponto(tempx + j, tempy + i));

					}

				}
				j++;
			}
			try {
				if (mode) {
					writer.write("\n\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j = 0;
			i++;
		}

	}
	
	public Ponto AcharPontoChave()
	{
		int i=0,j=0,tempx,tempy,k=0;
		Ponto p=null;
		while(p==null)
		{
			tempx=goku.getAtual().getCoordX()+(-3-k);
			tempy=goku.getAtual().getCoordY()+(-3-k);			
			
		while(i<7+k)
		{
			while(j<7+k)
			{
				if(tempy+i>=0 && tempy+i<=41 && tempx+j>=0 && tempx+j<=41)
				{
					if(mapa.getCasas(tempx+j,tempy+i).isPontoChave())
					{
						p=mapa.getCasas(tempx+j,tempy+i).getP();
					}
					
				}
				j++;
			}
			j=0;
			i++;
		}
		k++;
		}
		return p;
		
	}

	public void MenorCaminho() {
		
		Caminho.clear();
		Source.ClearLista();
		ResetaRadar();
		Ponto p;
		if(retorno)
		{
		  p=new Ponto(19,19);
		}
		else
		{
		p = Identificar_Cenario();
		}
		try {
			if (mode) {
				writer.append(String.valueOf(p.getCoordX())+","+String.valueOf(p.getCoordY())+"\n");
				writer.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Goku gk = null;
		gk = gk.getInstance();
		Mapa map = null;
		map = map.getInstance1();

		Anterior = new Estrutura(gk.getAtual().getCoordX(), gk.getAtual()
				.getCoordY(), gk.getCustoCaminho());
		map.getCasas(gk.getAtual().getCoordX(), gk.getAtual().getCoordY())
				.Visita();

		try {
			if (mode) {
				writer.write("\n\nInicio da busca:");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (p.getCoordX() == -1) {
			Heuristica(Esferas, gk.getAtual());

		} else 
		{
			Heuristica(Caminho, p, gk.getAtual());
			

		}

		if (map.getCasas(Caminho.get(0).getCoordX(), Caminho.get(0).getCoordY())
				.isPontoChave()) {
			map.getCasas(Caminho.get(0).getCoordX(), Caminho.get(0).getCoordY())
					.VisitaPontoChave();

		}

	}

	public Ponto Identificar_Cenario() {
		goku=goku.getInstance();
		mapa=mapa.getInstance1();
		try {
			if (mode) {
				writer.write("Quantidade de Esferas: "
						+ String.valueOf(Esferas.size()) + "\n\n");
				writer.write("Quantidade de Pontos de Interesses: "
						+ String.valueOf(PontoChave.size()) + "\n\n");
				writer.write("Cenario:");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (Esferas.isEmpty() && PontoChave.size() == 1) {
			try {
				if (mode) {
					writer.write(" Um ponto de interesse");
					writer.write("\n" + "("
							+ String.valueOf(PontoChave.get(0).getCoordX())
							+ ","
							+ String.valueOf(PontoChave.get(0).getCoordY())
							+ ")");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return PontoChave.get(0);
		}

		else {
			if (Esferas.size() == 1) {
				try {
					if (mode) {
						writer.write(" Uma esfera");
						writer.write("\n" + "("
								+ String.valueOf(Esferas.get(0).getCoordX())
								+ ","
								+ String.valueOf(Esferas.get(0).getCoordY())
								+ ")");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Esferas.get(0);

			} else if (Esferas.size() > 1) {
				try {
					if (mode) {
						writer.write("Mais de uma esfera");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return (new Ponto(-1, -1));
			}
			try {
				if (mode) {
					writer.write("Nenhuma esfera e nenhum ponto de interesse");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(mapa.getCasas(goku.getAtual().getCoordX(),goku.getAtual().getCoordY()).isPontoChave())
			{
						return PontoChaveMaisProximo();
			}
			else
			{
				return AcharPontoChave();
			}
			

		}

	}

	public void Close() {
		try {
			if (!mode) {
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int Heuristica(List<Ponto> Caminho, Ponto p, Ponto pos) {

		Estrutura temp;
		int custo = 0;
		Mapa map = null;
		map = map.getInstance1();

		try {
			if (mode) {
				writer.write("\n\nAnterior:\nCoordenadas:("
						+ String.valueOf(Anterior.pt.getCoordX()) + ","
						+ String.valueOf(Anterior.pt.getCoordY())
						+ ")\nCusto Atual do caminho:"
						+ String.valueOf(Anterior.custo) + "");
				writer.write("\n\nAtual:\nCoordenadas:("
						+ String.valueOf(pos.getCoordX()) + ","
						+ String.valueOf(pos.getCoordY()) + ")");
				writer.write("\n\nObjetivo:\nCoordenadas:("
						+ String.valueOf(p.getCoordX()) + ","
						+ String.valueOf(p.getCoordY()) + ")");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (pos.getCoordX() == p.getCoordX()
				&& pos.getCoordY() == p.getCoordY()) {
			Caminho.add(p);
			Proximo = Anterior;
			custo = Proximo.custo;
			

			try {
				if (mode) {
					writer.write("CUSTO FINAL PORRA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					writer.write("\n\nProximo:\nCoordenadas:("
							+ String.valueOf(Proximo.pt.getCoordX()) + ","
							+ String.valueOf(Proximo.pt.getCoordY())
							+ ")\nCusto Atual do caminho:"
							+ String.valueOf(Proximo.custo) + "");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			CalcularValores(p, pos);
			temp = Source.RetornaMenor();
			Anterior = temp;
			pos = temp.pt;
			map.getCasas(pos.getCoordX(), pos.getCoordY()).Visita();
			custo = Heuristica(Caminho, p, pos);

			if (ValidaPos(temp)) {
				Caminho.add(pos);
				Proximo = temp;
				try {
					if (mode) {
						writer.write("\n\nProximo:\nCoordenadas:("
								+ String.valueOf(Proximo.pt.getCoordX()) + ","
								+ String.valueOf(Proximo.pt.getCoordY())
								+ ")\nCusto Atual do caminho:"
								+ String.valueOf(Proximo.custo) + "");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		return custo;
	}

	public void Heuristica(List<Ponto> ListP, Ponto pos) {

		int Tam = 9001;
		int TempTam = 0;
		Goku gk = null;
		gk = gk.getInstance();
		Mapa map = null;
		map = map.getInstance1();

		List<Ponto> CaminhoTemp = new LinkedList<Ponto>();

		for (Ponto p : ListP) {
			Source.ClearLista();
			CaminhoTemp.clear();
			ResetaRadar();
			map.getCasas(gk.getAtual().getCoordX(), gk.getAtual().getCoordY())
					.Visita();
			TempTam = Heuristica(CaminhoTemp, p, pos);
			if (TempTam < Tam) {
				this.Caminho.clear();
				this.Caminho.addAll(CaminhoTemp);
				Tam = TempTam;

			}
			Anterior.custo = gk.getCustoCaminho();
			Anterior.pt = gk.getAtual();

		}

	}

	public boolean ValidaPos(Estrutura pos) {
		int temp = 0;
		int ProxCordx, ProxCordy, PosCordx, PosCordy;
		if (pos.custo >= Proximo.custo) {
			return false;
		}
		if (Proximo.Anterior.equals(pos)) {
			return true;
		} else {
			return false;
		}

	}

	public int CalculaValor(Ponto Objetivo, Ponto p) {
		Mapa map = null;
		map = map.getInstance1();
		int custoTerreno = map.getCasas(p.getCoordX(), p.getCoordY())
				.getCusto();
		// Custo Anterior+Manhatam+Custo do terreno

		int custo = Anterior.custo + Manhatam(Objetivo, p) + custoTerreno;

		return custo;
	}

	public int Manhatam(Ponto Objetivo, Ponto p) {
		int distancia = (Math.abs(p.getCoordX() - Objetivo.getCoordX()))
				+ (Math.abs(p.getCoordY() - Objetivo.getCoordY()));
		return distancia;
	}

	public Ponto PontoChaveMaisProximo() 
	{
		goku = goku.getInstance();
		mapa = mapa.getInstance1();
		int i=1;
		int tempX = goku.getAtual().getCoordX();
		int tempY = goku.getAtual().getCoordY();
		Casa cpleste=null;
		Casa cpsul=null;
		Casa cpnorte=null;
		Casa cpoeste=null;
		boolean controle=true;
		Ponto ret=null;
		
		while (controle) {
			
			controle=false;
			
			if (tempY-(7*i) > 0) {
				cpnorte = mapa.getCasas(tempX, tempY-(7*i)); //norte
				controle=true;
			}
			else
			{
				cpnorte = mapa.getCasas(tempX, tempY); //norte
				
			}
			if (tempX-(7*i) > 0) {
				cpoeste = mapa.getCasas(tempX-(7*i), tempY); //oeste
				controle=true;
			}
			else
			{
				cpoeste = mapa.getCasas(tempX, tempY); //oeste
			}
			if (tempY+(7*i) < 41) {
				cpsul = mapa.getCasas(tempX, tempY+(7*i)); //sul
				controle=true;
			}
			else
			{
				cpsul = mapa.getCasas(tempX, tempY); //oeste
			}
			if (tempX+(7*i) < 41) {
				cpleste = mapa.getCasas(tempX+(7*i), tempY); //leste
				controle=true;
			}
			else
			{
				cpleste = mapa.getCasas(tempX, tempY); //leste
			}

			if (cpnorte.isPontoChaveVisitado()) {
				if (cpoeste.isPontoChaveVisitado()) {
					if (cpsul.isPontoChaveVisitado()) {
						if (cpleste.isPontoChaveVisitado()) {
							i++;							
						}
						else {
							ret = cpleste.getP();
							break;
						}
					}
					else {
						ret = cpsul.getP();
						break;
					}
				}
				else {
					ret = cpoeste.getP();
					break;
				}
			}
			else {
				ret = cpnorte.getP();
				break;
			}
		}
		
		
		return ret;

		
	}

	public void CalcularValores(Ponto Objetivo, Ponto pos) {

		Ponto Norte = new Ponto(pos.getCoordX(), pos.getCoordY() - 1);
		Ponto Sul = new Ponto(pos.getCoordX(), pos.getCoordY() + 1);
		Ponto Leste = new Ponto(pos.getCoordX() + 1, pos.getCoordY());
		Ponto Oeste = new Ponto(pos.getCoordX() - 1, pos.getCoordY());

		Goku gk = null;
		gk = gk.getInstance();
		Mapa map = null;
		map = map.getInstance1();
		
		try {
			if (mode) 
			{
				writer.write("\n\n1²abertura da busca:");
			}

			if ((Norte.getCoordX() >= 0 && Norte.getCoordX() <= 41) && (Norte.getCoordY() >= 0 && Norte.getCoordY() <= 41)) 
			{
				if (!map.getCasas(Norte.getCoordX(), Norte.getCoordY()).isVisitado()) 
				{
					Estrutura CandidatoN = new Estrutura(Norte.getCoordX(),
							Norte.getCoordY(), CalculaValor(Objetivo, Norte));
					CandidatoN.Anterior = Anterior;
					Source.AddEstrutura(CandidatoN);
					if (mode) {
						writer.write("\n\nNorte:\nCoordenadas:("
								+ String.valueOf(CandidatoN.pt.getCoordX())
								+ ","
								+ String.valueOf(CandidatoN.pt.getCoordY())
								+ ")" + "\nCusto do Candidato:"
								+ String.valueOf(CandidatoN.custo) + "");
					}
				}

			}
			if ((Oeste.getCoordX() >= 0 && Oeste.getCoordX() <= 41) && (Oeste.getCoordY() >= 0 && Oeste.getCoordY() <= 41))
			{
				if (!map.getCasas(Oeste.getCoordX(), Oeste.getCoordY()).isVisitado()) {
					Estrutura CandidatoO = new Estrutura(Oeste.getCoordX(),
							Oeste.getCoordY(), CalculaValor(Objetivo, Oeste));
					CandidatoO.Anterior = Anterior;
					Source.AddEstrutura(CandidatoO);
					if (mode) {
						writer.write("\n\nOeste:\nCoordenadas:("
								+ String.valueOf(CandidatoO.pt.getCoordX())
								+ ","
								+ String.valueOf(CandidatoO.pt.getCoordY())
								+ ")" + "\nCusto do Candidato:"
								+ String.valueOf(CandidatoO.custo) + "");
					}
				}

			}
			if (((Sul.getCoordX() >= 0 && Sul.getCoordX() <= 41) && (Sul
					.getCoordY() >= 0 && Sul.getCoordY() <= 41))) {
				if (!map.getCasas(Sul.getCoordX(), Sul.getCoordY())
						.isVisitado()) {
					Estrutura CandidatoS = new Estrutura(Sul.getCoordX(),
							Sul.getCoordY(), CalculaValor(Objetivo, Sul));
					CandidatoS.Anterior = Anterior;
					Source.AddEstrutura(CandidatoS);
					if (mode) {
						writer.write("\n\nSul:\nCoordenadas:("
								+ String.valueOf(CandidatoS.pt.getCoordX())
								+ ","
								+ String.valueOf(CandidatoS.pt.getCoordY())
								+ ")" + "\nCusto do Candidato:"
								+ String.valueOf(CandidatoS.custo) + "");
					}
				}

			}
			if (((Leste.getCoordX() >= 0 && Leste.getCoordX() <= 41) && (Leste
					.getCoordY() >= 0 && Leste.getCoordY() <= 41))) {
				if (!map.getCasas(Leste.getCoordX(), Leste.getCoordY())
						.isVisitado()) {
					Estrutura CandidatoL = new Estrutura(Leste.getCoordX(),
							Leste.getCoordY(), CalculaValor(Objetivo, Leste));
					CandidatoL.Anterior = Anterior;
					Source.AddEstrutura(CandidatoL);
					if (mode) {
						writer.write("\n\nLeste:\nCoordenadas:("
								+ String.valueOf(CandidatoL.pt.getCoordX())
								+ ","
								+ String.valueOf(CandidatoL.pt.getCoordY())
								+ ")" + "\nCusto do Candidato:"
								+ String.valueOf(CandidatoL.custo) + "");
					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ResetaRadar() {
		int i = 0;
		int j = 0;
		Mapa map = null;
		map = map.getInstance1();

		while (i < 42) {
			while (j < 42) 
			{
				
					map.getCasas(j,i).Reseta();
					j++;
					
				
				

			}
			j = 0;
			i++;
		}
		

	}

}
