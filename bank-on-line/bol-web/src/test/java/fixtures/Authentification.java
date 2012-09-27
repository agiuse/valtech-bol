package fixtures;

import com.valtech.bankonline.service.Client;

import fit.ActionFixture;

public class Authentification extends ActionFixture {
	private Client client;
	private String motDePasse;

	public void identifiant(String referenceClient) {
		for (Client client : TablesPipe.clients) {
			if (client.getReference().equals(referenceClient)) {
				this.client = client;
			}
		}
	}

	public void motDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void authentification() {
		client.connecter(motDePasse);
	}

	public boolean connection() {
		return client.estConnecte();
	}
}
