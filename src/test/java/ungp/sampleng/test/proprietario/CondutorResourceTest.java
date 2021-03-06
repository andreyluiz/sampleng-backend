package ungp.sampleng.test.proprietario;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import ungp.sampleng.backend.entity.Condutor;
import ungp.sampleng.test.BaseTest;
import ungp.sampleng.test.PreCondition;
import ungp.sampleng.test.PreConditionRule;
import ungp.sampleng.test.ServerClassRule;

public class CondutorResourceTest extends BaseTest {

    @Test
    @PreCondition(CondutorResourceCondition.class)
    public void test_findById() {
        Condutor proprietario = getWebTarget().path("condutor/11122233344").request().get(Condutor.class);
        Assert.assertNotNull(proprietario);
        Assert.assertEquals("John Java", proprietario.getNome());
    }

    @Test
    public void test_insert() {
    	Condutor proprietario = CondutorResourceCondition.createProprietario();

        getWebTarget().path("condutor").request()
                .post(Entity.entity(proprietario, MediaType.APPLICATION_JSON_TYPE),
                		Condutor.class);

        proprietario = getWebTarget().path("condutor/11122233344").request().get(Condutor.class);

        Assert.assertEquals("John Java", proprietario.getNome());
    }
}
