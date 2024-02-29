package org.chnu.companyservicelab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CompanyServiceTests {
    @Test
    public void testGetTopLevelParent() {
        Company parent = new Company(null, 5);
        Company child = new Company(parent, 3);
        ICompanyService companyService = new CompanyService();
        Assertions.assertEquals(parent, companyService.getTopLevelParent(child));
    }

    @Test
    public void testGetTopLevelParentWithNullParent() {
        Company company = new Company(null, 5);
        ICompanyService companyService = new CompanyService();
        Assertions.assertEquals(company, companyService.getTopLevelParent(company));
    }

    @Test
    public void testGetTopLevelParentWithMultipleLevels() {
        Company grandParent = new Company(null, 5);
        Company parent = new Company(grandParent, 4);
        Company child = new Company(parent, 3);
        ICompanyService companyService = new CompanyService();
        Assertions.assertEquals(grandParent, companyService.getTopLevelParent(child));
    }

    @Test
    public void testGetEmployeeCountForCompanyAndChildren() {
        Company parent = new Company(null, 5);
        Company child1 = new Company(parent, 3);
        Company child2 = new Company(parent, 2);
        List<Company> companies = Arrays.asList(parent, child1, child2);
        ICompanyService companyService = new CompanyService();
        Assertions.assertEquals(10, companyService.getEmployeeCountForCompanyAndChildren(parent, companies));
    }

    @Test
    public void testGetEmployeeCountForCompanyAndChildrenWithNoChildren() {
        Company parent = new Company(null, 5);
        List<Company> companies = List.of(parent);
        ICompanyService companyService = new CompanyService();
        Assertions.assertEquals(5, companyService.getEmployeeCountForCompanyAndChildren(parent, companies));
    }

    @Test
    public void testGetEmployeeCountForCompanyAndChildrenWithNestedChildren() {
        Company grandParent = new Company(null, 4);
        Company parent = new Company(grandParent, 3);
        Company child = new Company(parent, 2);
        List<Company> companies = Arrays.asList(grandParent, parent, child);
        ICompanyService companyService = new CompanyService();
        Assertions.assertEquals(9, companyService.getEmployeeCountForCompanyAndChildren(grandParent, companies));
    }

    @Test
    public void testGetTopLevelParentWithSelfParent() {
        Company company = new Company(null, 5);
        company.setParent(company);

        ICompanyService companyService = new CompanyService();

        Assertions.assertThrows(StackOverflowError.class, () -> companyService.getTopLevelParent(company));
    }

    @Test
    public void testGetEmployeeCountForCompanyAndChildrenWithSelfParent() {
        Company company = new Company(null, 5);
        company.setParent(company);
        List<Company> companies = Arrays.asList(company);

        ICompanyService companyService = new CompanyService();

        Assertions.assertThrows(StackOverflowError.class, () -> companyService.getEmployeeCountForCompanyAndChildren(company, companies));
    }

    @Test
    public void testGetEmployeeCountForCompanyAndChildrenWithNonExistingCompany() {
        Company company = new Company(null, 5);
        List<Company> companies = Arrays.asList();

        ICompanyService companyService = new CompanyService();

        Assertions.assertEquals(5, companyService.getEmployeeCountForCompanyAndChildren(company, companies));
    }

    @Test
    public void testGetEmployeeCountForCompanyAndChildrenWithNoEmployees() {
        Company parent = new Company(null, 0);
        Company child1 = new Company(parent, 0);
        Company child2 = new Company(parent, 0);
        List<Company> companies = Arrays.asList(parent, child1, child2);

        ICompanyService companyService = new CompanyService();

        Assertions.assertEquals(0, companyService.getEmployeeCountForCompanyAndChildren(parent, companies));
    }

    @Test
    public void testGetEmployeeCountForCompanyAndChildrenWithOneChild() {
        Company parent = new Company(null, 2);
        Company child = new Company(parent, 3);
        List<Company> companies = Arrays.asList(parent, child);

        ICompanyService companyService = new CompanyService();

        Assertions.assertEquals(5, companyService.getEmployeeCountForCompanyAndChildren(parent, companies));
    }

    @Test
    public void testGetEmployeeCountForCompanyAndChildrenWithCircularReference() {
        Company parent = new Company(null, 2);
        Company child = new Company(parent, 3);
        parent.setParent(child);
        List<Company> companies = Arrays.asList(parent, child);

        ICompanyService companyService = new CompanyService();

        Assertions.assertThrows(StackOverflowError.class, () -> companyService.getEmployeeCountForCompanyAndChildren(parent, companies));
    }
}
