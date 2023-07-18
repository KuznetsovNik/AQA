package gor_api.deposit_service;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Factory;

@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6325585")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6329021")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6329029")
@TmsLink("https://vmmreg32.testrail.net/index.php?/cases/view/6329034")
public class FactoryCreationNewDepositAgreementTest {

    @Factory
    public Object[] factoryCreationNewDeposit() {
        return new Object[]{
                new CreationNewDepositAgreementTest(1),
                new CreationNewDepositAgreementTest(2),
                new CreationNewDepositAgreementTest(3),
                new CreationNewDepositAgreementTest(4)};
    }
}