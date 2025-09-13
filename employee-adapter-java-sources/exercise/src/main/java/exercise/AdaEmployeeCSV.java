package exercise;

public class AdaEmployeeCSV implements Employee {
    private final EmployeeCSV employeeCSV;
    private String[] tokens;

    public AdaEmployeeCSV(EmployeeCSV employeeCSV) {
        this.employeeCSV = employeeCSV;
        setTokens();
    }

    public void setTokens(){
        tokens = employeeCSV.tokens();
    }

    @Override
    public String getId(){
        return tokens[0];
    }

    @Override
    public String getFirstName(){
        return tokens[1];
    }
    
    @Override
    public String getLastName(){
        return tokens[2];
    }
    
    @Override
    public String getEmail(){
        return tokens[3];
    }
    
}
