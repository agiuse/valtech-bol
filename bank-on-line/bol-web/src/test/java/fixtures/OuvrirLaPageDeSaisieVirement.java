package fixtures;

import com.valtech.bankonline.service.BankTimeService;
import com.valtech.bankonline.service.Compte;
import com.valtech.bankonline.service.Operation;
import com.valtech.bankonline.service.TimeService;
import com.valtech.testutils.CompteServiceFactory;

import fit.Fixture;
import fitlibrary.DoFixture;
import fitlibrary.ParamRowFixture;

public class OuvrirLaPageDeSaisieVirement extends DoFixture {

	
	public OuvrirLaPageDeSaisieVirement() {
		super();
		CompteServiceFactory.nouvelleBase();
	}

	public boolean ilExisteLeCompteDSingleQuoteUnSoldeDe(String numeroCompte, float solde) {
		CompteServiceFactory.service().creerCompte(
				new Compte("", numeroCompte, "", solde));
		return true;
	}

	public boolean lSingleQuoteUtilisateurVireDepuisVersAvecLeLibelle(float montant,
			String numeroCompteEmetteur, String numeroCompteDestinataire, String libelle)
			throws Exception {

		TimeService originalTimeService = BankTimeService.instance;
		BankTimeService.instance = new TestTimeService();

		CompteServiceFactory.service().transfert(numeroCompteEmetteur, numeroCompteDestinataire,
				montant, libelle);

		BankTimeService.instance = originalTimeService;

		return true;
	}

	public boolean verifierCompteSolde(String compte, float solde) throws Exception {
		return CompteServiceFactory.service().getCompte(compte).solde == solde;
	}

	public Fixture verifierDetail(String referenceCompte) throws Exception {
		return new ParamRowFixture(CompteServiceFactory.service().getCompte(referenceCompte).getDetail()
				.toArray(new Operation[0]), Operation.class);
	}
}
