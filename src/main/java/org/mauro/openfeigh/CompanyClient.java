package org.mauro.openfeigh;

import org.mauro.model.Company;
import org.mauro.model.CompanyAnswer;
import org.mauro.model.CompanyPageAnswer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "company", url = "http://localhost:8081/template/v1/company")
public interface CompanyClient {

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    CompanyPageAnswer getCompanies();

    @RequestMapping(method = RequestMethod.GET, value = "/searchByName/{name}", consumes = "application/json")
    CompanyAnswer findCompanyByName(@PathVariable("name") final String name);

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    CompanyAnswer getPostById(@RequestBody final Company postId);
}
