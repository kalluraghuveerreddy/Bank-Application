package org.codehere.bank.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "bank")
@Setter
@Getter
@Component
public class BankContactInfoDto {

    private List<String> contactInfo;
    private List<String> onCallSupport;

}
