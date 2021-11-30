package org.mauro.openfeigh;

import org.mauro.model.CompanyAnswer;
import org.mauro.model.CompanyPageAnswer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableFeignClients
public class UserClientService {

    private final CompanyClient companyClient;

    public UserClientService(CompanyClient companyClient) {
        this.companyClient = companyClient;
    }

    public List<UserClient> getUsers() {
        CompanyPageAnswer page = companyClient.getCompanies();
        final List<UserClient> users = new ArrayList<>();
        page.getCompanies().forEach(company -> users.addAll(aggregateUser(company)));
        return users;
    }

    private List<UserClient> aggregateUser(final CompanyAnswer company) {
        if (company.getUsers() == null) {
            return new ArrayList<>();
        }
        return company.getUsers()
                .stream()
                .map(user -> UserClient.builder()
                        .address(user.getAddress())
                        .age(user.getAge())
                        .name(user.getName())
                        .CompanyAddress(company.getAddress())
                        .companyId(company.getId())
                        .companyName(company.getName()).build())
                .collect(Collectors.toList());
    }
}
