package fixtures;

import com.valtech.bankonline.service.BankTimeService;
import com.valtech.bankonline.service.TimeService;
import com.valtech.testutils.CompteServiceFactory;

import fit.Fixture;

public class EffectuerVirement extends Fixture {
	private String numeroCompteEmetteur;
	private String numeroCompteDestinataire;

	public void virerCompteEmetteurCompteDestinataireLibelleMontant(
			String emetteur, String destinataire, String libelle, float montant)
			throws Exception {
		numeroCompteEmetteur = emetteur;
		numeroCompteDestinataire = destinataire;
		TimeService originalTimeService = BankTimeService.instance;
		BankTimeService.instance = new TestTimeService();

		CompteServiceFactory.service().transfert(numeroCompteEmetteur,
				numeroCompteDestinataire, montant, libelle);

		BankTimeService.instance = originalTimeService;
	}

	public float soldeCompteEmetteur() throws Exception {
		return CompteServiceFactory.service().getCompte(numeroCompteEmetteur).solde;
	}

	public float soldeCompteDestinataire() throws Exception {
		return CompteServiceFactory.service().getCompte(
				numeroCompteDestinataire).solde;
	}
}
