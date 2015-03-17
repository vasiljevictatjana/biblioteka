package biblioteka;

import java.util.LinkedList;

import javax.management.RuntimeErrorException;

import biblioteka.interfejs.BibliotekaInterfejs;

public class Biblioteka implements BibliotekaInterfejs {
	
	private LinkedList<Knjiga> knjige= new LinkedList<Knjiga>();
	
	

	public void dodajKnjigu(Knjiga knjiga) {
		
		if(knjiga==null)
			throw new RuntimeException("Knjiga ne sme biti null.");
		
		if(knjige.contains(knjiga))
			throw new RuntimeException("Knjiga je u biblioteci.");
		
		knjige.add(knjiga);

	}

	public void obrisiKnjigu(Knjiga knjiga) {
		
		if(!knjige.contains(knjiga))
			throw new RuntimeException("Knjiga ne postoji u biblioteci.");
		
		knjige.remove(knjiga);

	}

	public LinkedList<Knjiga> pronadjiKnjigu(String naslov, long ISBN,
			String izdavac, Autor autor) {
		
		if(naslov==null && ISBN<=0 && izdavac==null && autor==null)
			throw new RuntimeException("Morate uneti neki kriterijum.");
		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		if(naslov==null && ISBN<=0 && izdavac==null && autor==null)
			return knjige;
		
		if(ISBN >0)
			for (int i = 0; i < knjige.size(); i++) {
				if(knjige.get(i).getISBN() == ISBN)
					rezultat.add(knjige.get(i));
				
			}
		
		return rezultat;
	}

}
