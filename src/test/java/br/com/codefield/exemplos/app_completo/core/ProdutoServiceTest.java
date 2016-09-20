package br.com.codefield.exemplos.app_completo.core;

import br.com.codefield.exemplos.app_completo.api.modelo.Produto;
import br.com.codefield.exemplos.app_completo.config.AppTestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author carlos.oliveira
 * @since 2016-09-20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppTestConfig.class})
@Transactional
public class ProdutoServiceTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void salvar() {
        this.em.persist(new Produto());
        this.em.flush();

        List<Produto> produtos = this.em.createQuery("SELECT p FROM Produto p").getResultList();

        Assert.assertEquals(1, produtos.size());
    }

}
