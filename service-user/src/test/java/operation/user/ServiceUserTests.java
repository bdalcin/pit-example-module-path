package operation.user;

import java.util.ServiceLoader;

import org.junit.Test;

import operation.Operation;

import static org.junit.Assert.assertEquals;

public class ServiceUserTests {

    @Test
    public void shouldRenderTheResultingOperation() {
        Operation operation = ServiceLoader.load(Operation.class).findFirst().get();

        var actualRendering = new ServiceUser().render(operation);

        assertEquals("Rendering multiplication", actualRendering);
    }
}