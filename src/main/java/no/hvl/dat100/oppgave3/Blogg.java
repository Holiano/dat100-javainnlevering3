package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg extends Innlegg {

	private Innlegg[] innleggtabell;
	private int nesteLedige;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];

	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteLedige;

	}

	public Innlegg[] getSamling() {
		return this.innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null && innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (Innlegg i : innleggtabell) {
			if (i != null && i.erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		for (Innlegg i : innleggtabell) {
			if (i == null) {
				return true;
			}
		}
		return false;
	}

	public boolean leggTil(Innlegg innlegg) {

		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[getAntall()] = innlegg;
			nesteLedige++;
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getAntall()).append("\n");
		for (Innlegg i : innleggtabell) {
			if (i != null) {
				sb.append(i.toString());
			}
		}
		return sb.toString();
	}

	public void utvid() {
		Innlegg[] tab = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < innleggtabell.length; i++) {
			tab[i] = innleggtabell[i];
		}
		innleggtabell = tab;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null && innleggtabell[i].getId() == innlegg.getId()) {
				return false;
			}
		}
		if (innleggtabell.length == nesteLedige) {
			utvid();
		}
		innleggtabell[nesteLedige] = innlegg;
		nesteLedige++;
		return true;

	}

	public boolean slett(Innlegg innlegg) {
		for (int i = 0; i < nesteLedige; i++) {
			if (innleggtabell[i].getId() == innlegg.getId()) {
				innleggtabell[i] = innleggtabell[nesteLedige - 1];
				innleggtabell[nesteLedige - 1] = null;
				nesteLedige--;
				return true;
			}
		}
		return false;
	}

	public int[] search(String keyword) {
		int[] tab = new int[innleggtabell.length];
		int x = 0;
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i].toString().contains(keyword)) {
				tab[x] = innleggtabell[i].getId();
				x++;
			}
		}
		return tab;
	}
}