package br.com.codefield.exemplos.app_completo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author carlos.oliveira
 * @since 2016-09-20
 */
@Configuration
@ComponentScan("br.com.codefield.exemplos.app_completo.core")
@EnableTransactionManagement
public class AppTestConfig extends BeansDefault {


}
