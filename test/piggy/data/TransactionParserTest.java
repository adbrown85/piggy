package piggy.data;

import java.io.File;
import java.util.List;
import org.junit.Test;


public class TransactionParserTest {
    
    @Test
    public void testParse() throws Exception {
        
        File file = new File("test/sample.qif");
        List<Transaction> transactions = TransactionParser.parse(file);
        
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
