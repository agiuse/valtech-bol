package fixtures;

import java.util.List;

import com.om.query.QueryResultBuilder;
import com.om.query.domain.QueryResult;
import com.valtech.bankonline.service.Operation;
import com.valtech.testutils.CompteServiceFactory;

public class ConsulterDetail {

	private String referenceClient;

	public ConsulterDetail(String refClient) {
		referenceClient = refClient;
	}

	public List<Object> query() throws Exception {
		List<Operation> listeOperations = CompteServiceFactory.service()
				.getCompte(referenceClient).getDetail();
		QueryResultBuilder builder = new QueryResultBuilder(Operation.class);
		QueryResult result = builder.build(listeOperations);
		return result.render();
	}
}
