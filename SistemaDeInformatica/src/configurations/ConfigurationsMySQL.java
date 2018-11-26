/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurations;

/**
 *
 * @author vinicius
 */
public class ConfigurationsMySQL extends Configurations{

    public ConfigurationsMySQL() {
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "vini";
        super.PASS = "Vinicius_2201";
        super.PORT = "3306";
        super.BASE = "sistemainformatica";
        super.DRIV = "com.mysql.jdbc.Driver";
    }
    
}
