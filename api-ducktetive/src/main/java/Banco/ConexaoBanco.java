package Banco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConexaoBanco {
    private JdbcTemplate conexaoBanco;

    private JdbcTemplate conexaoBancoAWS;

    public ConexaoBanco(){
        // CONEXÃO LOCAL
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/Ducktetive");
        dataSource.setUsername("root");
        dataSource.setPassword("userAdm003");

        conexaoBanco = new JdbcTemplate(dataSource);

        // CONEXÃO AZURE
        BasicDataSource dataSourceAWS = new BasicDataSource();
        dataSourceAWS.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSourceAWS.setUrl("jdbc:sqlserver://44.203.84.7:1433;databaseName=Ducktetive;encrypt=true;trustServerCertificate=false;");
        dataSourceAWS.setUsername("sa");
        dataSourceAWS.setPassword("urubu100");

        conexaoBancoAWS = new JdbcTemplate(dataSourceAWS);

    }

    public JdbcTemplate getConexaoBancoAWS() {
        return conexaoBancoAWS;
    }

    public JdbcTemplate getConexaoBanco(){
        return conexaoBanco;
    }
}
