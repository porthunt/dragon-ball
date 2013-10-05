package Graphics;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import System.Casa;
import System.Goku;
import System.Mapa;
import System.Tratador;

public class InfoFrame extends JFrame {

	public final int LARG_DEFAULT = 233;
	Tratador tt = new Tratador();
	Goku gk = null;
	Color blackColor = new Color(62, 56, 56);
	int Custo;
	JButton conta;
	EsferaLabel el7;
	EsferaLabel el6;
	EsferaLabel el5;
	EsferaLabel el4;
	EsferaLabel el3;
	EsferaLabel el2;
	EsferaLabel el1;

	public InfoFrame() {
		setBounds(95, 10, LARG_DEFAULT, 270);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);

		gk = gk.getInstance();
		conta = new JButton(Integer.toString(Custo));
		conta.setEnabled(false);
		conta.setFont(new Font("Arial", Font.BOLD, 16));
		conta.setForeground(blackColor);
		conta.setBounds(85, 11, 130, 30);
		conta.setVisible(true);
		this.add(conta);

		JLabel custo = new JLabel("Custo:");
		custo.setFont(new Font("Arial", Font.BOLD, 21));
		custo.setForeground(blackColor);
		custo.setBounds(10, 10, 90, 30);
		custo.setVisible(true);
		this.add(custo);

		JLabel esferas = new JLabel("Esferas:");
		esferas.setFont(new Font("Arial", Font.BOLD, 21));
		esferas.setForeground(blackColor);
		esferas.setBounds(10, 100, 90, 30);
		esferas.setVisible(true);
		this.add(esferas);

		el7 = new EsferaLabel("esfera7.png");
		el7.setBounds(175, 190, 40, 40);
		el7.setVisible(false);
		this.add(el7);

		el6 = new EsferaLabel("esfera6.png");
		el6.setBounds(125, 190, 40, 40);
		el6.setVisible(false);
		this.add(el6);

		el5 = new EsferaLabel("esfera5.png");
		el5.setBounds(75, 190, 40, 40);
		el5.setVisible(false);
		this.add(el5);

		el4 = new EsferaLabel("esfera4.png");
		el4.setBounds(25, 190, 40, 40);
		el4.setVisible(false);
		this.add(el4);

		el3 = new EsferaLabel("esfera3.png");
		el3.setBounds(150, 145, 40, 40);
		el3.setVisible(false);
		this.add(el3);

		el2 = new EsferaLabel("esfera2.png");
		el2.setBounds(100, 145, 40, 40);
		el2.setVisible(false);
		this.add(el2);

		el1 = new EsferaLabel("esfera1.png");
		el1.setBounds(50, 145, 40, 40);
		el1.setVisible(false);
		this.add(el1);

		RadarButton rb = new RadarButton();
		rb.setName("Radar");
		rb.setBorderPainted(false);
		rb.addMouseListener(tt);
		rb.setBounds(100, 55, 28, 34);
		rb.setVisible(true);
		this.add(rb);

		this.setVisible(true);
	}

	public int getCusto() {
		return Custo;
	}

	public void setCusto(int custo) {
		Custo += custo;
		conta.setText(Integer.toString(Custo));

	}

	public void setaEsfera(int esf) {
		switch (esf) {
		case 1:
			el1.setVisible(true);
			break;
		case 2:
			el2.setVisible(true);
			break;
		case 3:
			el3.setVisible(true);
			break;
		case 4:
			el4.setVisible(true);
			break;
		case 5:
			el5.setVisible(true);
			break;
		case 6:
			el6.setVisible(true);
			break;
		case 7:
			el7.setVisible(true);
			break;
		}
	}
}
