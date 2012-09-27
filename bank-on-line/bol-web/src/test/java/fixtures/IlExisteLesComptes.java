package fixtures;

import java.util.LinkedList;
import java.util.List;

import com.valtech.bankonline.service.Compte;
import com.valtech.testutils.CompteServiceFactory;

public class IlExisteLesComptes {
	public static final List<Compte> comptes = new LinkedList<Compte>();

	private String referenceClient;
	private String numeroCompte;
	private String type;
	private float solde;

	public void setReferenceClient(String referenceClient) {
		this.referenceClient = referenceClient;
	}

	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public IlExisteLesComptes() {
		CompteServiceFactory.nouvelleBase();
	}

	public void execute() throws Exception {
		CompteServiceFactory.service().creerCompte(
				new Compte(referenceClient, numeroCompte, type, solde));
	}
}
