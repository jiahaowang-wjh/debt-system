package com.smart.bracelet.dao.debt;

import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {

    int delBusReport(Long id);
    int delBusRelativePerson(Long id);
    int delBusCivil(Long id);
    int delPubDebt(Long id);
    int delBusPropert(Long id);
    int delBusAssessment(Long id);
    int delBusAssignmentAgreement(Long id);
    int delBusAssignmentConfirm(Long id);
    int delBusConfirm(Long id);
    int delBusAssignmentNotice(Long id);
    int delBusAgentSalesContract(Long id);
    int delBusCollectionLetter(Long id);
    int delCumoutProtocol(Long id);

}
