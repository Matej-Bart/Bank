package accounts.serialization;

import accounts.BankAccount;
import tools.jackson.dataformat.xml.XmlMapper;

import java.util.LinkedList;
import java.util.List;

public class BankAccountJacksonXmlSerializer implements BankAccountSerializer {
    XmlMapper xmlMapper = new XmlMapper();

    BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {
        List<BankAccountSerialize> bankAccountSerialize = new LinkedList<>();

        for (BankAccount bankAccount : bankAccounts) {
            bankAccountSerialize.add(bankAccountSerializeFactory.createBankAccountSerialize(bankAccount));
        }
        return xmlMapper.writer().withRootName("root").writeValueAsString(bankAccountSerialize);
    }

    @Override
    public String serialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize = bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);
        return xmlMapper.writeValueAsString(bankAccountSerialize);
    }

}
