package resumeselector.Resume.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resumeselector.Resume.Repositories.CompanyRepositiory;
import resumeselector.Resume.models.Company;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepositiory companyRepositiory;
    public Company saveCompany(Company company) {
        return companyRepositiory.save(company);
    }
    public Company getCompanyNameByUsername(String username) {
        Company company = companyRepositiory.findByUsername(username);
        return company;
    }
}

