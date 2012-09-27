package fixtures;

import com.valtech.bankonline.service.Compte;

public class ControlerVirement {
	private float soldeCompteEmetteur;
	private float montantVirement;

	public boolean autorisation() throws Exception {
		boolean autorise = false;
		try {
			autorise = new Compte("", "", "", soldeCompteEmetteur)
					.estDebitAutorise(montantVirement);
		} catch (Exception e) {
			throw new Exception("message:<<" + e.getMessage() + ">>");
		}
		return autorise;
	}

	public void setSoldeCompteEmetteur(float soldeCompteEmetteur) {
		this.soldeCompteEmetteur = soldeCompteEmetteur;
	}

	public void setMontantVirement(float montantVirement) {
		this.montantVirement = montantVirement;
	}
}
