package org.mauro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyPageAnswer {
    List<Company> companies;
    int page;
    int pageSize;
    int totalPages;
    long totalItems;
}
