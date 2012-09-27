package fixtures;

import com.valtech.bankonline.service.Client;

import fitnesse.fixtures.RowEntryFixture;

public class IlExisteLesClients extends RowEntryFixture {
	public String referenceClient;
	public String motDePasse;
	
	
	public IlExisteLesClients() {
		super();
		TablesPipe.clients.clear();
	}


	@Override
	public void enterRow() throws Exception {
		TablesPipe.clients.add(new Client(referenceClient, motDePasse));
	}

}
