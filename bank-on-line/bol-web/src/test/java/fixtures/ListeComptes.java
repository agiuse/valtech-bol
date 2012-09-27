package fixtures;

import java.util.List;

import com.om.query.QueryResultBuilder;
import com.om.query.domain.QueryResult;
import com.valtech.bankonline.service.Compte;
import com.valtech.testutils.CompteServiceFactory;

public class ListeComptes {

	private String referenceClient;

	public ListeComptes(String refClient) {
		referenceClient = refClient;
	}

	public List<Object> query() throws Exception {
		List<Compte> listeComptes = CompteServiceFactory.service().getComptes(
				referenceClient);
		QueryResultBuilder builder = new QueryResultBuilder(Compte.class);
		QueryResult result = builder.build(listeComptes);
		return result.render();
	}

}
