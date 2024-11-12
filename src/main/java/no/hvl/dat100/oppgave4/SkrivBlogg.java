package no.hvl.dat100.oppgave4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import no.hvl.dat100.oppgave3.Blogg;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
try {
		File file = new File(mappe + filnavn);
		if (!file.exists()) {
			throw new FileNotFoundException(filnavn + "Ikkje funnet");
		}
		
		FileReader fr = new FileReader(file);
		
		BufferedReader bf = new BufferedReader(fr);
		
		String line;
		while((line = bf.readLine()) != null) {
			System.out.println(line);
		}
		bf.close();
		return true;
} catch (FileNotFoundException e) {
	System.out.println("Kan ikkje finne filen");
	e.printStackTrace();
	return false;
} catch (IOException e) {
	System.out.println("Det skjedde ein feil med lesing av fil");
	e.printStackTrace();
	return false;
}
	}
}
