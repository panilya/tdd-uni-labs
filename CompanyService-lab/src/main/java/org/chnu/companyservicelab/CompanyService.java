package org.chnu.companyservicelab;

import java.util.List;

public class CompanyService implements ICompanyService {
    @Override
    public Company getTopLevelParent(Company child) {
        if (child.getParent() == null) {
            return child;
        }
        return getTopLevelParent(child.getParent());
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        long count = company.getEmployeeCount();

        for (Company child : companies) {
            if (child.getParent() != null && child.getParent().equals(company)) {
                count += getEmployeeCountForCompanyAndChildren(child, companies);
            }
        }
        return count;
    }
}
