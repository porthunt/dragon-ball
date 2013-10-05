package System;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Graphics.RadarPainel;

public class Tratador implements MouseListener {

	public void mouseClicked(MouseEvent arg0) {

		Tratador tt = new Tratador();
		RadarPainel rp = null;
		rp = rp.getInstance();
		Goku goku = null;
		goku = goku.getInstance();
		
		if (arg0.getComponent().getName().equals("Radar")) {
			if (rp.isAtivado()) {
				rp.setVisible(false);
				rp.setAtivado(false);
			}
			else {
				rp.setVisible(true);
				rp.setAtivado(true);
			}
		}
}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

