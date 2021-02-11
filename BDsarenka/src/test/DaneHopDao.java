package test;

import javax.swing.JOptionPane;

import entity.Hop;

public class DaneHopDao {

	public String Txt[] = {"TestHop","99.9","PL"};
	public String TxtUp[] = {"TestHopUp","11.1","LPG"};
	
	
	public Hop hop;
	
	public DaneHopDao() {
		hop = new Hop(-1, Txt[0], Txt[1], Txt[2]);
	}

	public static void main(String[] args) {
		DaneHopDao u = new DaneHopDao();
		String[] d = u.userHop();
		for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);			
		}
	}
	
	public String[] userHop() {
		String[] Txt = new String [3];
		Txt[0] = JOptionPane.showInputDialog(null, "Podaj nazw� chmielu", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 
		while (Txt[0].length() > 45 || Txt[0].length() == 0) {
			if (Txt[0].length() == 0)
				Txt[0] = JOptionPane.showInputDialog(null, "B��d, nazwa zbyt kr�tka", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 
			else
				Txt[0] = JOptionPane.showInputDialog(null, "B��d, nazwa zbyt d�uga", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 
		}
		
		Txt[1] = JOptionPane.showInputDialog(null, "Podaj zawarto�� alfa kwas�w 'xx.y'", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 
		while (errorInput(Txt[1])) {
			try {
				float x = Float.parseFloat(Txt[1]);
				if (x < 0) {
					Txt[1] = JOptionPane.showInputDialog(null, "B��d, zawarto�� alfa kwas�w nie mo�e by� mniejsza ni� 0.0", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 
				} else if (x > 99.9) {
					Txt[1] = JOptionPane.showInputDialog(null, "B��d, zawarto�� alfa kwas�w nie mo�e by� wi�ksza ni� 99.9", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 
				}
			} catch (Exception e) {
				Txt[1] = JOptionPane.showInputDialog(null, "B��d, b��dny format, podaj x.y %", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 	
			}
		}
		float roundPercent = (float) (Math.round(Float.parseFloat(Txt[1]) * 10.0) / 10.0);
		Txt[1] = Float.toString(roundPercent);
		
		Txt[2] = JOptionPane.showInputDialog(null, "Podaj kraj pochodzenia chmielu", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 
		while (Txt[2].length() > 45 || Txt[2].length() == 0) {
			if (Txt[2].length() == 0)
				Txt[2] = JOptionPane.showInputDialog(null, "B��d, oznaczenie kraju zbyt kr�tka", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 
			else
				Txt[2] = JOptionPane.showInputDialog(null, "B��d, oznaczenie kraju zbyt d�uga", "Dodaj chmiel", JOptionPane.QUESTION_MESSAGE); 
		}	
		
		return Txt;
	}

	private boolean errorInput(String Txt) {
		
		float x = 0;
		try {
			x = Float.parseFloat(Txt);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return true;
		}
		finally {
			if( x*10 > 999 || x < 0)
				return true;
		}
		return false;
	}
	
}
