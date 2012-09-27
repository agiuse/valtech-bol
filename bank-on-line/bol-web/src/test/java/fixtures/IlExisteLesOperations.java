package fixtures;

import com.valtech.testutils.CompteServiceFactory;

import fitnesse.fixtures.RowEntryFixture;


public class IlExisteLesOperations extends RowEntryFixture {
    public String numeroCompte;
    public String dateOperation;
    public String libelleOperation;
    public float montant;

    public void enterRow() throws Exception {
        CompteServiceFactory.service().addOperation(numeroCompte, dateOperation,libelleOperation, montant); 
    }
}
