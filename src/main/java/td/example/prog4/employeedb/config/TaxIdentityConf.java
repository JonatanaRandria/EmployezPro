package td.example.prog4.employeedb.config;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TaxIdentityConf {
    private String nif;
    private String stat;
    private String rcs;

}
